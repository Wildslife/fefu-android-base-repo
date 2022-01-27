package com.example.hello

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.appcompat.app.AppCompatActivity
import com.example.hello.databinding.ActivityHelloWorldBinding

class HelloWorld : AppCompatActivity(R.layout.activity_hello_world) {

    private lateinit var binding: ActivityHelloWorldBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHelloWorldBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.RegistrationButton.setOnClickListener{
            val intent = Intent(this, Registration::class.java)
            startActivity(intent)
        }

        binding.LoginButton.setOnClickListener{
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }
}