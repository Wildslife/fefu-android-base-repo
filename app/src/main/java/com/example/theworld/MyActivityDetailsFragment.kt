package com.example.theworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.theworld.databinding.FragmentActivityDetailsBinding

class MyActivityDetailsFragment : Fragment() {
    private lateinit var binding: FragmentActivityDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentActivityDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object{
        @JvmStatic
        fun newInstance() = MyActivityDetailsFragment()
    }
}