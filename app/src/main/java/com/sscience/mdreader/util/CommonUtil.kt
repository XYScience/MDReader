package com.sscience.mdreader.util

/**
 * @author SScience
 * @description
 * @email chentushen.science@gmail.com
 * @data 2018/1/11
 */
class CommonUtil {

    companion object {

        /** Adds alpha to a hex color
         * @param originalColor color, without alpha
         * @param alpha from 0.0 to 1.0
         * @return the original color with alpha
         * */
        fun getColorWithAlpha(originalColor: String, alpha: Double): String {
            val alphaFixed = Math.round(alpha * 255)
            var alphaHex = java.lang.Long.toHexString(alphaFixed)
            if (alphaHex.length == 1) {
                alphaHex = "0" + alphaHex
            }
            return originalColor.replace("#", "#" + alphaHex)
        }

    }
}