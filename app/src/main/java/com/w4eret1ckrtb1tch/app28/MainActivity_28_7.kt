package com.w4eret1ckrtb1tch.app28

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.transition.AutoTransition
import android.transition.Slide
import android.util.Pair
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

const val TRANSITION_NAME = "setImage"
const val KEY_IMAGE_INDEX = "com.app28.key_image_index"

class MainActivity_28_7 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        window.sharedElementsUseOverlay = true

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_28_7)

        val root: ConstraintLayout = findViewById(R.id.root_28_7)
        val button = Button(this)
        button.text = "Button"
        button.layoutParams = ViewGroup.LayoutParams(200, 400)
        root.addView(button)


        val img: ImageView = findViewById(R.id.title_image)
        val text: TextView = findViewById(R.id.desc_text)

        val setImg1: ImageView = findViewById(R.id.img_set1)
        val setImg2: ImageView = findViewById(R.id.img_set2)
        val setImg3: ImageView = findViewById(R.id.img_set3)
        val setImg4: ImageView = findViewById(R.id.img_set4)


        val setImages = arrayOf(setImg1, setImg2, setImg3, setImg4)

        setImages.forEach { imageView ->
            imageView.setOnClickListener {
                val options =
                    ActivityOptions.makeSceneTransitionAnimation(this, Pair(it, TRANSITION_NAME))
                val intent = Intent(this, SecondActivity_28_7::class.java)
                intent.putExtra(KEY_IMAGE_INDEX, setImages.indexOf(it))
                startActivity(intent, options.toBundle())
            }
        }

        val transition = Slide(Gravity.START).apply {
            duration = 1000
            excludeTarget(android.R.id.statusBarBackground, true)
            excludeTarget(android.R.id.navigationBarBackground, true)
        }

        window.sharedElementExitTransition = AutoTransition()
        window.exitTransition = transition.apply { mode = Slide.MODE_OUT }
        window.reenterTransition = transition

        root.setOnClickListener {

            val intent = Intent(this, SecondActivity_28_7::class.java)
            val options = ActivityOptions.makeSceneTransitionAnimation(
                this,
                Pair(img, "titleImage"),
                Pair(text, "descText")
            )

            startActivity(intent, options.toBundle())
        }

    }
}