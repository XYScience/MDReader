package com.sscience.mdreader.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * @author SScience
 * @description
 * @email chentushen.science@gmail.com
 * @data 2018/1/8
 */
class TimeUtils {

    companion object {
        private val strDateFormat: String = "yyyy-MM-dd HH:mm"
        fun getAllDateTime(time: Long): String {
            val date = Date(time)
            val sdf = SimpleDateFormat(strDateFormat)
            return sdf.format(date)
        }
    }
}