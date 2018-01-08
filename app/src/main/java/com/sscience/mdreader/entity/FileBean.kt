package com.sscience.mdreader.entity

/**
 * @author SScience
 * @description
 * @email chentushen.science@gmail.com
 * @data 2018/1/7
 */
/**
 * name：文件（夹）名
 * path：文件（夹）路径
 * size：文件大小
 * lastModified：最后一次修改的时间
 * childCount：子文件（夹）数量
 * fileType：文件类型
 */
data class FileBean(var name: String, var path: String, var size: Long, var lastModified: Long
                    , var childCount: String, var fileType: FileType)