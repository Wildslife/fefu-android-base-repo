package com.example.hello

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hello.databinding.ActivityLoginBinding

class Login : AppCompatActivity(R.layout.activity_login) {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.LoginBar.setOnClickListener{
            val intent = Intent(this, HelloWorld::class.java)
            startActivity(intent)
        }
    }
}