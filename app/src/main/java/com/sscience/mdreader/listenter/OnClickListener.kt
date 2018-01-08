package com.sscience.mdreader.listenter

import android.view.View

/**
 * @author SScience
 * @description
 * @email chentushen.science@gmail.com
 * @data 2018/1/7
 */
abstract class OnClickListener : View.OnClickListener {

    private var lastClickTime = 0L

    override fun onClick(v: View?) {
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastClickTime > 500) {
            lastClickTime = currentTime
            onClicks(v)
        } else {
            return
        }
    }

    abstract fun onClicks(v: View?)
}