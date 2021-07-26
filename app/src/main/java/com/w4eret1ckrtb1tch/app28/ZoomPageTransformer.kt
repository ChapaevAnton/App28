package com.w4eret1ckrtb1tch.app28

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs


const val MIN_SCALE = 0.85f
const val MIN_ALPHA = 0.5f

class ZoomPageTransformer : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {

        page.apply {
            val pageHeight = height
            val pageWidth = width

            when {
                position < -1f -> { //спав за левый край
                    alpha = 0f
                }

                position <= 1 -> { //отображается
                    val scaleFactory = MIN_SCALE.coerceAtLeast(1 - abs(position))
                    val xMargin = pageWidth * (1 - scaleFactory) / 2
                    val yMargin = pageHeight * (1 - scaleFactory) / 2

                    translationX = if (position < 0) {
                        xMargin - yMargin / 2
                    } else {
                        xMargin + yMargin / 2
                    }

                    scaleX = scaleFactory
                    scaleY = scaleFactory

                    alpha = (MIN_ALPHA +
                            (((scaleFactory - MIN_SCALE) / (1 - MIN_SCALE)) * (1 - MIN_ALPHA)))
                }
                else -> { //свап за правый край
                    alpha = 0f
                }
            }
        }
    }
}