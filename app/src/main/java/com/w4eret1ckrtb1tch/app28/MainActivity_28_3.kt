package com.w4eret1ckrtb1tch.app28

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.transition.Fade
import androidx.transition.Slide
import androidx.transition.TransitionSet

class MainActivity_28_3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_28_3)

        val swipeRefreshLayout: SwipeRefreshLayout = findViewById(R.id.swipeRefreshLayout)
        val root: ConstraintLayout = findViewById(R.id.root)
        val imageIcon: ImageView = findViewById(R.id.imageIcon)

        swipeRefreshLayout.setOnRefreshListener {
            PropagatingTransition(
                (root as ViewGroup),
                startingView = imageIcon,
                transition = TransitionSet()
                    .addTransition(
                        Fade(Fade.IN)
                            .setInterpolator(AccelerateInterpolator())
                    )
                    .addTransition(
                        Slide(Gravity.BOTTOM)
                            .setInterpolator(DecelerateInterpolator())
                    )
            ).start()
            swipeRefreshLayout.isRefreshing = false
        }

    }
}