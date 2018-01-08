package com.sscience.mdreader.base

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

/**
 * @author SScience
 * @description
 * @email chentushen.science@gmail.com
 * @data 2018/1/9
 */
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initSystemUI()
    }

    private fun initSystemUI() {
        supportActionBar?.elevation = 6f
        val decorView = window.decorView
        // Android 6.0+ 灰色状态栏图标
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        // Android 8.0+ 亮色导航栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var suv = decorView.systemUiVisibility
            suv = suv or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            decorView.systemUiVisibility = suv
            window.navigationBarColor = getColor(android.R.color.transparent)
        }
    }

}