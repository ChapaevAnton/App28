package com.w4eret1ckrtb1tch.app28

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment



class PageFragmentColor(private val position: Int) : Fragment() {
    private val colors = arrayOf(Color.RED, Color.MAGENTA, Color.BLUE, Color.YELLOW, Color.GREEN)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_page_color, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layout: ConstraintLayout = view.findViewById(R.id.page_layout)
        val text: TextView = view.findViewById(R.id.page_text)

        layout.setBackgroundColor(colors[position])
        text.text = position.toString()

    }

}