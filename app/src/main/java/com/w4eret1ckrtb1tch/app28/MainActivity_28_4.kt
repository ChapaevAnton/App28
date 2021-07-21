package com.w4eret1ckrtb1tch.app28

import android.graphics.Rect
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.transition.*


class MainActivity_28_4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_28_4)


        val root = findViewById<ConstraintLayout>(R.id.root_scene_4)
        val img = findViewById<ImageView>(R.id.img)

        //ChangeClipBounds
        val width =
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 763F, resources.displayMetrics)
                .toInt()
        val height =
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1080F, resources.displayMetrics)
                .toInt()
        val rect1 = Rect(0, 0, width / 4, height / 4)
        val rect2 = Rect(0, 0, width, height)
        //img.clipBounds = rect1

        //TransitionSet ChangeBounds ChangeImageTransform
        var expanded = false
        val transitionSet = TransitionSet()
            .addTransition(ChangeBounds())
            .addTransition(ChangeImageTransform())




        transitionSet.addListener(object : Transition.TransitionListener {
            override fun onTransitionStart(transition: Transition) {
                Toast.makeText(this@MainActivity_28_4,"START",Toast.LENGTH_SHORT).show()
            }

            override fun onTransitionEnd(transition: Transition) {
                Toast.makeText(this@MainActivity_28_4,"END",Toast.LENGTH_SHORT).show()
            }

            override fun onTransitionCancel(transition: Transition) {

            }

            override fun onTransitionPause(transition: Transition) {

            }

            override fun onTransitionResume(transition: Transition) {

            }

        })


        img.setOnClickListener {
            //ChangeClipBounds
//            TransitionManager.beginDelayedTransition(root, ChangeClipBounds())
//            img.clipBounds = if(img.clipBounds == rect1) rect2 else rect1

            //TransitionSet ChangeBounds ChangeImageTransform
            expanded = !expanded
            TransitionManager.beginDelayedTransition(root, transitionSet)
            val params: ViewGroup.LayoutParams = img.layoutParams
            params.height =
                if (expanded) ViewGroup.LayoutParams.MATCH_PARENT else ViewGroup.LayoutParams.WRAP_CONTENT
            params.width = params.height
            img.layoutParams = params

            img.scaleType =
                if (expanded) ImageView.ScaleType.CENTER_CROP else ImageView.ScaleType.CENTER_INSIDE
        }

    }
}