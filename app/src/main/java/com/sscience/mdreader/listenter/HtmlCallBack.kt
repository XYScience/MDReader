package com.sscience.mdreader.listenter

/**
 * @author SScience
 * @description
 * @email chentushen.science@gmail.com
 * @data 2018/1/7
 */
interface HtmlCallBack {

    fun onLoadFileName(fileName: String?)

    fun onLoadData(htmlPath: String)

    fun onError(error: String)
}