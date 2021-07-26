package com.w4eret1ckrtb1tch.app28

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2

class MainActivity_28_8 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_28_8)

        val fragmentManager = supportFragmentManager
        var fragment: Fragment? = fragmentManager.findFragmentById(R.id.container_fragment)

        if (fragment == null) {
            fragment = OneFragment()
            fragmentManager
                .beginTransaction()
                .add(R.id.container_fragment, fragment)
                .commit()
        }


        val pageAdapter = PageFragmentAdapter(fragmentManager,lifecycle)
        val viewPager:ViewPager2 = findViewById(R.id.view_pager_fragment)
        viewPager.adapter = pageAdapter
        viewPager.setPageTransformer(ZoomPageTransformer())

    }
}