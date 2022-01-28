package com.example.theworld

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(fragmentActivityFragment: ActivityFragment): FragmentStateAdapter(fragmentActivityFragment) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> MyActivityFragment()
            else -> UsersActivityFragment()
        }
    }
}
