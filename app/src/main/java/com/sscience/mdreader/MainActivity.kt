package com.sscience.mdreader

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.KeyEvent
import android.view.View
import com.sscience.mdreader.adapter.FileAdapter
import com.sscience.mdreader.adapter.FileTitleAdapter
import com.sscience.mdreader.base.BaseActivity
import com.sscience.mdreader.data.FileRepository
import com.sscience.mdreader.entity.FIleTitleBean
import com.sscience.mdreader.entity.FileBean
import com.sscience.mdreader.entity.FileType
import com.sscience.mdreader.listenter.DataCallBack
import com.sscience.mdreader.listenter.OnItemClickListener
import com.sscience.mdreader.util.IntentUtil
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File


class MainActivity : BaseActivity() {

    private val MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 200
    private lateinit var fileAdapter: FileAdapter
    private lateinit var fileTitleAdapter: FileTitleAdapter
    private lateinit var rootPath: String
    private var lastPositionList: MutableList<String> = mutableListOf()
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var fileRepository: FileRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFileTile()
        initFile()
        init()
    }

    private fun initFileTile() {
        fileTitleAdapter = FileTitleAdapter(this)
        title_recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        title_recycler_view.setHasFixedSize(true)
        title_recycler_view.adapter = fileTitleAdapter

        fileTitleAdapter.setOnItemClickListener(object : OnItemClickListener<FIleTitleBean> {
            override fun onItemClick(data: FIleTitleBean, position: Int) {
                val count = fileTitleAdapter.itemCount
                val removeCount = count - position - 1
                for (i in 0 until removeCount) {
                    fileTitleAdapter.removeLastItem()
                }
                getFiles(data.filePath, lastPositionList.size - 1 - position)
            }
        })
    }

    private fun initFile() {
        fileAdapter = FileAdapter(this)
        layoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = layoutManager
        recycler_view.setHasFixedSize(true)
        recycler_view.addItemDecoration(DividerItemDecoration(this, layoutManager.orientation))
        recycler_view.adapter = fileAdapter
        fileAdapter.setOnItemClickListener(object : OnItemClickListener<FileBean> {
            override fun onItemClick(data: FileBean, position: Int) {
                savePosition()

                val fileType = data.fileType
                when (fileType) {
                    FileType.DIRECTORY -> {
                        getFiles(data.path, -1)
                        updateFileTitle(data.name, data.path)
                    }
                    FileType.TXT -> IntentUtil.openTextIntent(this@MainActivity, File(data.path))
                    FileType.APK -> IntentUtil.installAppIntent(this@MainActivity, File(data.path))
                    FileType.HTML -> IntentUtil.startMDWebViewActivity(this@MainActivity, data)
                    FileType.IMAGE -> IntentUtil.openImageIntent(this@MainActivity, File(data.path))
                    FileType.MUSIC -> IntentUtil.openMusicIntent(this@MainActivity, File(data.path))
                    FileType.VIDEO -> IntentUtil.openVideoIntent(this@MainActivity, File(data.path))
                    FileType.MD -> IntentUtil.startMDWebViewActivity(this@MainActivity, data)
                    else -> IntentUtil.openApplicationIntent(this@MainActivity, File(data.path))
                }
            }

            override fun onItemLongClick(data: FileBean, position: Int) {
                super.onItemLongClick(data, position)
                val fileType = data.fileType
                when (fileType) {
                    FileType.HTML -> IntentUtil.openApplicationIntent(this@MainActivity, File(data.path))
                    FileType.MD -> IntentUtil.openApplicationIntent(this@MainActivity, File(data.path))
                }
            }
        })
    }

    /**
     * 保存当前 item 位置
     */
    private fun savePosition() {
        val position = layoutManager.findFirstVisibleItemPosition()
        val view = layoutManager.findViewByPosition(position)
        if (view != null) {
            val top = view.top
            lastPositionList.add(position.toString() + "&" + top.toString())
        }
    }

    private fun init() {
        toolbar.title = getString(R.string.app_name)
        fileRepository = FileRepository()
        rootPath = Environment.getExternalStorageDirectory().absolutePath
        updateFileTitle(getString(R.string.internal_storage_device), rootPath)
        checkSelfPermission()
    }

    override fun onResume() {
        super.onResume()
        val fileTitleList: List<FIleTitleBean> = fileTitleAdapter.getDatas()
        val path = fileTitleList[fileTitleList.size - 1].filePath
        getFiles(path, -1)
    }

    // 更新顶部文件位置
    private fun updateFileTitle(title: String, path: String) {
        val fileTileBean = FIleTitleBean(title + " >", path)
        fileTitleAdapter.addItem(fileTileBean)
        title_recycler_view.smoothScrollToPosition(fileTitleAdapter.itemCount)
    }

    // 获取文件列表
    private fun getFiles(path: String, removeCount: Int) {
        val file = File(path + File.separator)
        fileRepository.getFileList(file, object : DataCallBack {
            override fun onFileList(fileBeanList: MutableList<FileBean>) {
                recycler_view.visibility = if (fileBeanList.isEmpty()) View.GONE else View.VISIBLE
                fileAdapter.addData(fileBeanList)
                revertPosition(removeCount)

                if (fileBeanList.isEmpty()) {
                    ll_loading.visibility = View.VISIBLE
                    tv_loading.text = getString(R.string.empty_file)
                    val drawable: Drawable = resources.getDrawable(R.drawable.ic_empty_grey_600_48dp)
                    drawable.setBounds(0, 0, drawable.minimumWidth, drawable.minimumHeight)
                    tv_loading.setCompoundDrawables(null, drawable, null, null)
                } else {
                    ll_loading.visibility = View.GONE
                }
            }
        })
    }

    /**
     * 还原上一级位置
     */
    private fun revertPosition(removeCount: Int) {
        if (removeCount == -1) {
            return
        }
        for (i in 0 until removeCount) {
            lastPositionList.removeAt(lastPositionList.size - 1)
        }
        val lastPosition: String = lastPositionList[lastPositionList.size - 1]
        val po: List<String> = lastPosition.split("&")
        layoutManager.scrollToPositionWithOffset(po[0].toInt(), po[1].toInt())

        lastPositionList.removeAt(lastPositionList.size - 1)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && event?.repeatCount == 0) {
            val fileTitleList: List<FIleTitleBean> = fileTitleAdapter.getDatas()
            if (fileTitleList.size == 1) {
                finish()
            } else {
                fileTitleAdapter.removeItem(fileTitleList.size - 1)
                getFiles(fileTitleList[fileTitleList.size - 1].filePath, 0)
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun checkSelfPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                // 用户拒绝过我们的权限申请但是没有勾选 "不再提醒"，可以做个提示
                permissionDenied(getString(R.string.denied_permission_and_tip), getString(R.string.confirm))
            } else {
                // shouldShowRequestPermissionRationale返回false：有两种可能，一是我们第一次申请权限的时候，二是用户选择了 "不再提醒"
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                        MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE)
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getFiles(rootPath, -1)
            } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
                    permissionDenied(getString(R.string.denied_permission_and_tip),
                            getString(R.string.confirm))
                } else {
                    permissionDenied(getString(R.string.denied_permission_and_dont_tip),
                            getString(R.string.goto_open))
                }
            }
        }
    }

    private fun permissionDenied(msg: String, positiveBtn: String) {
        AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle(getString(R.string.request_permission))
                .setMessage(msg)
                .setPositiveButton(positiveBtn) { dialog, _ ->
                    if (positiveBtn == getString(R.string.confirm)) {
                        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                                MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE)
                    } else {
                        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                        val uri = Uri.fromParts("package", packageName, null)
                        intent.data = uri
                        startActivity(intent)
                    }
                    dialog.dismiss()
                }
                .setNegativeButton(getString(R.string.cancel), null)
                .show()
    }

}
