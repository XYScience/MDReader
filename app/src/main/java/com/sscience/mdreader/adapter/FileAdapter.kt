package com.sscience.mdreader.adapter

import android.content.Context
import android.view.View
import com.sscience.mdreader.R
import com.sscience.mdreader.base.BaseAdapter
import com.sscience.mdreader.base.ViewHolder
import com.sscience.mdreader.entity.FileBean
import com.sscience.mdreader.entity.FileType
import com.sscience.mdreader.util.FileUtil
import com.sscience.mdreader.util.TimeUtils
import kotlinx.android.synthetic.main.item_file.view.*

/**
 * @author SScience
 * @description
 * @email chentushen.science@gmail.com
 * @data 2018/1/7
 */
class FileAdapter(context: Context) : BaseAdapter<FileBean>(context) {
    override fun getItemLayoutId(): Int {
        return R.layout.item_file
    }

    override fun bindViewHolder(viewHolder: ViewHolder, data: List<FileBean>, position: Int) {
        val convertView: View = viewHolder.getConvertView()
        val fileBean = data[position]
        viewHolder.setText(convertView.tv_file_name, fileBean.name)
                .setImageResource(convertView.img_file, getFileImage(fileBean.fileType))
                .setText(convertView.tv_file_details, getFileDetails(fileBean))
                .setImageVisibility(convertView.img_file_more, getFileMoreVisibility(fileBean))
    }

    private fun getFileImage(fileType: FileType): Int {
        return when (fileType) {
            FileType.DIRECTORY -> R.drawable.ic_folder_grey_600_48dp
            FileType.TXT -> R.drawable.ic_file_grey_600_48dp
            FileType.MD -> R.drawable.ic_markdown_grey_600_48dp
            FileType.HTML -> R.drawable.ic_html_grey_600_48dp
            FileType.ZIP -> R.drawable.ic_zip_grey_600_48dp
            FileType.VIDEO -> R.drawable.ic_video_grey_600_48dp
            FileType.MUSIC -> R.drawable.ic_music_grey_600_48dp
            FileType.IMAGE -> R.drawable.ic_image_grey_600_48dp
            FileType.APK -> R.drawable.ic_apk_grey_600_48dp
            else -> {
                R.drawable.ic_unknown_grey_600_48dp
            }
        }
    }

    private fun getFileDetails(fileBean: FileBean): String {
        val lastModified = TimeUtils.getAllDateTime(fileBean.lastModified)
        return when (fileBean.fileType) {
            FileType.DIRECTORY -> fileBean.childCount + " | " + lastModified
            else -> {
                FileUtil.sizeToChange(fileBean.size) + " | " + lastModified
            }
        }
    }

    private fun getFileMoreVisibility(fileBean: FileBean) =
            if (fileBean.fileType == FileType.DIRECTORY) View.VISIBLE else View.GONE

}