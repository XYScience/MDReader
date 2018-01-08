package com.sscience.mdreader.listenter

/**
 * @author SScience
 * @description
 * @email chentushen.science@gmail.com
 * @data 2018/1/7
 */
interface OnItemClickListener<T> {

    fun onItemClick(data: T, position: Int)
}