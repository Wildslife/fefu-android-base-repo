package com.example.theworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.theworld.databinding.ActivityActivityBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityActivityBinding

    override fun onCreate(SavedInstanceState: Bundle?) {
        super.onCreate(SavedInstanceState)
        binding = ActivityActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(SavedInstanceState == null){
            supportFragmentManager.beginTransaction().apply {
                add(
                    R.id.FragCont,
                    ActivityFragment.newInstance(),
                    "firstFragment"
                )
                addToBackStack("firstFragment")
                commit()
            }
        }

        binding.Nav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.item1 -> {
                    val activeFragment = supportFragmentManager.findFragmentByTag("secondFragment")
                    val newFragment = supportFragmentManager.findFragmentByTag("firstFragment")
                    supportFragmentManager.beginTransaction().apply {
                        if (activeFragment != null) {
                            hide(activeFragment)
                            if(newFragment != null){
                                show(newFragment)
                            }
                            commit()
                        }
                    }
                }
                R.id.item2 -> {
                    val activeFragment = supportFragmentManager.findFragmentByTag("firstFragment")
                    val newFragment = supportFragmentManager.findFragmentByTag("secondFragment")
                    supportFragmentManager.beginTransaction().apply {
                        if (activeFragment != null) {
                            hide(activeFragment)
                            if(newFragment != null){
                                show(newFragment)
                            }
                            else{
                                add(
                                    R.id.FragCont,
                                    ProfileFragment.newInstance(),
                                    "secondFragment"
                                )
                                addToBackStack("secondFragment")
                            }
                            commit()
                        }
                    }
                }
            }
            true
        }
    }
}