package com.w4eret1ckrtb1tch.app28

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.transition.ChangeImageTransform
import androidx.transition.Fade

class ThreeFragment:Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = Fade(Fade.MODE_IN).setDuration(100L).setInterpolator(LinearInterpolator())
        sharedElementEnterTransition = ChangeImageTransform()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_three,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val image: ImageView = view.findViewById(R.id.fragment_3_image)
        ViewCompat.setTransitionName(image, TRANSITION_IMAGE)


        startPostponedEnterTransition()
    }
}