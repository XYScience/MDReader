package com.sscience.mdreader.activity

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Build
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
        // 设置全屏显示
        var suv = window.decorView.systemUiVisibility
        suv = suv or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        window.decorView.systemUiVisibility = suv
        // Android 6.0+：#20000000的状态栏 + 灰色状态栏图标
        // Android 5.x：#40000000的状态栏 + 白色状态栏图标
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.statusBarColor = Color.parseColor("#20000000")
        }

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
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (webView != null) {
            (webView.parent as ViewGroup).removeView(webView)
            webView.destroy()
        }
    }
}