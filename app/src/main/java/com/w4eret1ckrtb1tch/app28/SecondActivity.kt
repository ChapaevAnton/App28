package com.w4eret1ckrtb1tch.app28

import android.os.Bundle
import android.transition.Fade
import android.transition.Slide
import android.transition.TransitionManager
import android.transition.TransitionSet
import android.view.Gravity
import android.view.View
import android.view.Window
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.transition.addListener

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        window.allowEnterTransitionOverlap = true
        window.allowReturnTransitionOverlap = true
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val root: ConstraintLayout = findViewById(R.id.root_scene_second_1)
        val img1: ImageView = findViewById(R.id.img1)

        window.enterTransition = Fade().apply {
            duration = 500
            excludeTarget(android.R.id.navigationBarBackground, true)
            excludeTarget(android.R.id.statusBarBackground, true)

            addListener(onStart = {
                val slide = Slide().apply { duration = 500 }
                img1.visibility = View.INVISIBLE
                TransitionManager.beginDelayedTransition(root, slide)
                img1.visibility = View.VISIBLE
            })

        }

        window.returnTransition = TransitionSet().apply {

            addTransition(Slide(Gravity.TOP).apply {
                mode = Slide.MODE_OUT
                duration = 500
                addTarget(img1)

            })
            addTransition(Slide(Gravity.START).apply {
                mode = Slide.MODE_OUT
                duration = 500
                addTarget(root)
                excludeTarget(android.R.id.navigationBarBackground, true)
                excludeTarget(android.R.id.statusBarBackground, true)
            })
            ordering = TransitionSet.ORDERING_TOGETHER

        }

    }
}