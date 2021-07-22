package com.w4eret1ckrtb1tch.app28

import android.os.Bundle
import android.transition.AutoTransition
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity_28_7 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        window.sharedElementsUseOverlay = true

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_28_7)

        window.sharedElementEnterTransition = AutoTransition()



        val listImage =
            arrayOf(R.drawable.robe, R.drawable.robot_golem, R.drawable.greek, R.drawable.viking)
        val listName = arrayOf("1", "2", "3", "4")

        val image: ImageView = findViewById(R.id.title_image_second)
        val text:TextView = findViewById(R.id.desc_text_second)

        image.setImageResource(listImage[intent.getIntExtra(KEY_IMAGE_INDEX, 0)])
        text.text = listName[intent.getIntExtra(KEY_IMAGE_INDEX, 0)]

    }
}