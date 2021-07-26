package com.w4eret1ckrtb1tch.app28

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

const val TABS_SIZE = 5

class PageFragmentAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return TABS_SIZE
    }

    override fun createFragment(position: Int): Fragment {
        return PageFragmentColor(position)
    }
}