package com.example.theworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.theworld.databinding.FragmentMyActivityBinding
import com.example.theworld.databinding.FragmentUsersActivityBinding

class UsersActivityFragment : Fragment() {
    private lateinit var binding: FragmentUsersActivityBinding
    private val adapter = UsersActivityAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUsersActivityBinding.inflate(layoutInflater)
        init()
        return binding.root
    }

    private fun init(){
        binding.apply {
            UsersRecycler.layoutManager = LinearLayoutManager(activity)
            UsersRecycler.adapter = adapter
            var date = Date("Вчера")
            adapter.addDate(date)
            var activity = UsersActivity("@van_darkhoime", "14.32 км", "2 часа 46 минут", "Сёрфинг", "14 часов назад")
            adapter.addActivity(activity)
            activity = UsersActivity("@techniquepasha", "228 м", "14 часов 48 минут", "Качели", "14 часов назад")
            adapter.addActivity(activity)
            activity = UsersActivity("@morgen_shtern", "10 км", "1 час 10 минут", "Езда на кадилак", "14 часов назад")
            adapter.addActivity(activity)
        }
    }
}
