package com.sscience.mdreader.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.support.v4.content.FileProvider
import com.sscience.mdreader.R
import com.sscience.mdreader.activity.MDViewActivity
import com.sscience.mdreader.entity.FileBean
import java.io.File

/**
 * @author SScience
 * @description
 * @email chentushen.science@gmail.com
 * @data 2018/1/9
 */
class IntentUtil {

    companion object {
        private fun getUri(context: Context, intent: Intent, file: File): Uri {
            val uri: Uri
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                uri = FileProvider.getUriForFile(context, "com.sscience.mdreader.fileProvider", file)
                intent.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
            } else {
                uri = Uri.fromFile(file)
            }
            return uri
        }

        fun installAppIntent(context: Context, file: File) {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            val uri: Uri = getUri(context, intent, file)
            intent.setDataAndType(uri, "application/vnd.android.package-archive")
            context.startActivity(intent)
        }

        fun openImageIntent(context: Context, file: File) {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            val uri: Uri = getUri(context, intent, file)
            intent.setDataAndType(uri, "image/*")
            context.startActivity(intent)
        }

        fun openTextIntent(context: Context, file: File) {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            val uri: Uri = getUri(context, intent, file)
            intent.setDataAndType(uri, "text/*")
            context.startActivity(intent)
        }

        fun openMusicIntent(context: Context, file: File) {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            val uri: Uri = getUri(context, intent, file)
            intent.setDataAndType(uri, "audio/*")
            context.startActivity(intent)
        }

        fun openVideoIntent(context: Context, file: File) {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            val uri: Uri = getUri(context, intent, file)
            intent.setDataAndType(uri, "video/*")
            context.startActivity(intent)
        }

        fun openApplicationIntent(context: Context, file: File) {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//            // 利用反射忽略 Android 7.0+ 的 content://uri 检查
//            val method: Method = StrictMode::class.java.getDeclaredMethod("disableDeathOnFileUriExposure")
//            method.invoke("")
            val uri: Uri = getUri(context, intent, file)
            intent.setDataAndType(uri, "application/*")
            context.startActivity(intent)
        }

        fun startMDWebViewActivity(activity: Activity, file: FileBean) {
            val intent = Intent(activity, MDViewActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT)  // 后台任务列表的形式打开
            //intent.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK)  // 以目标 Activity 作为根创建新任务
            intent.data = Uri.fromFile(File(file.name))
            intent.putExtra("path", file.path)
            intent.`package` = activity.packageName
            activity.startActivity(intent)
            activity.overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out)
        }

        fun sendFile(context: Context, file: File) {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file))
            intent.type = "*/*"//此处可发送多种文件
            context.startActivity(Intent.createChooser(intent, "发送"))
        }
    }
}