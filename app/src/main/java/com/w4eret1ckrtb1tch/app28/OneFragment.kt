package com.w4eret1ckrtb1tch.app28

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.transition.Slide

class OneFragment : Fragment() {

    init {
        exitTransition = Slide(Gravity.START).apply {
            duration = 500
            mode =Slide.MODE_OUT
        }
        reenterTransition = Slide(Gravity.START).apply {
            duration = 500
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val text: TextView = view.findViewById(R.id.fragment_1_text)


        text.setOnClickListener {
            Log.d(
                "TAG",
                "onViewCreated: ${requireActivity().supportFragmentManager.backStackEntryCount}"
            )
            requireActivity()
                .supportFragmentManager
                .beginTransaction()
                .replace(R.id.container_fragment, TwoFragment())
                .addToBackStack("OneFragment")
                .commit()
        }
    }

}