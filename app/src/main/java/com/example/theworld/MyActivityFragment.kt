package com.example.theworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.theworld.databinding.FragmentMyActivityBinding

class MyActivityFragment : Fragment() {
    private lateinit var binding: FragmentMyActivityBinding
    private val adapter = MyActivityAdapter(object : MyActivityClick{
        override fun onClicked() {
            childFragmentManager.beginTransaction().apply {
                add(R.id.FragCont, MyActivityDetailsFragment.newInstance(),
                    "ThirdFragment"
                )
                addToBackStack("ThirdFragment")
                commit()
            }
        }
    })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMyActivityBinding.inflate(layoutInflater)
        init()
        return binding.root
    }

    private fun init(){
        binding.apply {
            MyRecycler.layoutManager = LinearLayoutManager(activity)
            MyRecycler.adapter = adapter
            var date = Date("Вчера")
            adapter.addDate(date)
            var activity = Activity("14.32 км", "2 часа 46 минут", "Сёрфинг", "14 часов назад")
            adapter.addActivity(activity)
            date = Date("Май 2022 года")
            adapter.addDate(date)
            activity = Activity("1000 м", "60 минут", "Велосипед", "29.05.2022")
            adapter.addActivity(activity)
        }
    }
}