package com.w4eret1ckrtb1tch.app28

import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.transition.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //контейнеры для сцен
        val rootScene1: FrameLayout = findViewById(R.id.root_scene_1)
        val rootScene2: ConstraintLayout = findViewById(R.id.root_scene_2)

        //создание сцен XML
        val scene1 = Scene.getSceneForLayout(rootScene1, R.layout.scene1, this)
        val scene2 = Scene.getSceneForLayout(rootScene1, R.layout.scene2, this)

        val button3:Button = findViewById(R.id.button3)

        //создание сцен код
        val scene3 = Scene(rootScene2,button3)
        //создание Transition XML
        val transition3:Transition = TransitionInflater.from(this).inflateTransition(R.transition.transition_fade_slide)
        //создание Transition код
        val transition4:Transition = Slide(android.view.Gravity.TOP)
        transition4.duration = 1000


        //Transition manager через код
        val transitionManager4 = TransitionManager()
        transitionManager4.setTransition(scene3,transition4)

        //Transition manager через XML
        val transitionManager =
            TransitionInflater.from(this)
                .inflateTransitionManager(R.transition.transition_manager, rootScene1)

        //слушатель сцены
        scene1.setEnterAction {
            scene1.sceneRoot.rootView.findViewById<Button>(R.id.button1).setOnClickListener {
                //вызов сцены менеджером
                transitionManager.transitionTo(scene2)
            }
        }

        scene2.setEnterAction {
            scene2.sceneRoot.rootView.findViewById<Button>(R.id.button2).setOnClickListener {
                transitionManager.transitionTo(scene1)
            }
        }

        //вызов сцены менеджером начальной
        transitionManager.transitionTo(scene1)



            //вызов сцены
        button3.setOnClickListener {
                TransitionManager.go(scene3,transition4)

        }
    }
}