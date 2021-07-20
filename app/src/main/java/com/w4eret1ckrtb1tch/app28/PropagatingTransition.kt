package com.w4eret1ckrtb1tch.app28

import android.graphics.Rect
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.view.animation.Interpolator
import androidx.transition.CircularPropagation
import androidx.transition.Transition
import androidx.transition.TransitionManager
import androidx.transition.TransitionPropagation

class PropagatingTransition(
    private val sceneRoot: ViewGroup,
    var startingView: View?,
    val transition: Transition,
    duration: Long = 600,
    interpolator: Interpolator = DecelerateInterpolator(),
    propagation: TransitionPropagation = CircularPropagation()
) {
    private val targets: Collection<View>

    init {
        targets = (0 until sceneRoot.childCount).map { sceneRoot.getChildAt(it) }
        transition.duration = duration
        transition.interpolator = interpolator
        transition.propagation = propagation
    }

    fun start() {
        if (startingView == null && sceneRoot.childCount > 0) {
            startingView = sceneRoot.getChildAt(0)
        }

        transition.epicenterCallback = (startingView ?: sceneRoot).asEpicenter()

        targets.forEach { it.visibility = View.INVISIBLE }
        TransitionManager.beginDelayedTransition(sceneRoot, transition)
        targets.forEach { it.visibility = View.VISIBLE }
    }

    private fun View.asEpicenter(): Transition.EpicenterCallback {
        val viewRect = Rect()
        getGlobalVisibleRect(viewRect)
        return object : Transition.EpicenterCallback() {
            override fun onGetEpicenter(transition: Transition): Rect {
                return viewRect
            }
        }
    }

}