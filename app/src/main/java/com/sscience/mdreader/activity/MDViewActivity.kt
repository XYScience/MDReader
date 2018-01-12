package com.sscience.mdreader.activity

import android.app.ActivityManager
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import com.sscience.mdreader.R
import com.sscience.mdreader.base.BaseActivity
import com.sscience.mdreader.data.FileRepository
import com.sscience.mdreader.listenter.HtmlCallBack
import kotlinx.android.synthetic.main.activity_md_view.*


/**
 * @author SScience
 * @description
 * @email chentushen.science@gmail.com
 * @data 2018/1/9
 */
class MDViewActivity : BaseActivity() {

    private lateinit var fileRepository: FileRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_md_view)

        initView()
        getData()

    }

    private fun initView() {
        toolbar.title = getString(R.string.app_name)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        appbar_layout.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
            //            val maxScroll: Int? = appBarLayout?.totalScrollRange
//            val percentage: Float = Math.abs(verticalOffset).toFloat() / maxScroll!!.toFloat()
//            val color = CommonUtil.getColorWithAlpha("#E0E0E0", (1 - percentage / 4).toDouble())
//            window.statusBarColor = Color.parseColor(color)
        }

        val webSetting = webView.settings
        webSetting.layoutAlgorithm = WebSettings.LayoutAlgorithm.SINGLE_COLUMN
        webSetting.useWideViewPort = true
        webSetting.loadWithOverviewMode = true
        webSetting.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW

        fileRepository = FileRepository()

    }

    private fun getData() {
        fileRepository.getHtmlFileByMD(this, intent, object : HtmlCallBack {
            override fun onLoadFileName(fileName: String?) {
                setTaskDescription(ActivityManager.TaskDescription(fileName, null, 0))
                toolbar.title = fileName
            }

            override fun onLoadData(htmlPath: String) {
                webView.loadUrl(htmlPath)
                scrollView.visibility = View.VISIBLE
                ll_loading.visibility = View.GONE
            }

            override fun onError(error: String) {
                showToast(error)
                tv_loading.text = error
                val drawable: Drawable = resources.getDrawable(R.drawable.ic_error)
                drawable.setBounds(0, 0, drawable.minimumWidth, drawable.minimumHeight)
                tv_loading.setCompoundDrawables(null, drawable, null, null)
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAndRemoveTask()
//        overridePendingTransition(R.anim.slide_left_in, R.anim.slide_right_out)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (webView != null) {
            (webView.parent as ViewGroup).removeView(webView)
            webView.destroy()
        }
    }
}