package com.w4eret1ckrtb1tch.app28

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.transition.AutoTransition
import androidx.transition.Fade
import androidx.transition.Slide

const val TRANSITION_IMAGE = "image_name"


class TwoFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = Slide(Gravity.END).apply {
            duration = 500
            mode = Slide.MODE_IN
        }

        returnTransition = Slide(Gravity.END).apply {
            duration = 500
        }

        exitTransition = Fade().setDuration(500L)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_two, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val image: ImageView = view.findViewById(R.id.fragment_2_image)
        ViewCompat.setTransitionName(image, TRANSITION_IMAGE)

        image.setOnClickListener {

            parentFragmentManager
                .beginTransaction()
                .setReorderingAllowed(true)
                .addSharedElement(image, TRANSITION_NAME)
                .addToBackStack("TwoFragment")
                .replace(R.id.container_fragment, ThreeFragment())
                .commit()
        }


    }
}