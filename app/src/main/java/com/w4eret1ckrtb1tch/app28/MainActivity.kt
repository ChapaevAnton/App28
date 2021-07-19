package com.w4eret1ckrtb1tch.app28

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.transition.Scene
import androidx.transition.TransitionInflater
import androidx.transition.TransitionManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val rootScene: ConstraintLayout = findViewById(R.id.root_scene)


        val scene1 = Scene.getSceneForLayout(rootScene, R.layout.scene1, this)
        val scene2 = Scene.getSceneForLayout(rootScene, R.layout.scene2, this)


        //val transitionManager = TransitionManager()
        val transitionManager =
            TransitionInflater.from(this)
                .inflateTransitionManager(R.transition.transition_manager, rootScene)

        scene1.setEnterAction {
            scene1.sceneRoot.rootView.findViewById<Button>(R.id.button1).setOnClickListener {
                transitionManager.transitionTo(scene2)
            }
        }

        scene2.setEnterAction {
            scene2.sceneRoot.rootView.findViewById<Button>(R.id.button2).setOnClickListener {
                transitionManager.transitionTo(scene1)
            }
        }

        //Запускаем scene1
        transitionManager.transitionTo(scene1)

    }
}