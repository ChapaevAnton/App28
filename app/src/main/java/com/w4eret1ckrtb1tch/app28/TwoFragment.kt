package com.w4eret1ckrtb1tch.app28

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.transition.Slide

class TwoFragment : Fragment() {


    init {
        enterTransition = Slide(Gravity.END).apply {
            duration = 500
            mode = Slide.MODE_IN
        }
        returnTransition = Slide(Gravity.END).apply {
            duration = 500
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_two, container, false)
    }
}