package com.sscience.mdreader.util

import android.content.ContentResolver
import android.content.ContentUris
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.DocumentsContract
import android.provider.MediaStore
import android.text.TextUtils
import com.sscience.mdreader.entity.FileType
import java.io.BufferedReader
import java.io.File
import java.io.FileOutputStream
import java.io.FileReader


/**
 * @author SScience
 * @description
 * @email chentushen.science@gmail.com
 * @data 2018/1/6
 */
class FileUtil {

    companion object {

        fun getFilePathByUri(context: Context, uri: Uri): String? {
            // content://com.mi.android.globalFileexplorer.myprovider/external_files/Android%E7%9F%A5%E8%AF%86%E7%82%B9.md
            // content://com.sscience.mdreader.fileProvider/external_storage_root/Android%E7%9F%A5%E8%AF%86%E7%82%B9.md
            // 1，Android 4.4+ && DocumentProvider
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT && DocumentsContract.isDocumentUri(context, uri)) {
                // ExternalStorageProvider
                val docId: String = DocumentsContract.getDocumentId(uri)
                if (isExternalStorageDocument(uri)) {
                    val split: List<String> = docId.split(":")
                    val type: String = split[0]
                    if ("primary".equals(type, ignoreCase = true)) {
                        return Environment.getExternalStorageDirectory().toString() + "/" + split[1]
                    }
                }
                // DownloadsProvider
                else if (isDownloadsDocument(uri)) {
                    val contentUri: Uri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"),
                            docId.toLong())
                    return getDataByColumn(context, contentUri, null, null)
                }
                // MediaProvider
                else if (isMediaDocument(uri)) {
                    val split: List<String> = docId.split(":")
                    val type: String = split[0]
                    var contentUri: Uri? = null
                    when (type) {
                        "image" -> contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                        "video" -> contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI
                        "audio" -> contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
                    }
                    val selection = "_id=?"
                    val selectionArgs = arrayOf(split[1])
                    return getDataByColumn(context, contentUri, selection, selectionArgs)
                }
            }
            // 2，general content://xxx
            else if (ContentResolver.SCHEME_CONTENT.equals(uri.scheme, ignoreCase = true)) {
                return getDataByColumn(context, uri, null, null)
            }
            // 3，file://xxx
            else if (ContentResolver.SCHEME_FILE.equals(uri.scheme, ignoreCase = true)) {
                return uri.path
            }
            return null
        }

        private fun getDataByColumn(context: Context, uri: Uri?, selection: String?, selectionArgs: Array<String>?): String? {
            val data = MediaStore.MediaColumns.DATA
            val projection = arrayOf(data)
            var cursor: Cursor? = null
            try {
                cursor = context.contentResolver.query(uri, projection, selection, selectionArgs, null)
                if (cursor != null && cursor.moveToFirst()) {
                    val columnIndex = cursor.getColumnIndex(data)
                    return if (columnIndex > -1) {
                        cursor.getString(columnIndex)
                    } else {
                        null
                    }
                }
            } finally {
                cursor?.close()
            }
            return null
        }

        /**
         * @param uri The Uri to check.
         * @return Whether the Uri authority is ExternalStorageProvider.
         */
        private fun isExternalStorageDocument(uri: Uri): Boolean {
            return "com.android.externalstorage.documents" == uri.authority
        }

        /**
         * @param uri The Uri to check.
         * @return Whether the Uri authority is DownloadsProvider.
         */
        private fun isDownloadsDocument(uri: Uri): Boolean {
            return "com.android.providers.downloads.documents" == uri.authority
        }

        /**
         * @param uri The Uri to check.
         * @return Whether the Uri authority is MediaProvider.
         */
        private fun isMediaDocument(uri: Uri): Boolean {
            return "com.android.providers.media.documents" == uri.authority
        }

        fun getDataByPath(path: String?): String {
            if (TextUtils.isEmpty(path)) {
                return ""
            }
            val sb = StringBuilder()
            var fr: FileReader? = null
            var br: BufferedReader? = null
            try {
                fr = FileReader(path)
                br = BufferedReader(fr)
                var readLine: String
                while (true) {
                    readLine = br.readLine() ?: break
                    sb.append(readLine)
                    sb.append("\n")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                fr?.close()
                br?.close()
            }

            val codeBlock = "\n" + "```" + "\n"
            return sb.toString().replace("```", codeBlock)
        }

        fun saveDataAsHtml(path: String?, text: String): Boolean {
            if (TextUtils.isEmpty(path) || TextUtils.isEmpty(text)) {
                return false
            }
            val file = File(path)
            val html: String = CSS.github2 + text + CSS.end
            var fos: FileOutputStream? = null
            try {
                fos = FileOutputStream(file)
                fos.write(html.toByteArray())
            } catch (e: Exception) {
                e.printStackTrace()
                return false
            } finally {
                fos?.close()
            }
            return true
        }

        fun getFileType(file: File): FileType {
            if (file.isDirectory) {
                return FileType.DIRECTORY
            }

            val fileName: String = file.name.toLowerCase()

            if (fileName.endsWith(".txt") || fileName.endsWith(".log") || fileName.endsWith(".xml")) {
                return FileType.TXT
            }
            if (fileName.endsWith(".md")) {
                return FileType.MD
            }
            if (fileName.endsWith(".html") || fileName.endsWith(".htm")) {
                return FileType.HTML
            }
            if (fileName.endsWith(".mp3")) {
                return FileType.MUSIC
            }
            if (fileName.endsWith(".mp4") || fileName.endsWith(".avi")
                    || fileName.endsWith(".3gp") || fileName.endsWith(".mov")
                    || fileName.endsWith(".rmvb") || fileName.endsWith(".mkv")
                    || fileName.endsWith(".flv") || fileName.endsWith(".rm")) {
                return FileType.VIDEO
            }

            if (fileName.endsWith(".zip") || fileName.endsWith(".rar") || fileName.endsWith(".7z")
                    || fileName.endsWith(".tar") || fileName.endsWith(".jar") || fileName.endsWith(".gzip")) {
                return FileType.ZIP
            }

            if (fileName.endsWith(".png") || fileName.endsWith(".gif")
                    || fileName.endsWith(".jpeg") || fileName.endsWith(".jpg")) {
                return FileType.IMAGE
            }

            if (fileName.endsWith(".apk")) {
                return FileType.APK
            }

            return FileType.OTHER
        }

        fun getFileChildCount(file: File): String {
            var count = 0
            if (file.isDirectory) {
                val files: Array<File> = file.listFiles()
                files
                        .filterNot { it.isHidden }
                        .forEach { count++ }
            }
            return count.toString() + "项"
        }

        var comparator = Comparator<File> { file1, file2 ->
            if (file1.isDirectory && file2.isFile) {
                -1
            } else if (file1.isFile && file2.isDirectory) {
                1
            } else {
                file1.name.compareTo(file2.name, true)
            }
        }

        fun sizeToChange(size: Long): String {
            val df = java.text.DecimalFormat("#.00")  //保留2位小数

            val g = size * 1.0 / 1024.0 / 1024.0 / 1024.0
            if (g >= 1) {
                return df.format(g) + " GB"
            }

            val m = size * 1.0 / 1024.0 / 1024.0
            if (m >= 1) {
                return df.format(m) + " MB"
            }

            val k = size * 1.0 / 1024
            return if (k >= 1) {
                df.format(k) + " KB"
            } else size.toString() + " B"

        }

        fun getFileName(path: String?): String? {
            if (path == null) return null
            var fileName: String? = null
            val cut = path.lastIndexOf('/')
            if (cut != -1) {
                fileName = path.substring(cut + 1)
            }
            return fileName
        }
    }
}