package com.sscience.mdreader

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFileTile()
        initFile()
    }

    private fun initFileTile() {
        fileTitleAdapter = FileTitleAdapter(this)
        title_recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        title_recycler_view.setHasFixedSize(true)
        title_recycler_view.adapter = fileTitleAdapter

        fileTitleAdapter.setOnItemClickListener(object : OnItemClickListener<FIleTitleBean> {
            override fun onItemClick(data: FIleTitleBean, position: Int) {
                getFiles(data.filePath)
                val count = fileTitleAdapter.itemCount
                val removeCount = count - position - 1
                for (i in 0 until removeCount) {
                    fileTitleAdapter.removeLastItem()
                }
            }
        })
    }

    private fun initFile() {
        fileAdapter = FileAdapter(this)
        val layoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = layoutManager
        recycler_view.setHasFixedSize(true)
        recycler_view.addItemDecoration(DividerItemDecoration(this, layoutManager.orientation))
        recycler_view.adapter = fileAdapter
        fileAdapter.setOnItemClickListener(object : OnItemClickListener<FileBean> {
            override fun onItemClick(data: FileBean, position: Int) {
                val fileType = data.fileType
                when (fileType) {
                    FileType.DIRECTORY -> {
                        getFiles(data.path)
                        updateFileTitle(data.name, data.path)
                    }
                    FileType.TXT -> IntentUtil.openTextIntent(this@MainActivity, File(data.path))
                    FileType.APK -> IntentUtil.installAppIntent(this@MainActivity, File(data.path))
                    FileType.HTML -> IntentUtil.openTextIntent(this@MainActivity, File(data.path))
                    FileType.IMAGE -> IntentUtil.openImageIntent(this@MainActivity, File(data.path))
                    FileType.MUSIC -> IntentUtil.openMusicIntent(this@MainActivity, File(data.path))
                    FileType.VIDEO -> IntentUtil.openVideoIntent(this@MainActivity, File(data.path))
                    else -> IntentUtil.openApplicationIntent(this@MainActivity, File(data.path))
                }
            }
        })
    }

    override fun onResume() {
        super.onResume()
        val fileTitleList: List<FIleTitleBean> = fileTitleAdapter.getDatas()
        if (fileTitleList.isEmpty()) {
            rootPath = Environment.getExternalStorageDirectory().absolutePath
            updateFileTitle(getString(R.string.internal_storage_device), rootPath)
        } else {
            rootPath = fileTitleList[fileTitleList.size - 1].filePath
        }
        checkSelfPermission()
    }

    // 更新顶部文件位置
    private fun updateFileTitle(title: String, path: String) {
        val fileTileBean = FIleTitleBean(title + " >", path)
        fileTitleAdapter.addItem(fileTileBean)
        title_recycler_view.smoothScrollToPosition(fileTitleAdapter.itemCount)
    }

    // 获取文件列表
    private fun getFiles(path: String) {
        val file = File(path + File.separator)
        FileRepository.getFileList(file, object : DataCallBack {
            override fun onFileList(fileBeanList: MutableList<FileBean>) {
                fileAdapter.addData(fileBeanList)
                ll_empty_file.visibility = if (fileBeanList.isEmpty()) View.VISIBLE else View.GONE
            }
        })
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && event?.repeatCount == 0) {
            val fileTitleList: List<FIleTitleBean> = fileTitleAdapter.getDatas()
            if (fileTitleList.size == 1) {
                finish()
            } else {
                fileTitleAdapter.removeItem(fileTitleList.size - 1)
                getFiles(fileTitleList[fileTitleList.size - 1].filePath)
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
        } else {
            getFiles(rootPath)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getFiles(rootPath)
            } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
                    checkSelfPermission()
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
                    dialog.dismiss()
                    if (TextUtils.equals(positiveBtn, getString(R.string.confirm))) {
                        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                                MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE)
                    } else {
                        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                        val uri = Uri.fromParts("package", packageName, null)
                        intent.data = uri
                        startActivity(intent)
                    }
                }
                .setNegativeButton(getString(R.string.cancel), null)
                .show()
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
