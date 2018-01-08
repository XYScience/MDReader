package com.sscience.mdreader.adapter

import android.content.Context
import android.view.View
import com.sscience.mdreader.R
import com.sscience.mdreader.base.BaseAdapter
import com.sscience.mdreader.base.ViewHolder
import com.sscience.mdreader.entity.FIleTitleBean
import kotlinx.android.synthetic.main.item_file_title.view.*

/**
 * @author SScience
 * @description
 * @email chentushen.science@gmail.com
 * @data 2018/1/8
 */
class FileTitleAdapter(context: Context) : BaseAdapter<FIleTitleBean>(context) {

    override fun getItemLayoutId(): Int {
        return R.layout.item_file_title
    }

    override fun bindViewHolder(viewHolder: ViewHolder, data: List<FIleTitleBean>, position: Int) {
        val convertView: View = viewHolder.getConvertView()
        viewHolder.setText(convertView.tv_file_title, data[position].titleName)
    }
}