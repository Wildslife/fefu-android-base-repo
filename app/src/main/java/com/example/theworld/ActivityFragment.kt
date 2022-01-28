package com.example.theworld

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.theworld.databinding.FragmentActivityBinding
import com.google.android.material.tabs.TabLayoutMediator


class ActivityFragment : Fragment() {

    private var tabNames: Array<String> = arrayOf(
        "Моя",
        "Пользователей",
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentActivityBinding.inflate(inflater)
        binding.ViewPager.adapter = PagerAdapter(this)
        binding.TabLayout.tabIconTint = null
        TabLayoutMediator(binding.TabLayout, binding.ViewPager){
                tab, pos ->
            when(pos){
                0 -> {
                    tab.text = tabNames[0]
                }
                1 -> {
                    tab.text = tabNames[1]
                }
            }
        }.attach()
        return binding.root
    }

    companion object{
        @JvmStatic
        fun newInstance() = ActivityFragment()
    }

}