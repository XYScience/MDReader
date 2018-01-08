package com.sscience.mdreader.base

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.sscience.mdreader.listenter.OnClickListener
import com.sscience.mdreader.listenter.OnItemClickListener

/**
 * @author SScience
 * @description
 * @email chentushen.science@gmail.com
 * @data 2018/1/7
 */
abstract class BaseAdapter<T>(private var context: Context) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var datas: MutableList<T> = mutableListOf()
    private var onItemClickListener: OnItemClickListener<T>? = null

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder.create(context, getItemLayoutId(), parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder: ViewHolder = holder as ViewHolder
        bindViewHolder(viewHolder, datas, position)
        viewHolder.getConvertView().setOnClickListener(object : OnClickListener() {
            override fun onClicks(v: View?) {
                onItemClickListener?.onItemClick(datas[position], viewHolder.adapterPosition)
            }
        })
    }

    override fun getItemCount(): Int = datas.size


    abstract fun bindViewHolder(viewHolder: ViewHolder, data: List<T>, position: Int)

    abstract fun getItemLayoutId(): Int

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener<T>) {
        this.onItemClickListener = onItemClickListener
    }

    fun addData(data: MutableList<T>) {
        datas = data
        notifyDataSetChanged()
    }

    fun addItem(data: T) {
        datas.add(data)
        notifyDataSetChanged()
    }

    fun getDatas(): MutableList<T> {
        return datas
    }

    fun removeItem(position: Int) {
        datas.removeAt(position)
        notifyItemRemoved(position)
    }

    fun removeLastItem() {
        if (datas.size == 0) {
            return
        }
        val lastPosition = itemCount - 1
        datas.removeAt(lastPosition)
        notifyItemRemoved(lastPosition)
    }
}