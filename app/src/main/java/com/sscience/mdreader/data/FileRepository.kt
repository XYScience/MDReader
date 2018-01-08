package com.sscience.mdreader.data

import android.os.Handler
import android.os.Message
import com.sscience.mdreader.entity.FileBean
import com.sscience.mdreader.listenter.DataCallBack
import com.sscience.mdreader.util.FileUtil
import java.io.File
import java.util.concurrent.Executors


/**
 * @author SScience
 * @description
 * @email chentushen.science@gmail.com
 * @data 2018/1/7
 */
object FileRepository {

    private val executor = Executors.newCachedThreadPool()
    private var callBack: DataCallBack? = null
    private val handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            if (msg.what == 200) {
                callBack?.onFileList(msg.obj as MutableList<FileBean>)
            }
        }
    }

    fun getFileList(file: File, callBack: DataCallBack) {
        this.callBack = callBack
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
            var msg = Message()
            msg.what = 200
            msg.obj = fileBeenList
            handler.sendMessage(msg)
        }
    }
}
