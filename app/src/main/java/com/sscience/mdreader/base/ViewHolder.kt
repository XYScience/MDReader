package com.sscience.mdreader.base

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

/**
 * @author SScience
 * @description
 * @email chentushen.science@gmail.com
 * @data 2018/1/7
 */
class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var convertView: View = itemView

    companion object {
        fun create(context: Context, layoutId: Int, parent: ViewGroup?): ViewHolder {
            val itemView: View = LayoutInflater.from(context).inflate(layoutId, parent, false)
            return ViewHolder(itemView)
        }
    }

    fun getConvertView(): View {
        return convertView
    }

    fun setText(textView: TextView, text: String): ViewHolder {
        textView.text = text
        return this
    }

    fun setImageResource(imageView: ImageView, resourceId: Int): ViewHolder {
        imageView.setImageResource(resourceId)
        return this
    }

    fun setImageVisibility(imageView: ImageView, visibility: Int): ViewHolder {
        imageView.visibility = visibility
        return this
    }
}