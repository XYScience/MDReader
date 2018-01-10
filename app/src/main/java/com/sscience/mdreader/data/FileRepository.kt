package com.sscience.mdreader.data

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import com.sscience.mdreader.R
import com.sscience.mdreader.entity.FileBean
import com.sscience.mdreader.listenter.DataCallBack
import com.sscience.mdreader.listenter.HtmlCallBack
import com.sscience.mdreader.util.FileUtil
import io.github.gitbucket.markedj.Marked
import java.io.File
import java.util.concurrent.Executors


/**
 * @author SScience
 * @description
 * @email chentushen.science@gmail.com
 * @data 2018/1/7
 */
class FileRepository {

    companion object {
        private val executor = Executors.newCachedThreadPool()
    }

    fun getFileList(file: File, callBack: DataCallBack) {
        executor.execute {
            val fileBeenList = mutableListOf<FileBean>()
            if (file.isDirectory) {
                val filesArray = file.listFiles()
                filesArray?.sortWith(FileUtil.comparator)
                filesArray?.
                        filterNot { it.isHidden }?.
                        mapTo(fileBeenList) {
                            FileBean(it.name, it.path, it.length(), it.lastModified(),
                                    FileUtil.getFileChildCount(it), FileUtil.getFileType(it))
                        }
            }
            val msg = Message()
            msg.what = 200
            msg.obj = fileBeenList
            val handler = object : Handler(Looper.getMainLooper()) {
                override fun handleMessage(msg: Message?) {
                    super.handleMessage(msg)
                    callBack.onFileList(msg?.obj as MutableList<FileBean>)
                }
            }
            handler.sendMessage(msg)
        }
    }

    fun getHtmlFileByMD(context: Context, intent: Intent, callBack: HtmlCallBack) {
        val mdPath: String?
        val htmlPath: String?
        if (intent.`package` != null && intent.`package` == context.packageName) {
            mdPath = intent.getStringExtra("path")
        } else {
            val uri = intent.data
            if (uri == null) {
                callBack.onError(context.getString(R.string.no_file_info))
                return
            }
            mdPath = FileUtil.getFilePathByUri(context, uri)
            if (mdPath == null) {
                callBack.onError(context.getString(R.string.parse_file_path_error))
                return
            }
        }
        // mdPath: /storage/emulated/0/test.md
        Log.e(">>>>>>>>>", "mdPath: $mdPath")
        val fileName = FileUtil.getFileName(mdPath)
        callBack.onLoadFileName(fileName)

        if (mdPath!!.endsWith(".html", true) || mdPath.endsWith(".htm", true)) {
            callBack.onLoadData("file://" + mdPath)
            return
        } else {
            val end = mdPath.lastIndexOf(".")
            // htmlPath：file:///storage/emulated/0/test.html
            htmlPath = mdPath.substring(0, end) + ".html"
        }

        executor.execute {
            val htmlData = Marked.marked(FileUtil.getDataByPath(mdPath))
            if (FileUtil.saveDataAsHtml(htmlPath, htmlData)) {
                val msg = Message()
                msg.what = 200
                msg.obj = htmlData
                val handler = object : Handler(Looper.getMainLooper()) {
                    override fun handleMessage(msg: Message?) {
                        super.handleMessage(msg)
                        callBack.onLoadData("file://" + htmlPath)
                    }
                }
                handler.sendMessage(msg)
            } else {
                callBack.onError(context.getString(R.string.md_to_html_error))
            }
        }
    }

}
