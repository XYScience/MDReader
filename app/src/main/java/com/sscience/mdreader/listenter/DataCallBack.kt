package com.sscience.mdreader.listenter

import com.sscience.mdreader.entity.FileBean

/**
 * @author SScience
 * @description
 * @email chentushen.science@gmail.com
 * @data 2018/1/7
 */
interface DataCallBack {
    fun onFileList(fileBeanList: MutableList<FileBean>)
}