package com.w4eret1ckrtb1tch.app28

import android.os.Bundle
import android.transition.Slide
import android.view.Gravity
import android.view.Window
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        window.allowEnterTransitionOverlap = true
        window.allowReturnTransitionOverlap = true
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        window.enterTransition = Slide(Gravity.START).apply {
            duration = 500
            excludeTarget(android.R.id.navigationBarBackground, true)
            excludeTarget(android.R.id.statusBarBackground, true)
        }

        window.returnTransition = Slide(Gravity.BOTTOM).apply {
            mode = Slide.MODE_OUT
            duration = 500
            excludeTarget(android.R.id.navigationBarBackground, true)
            excludeTarget(android.R.id.statusBarBackground, true)
        }


    }
}