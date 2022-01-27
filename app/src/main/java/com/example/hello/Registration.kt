package com.example.hello

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.appcompat.app.AppCompatActivity
import com.example.hello.databinding.ActivityRegistrationBinding

class Registration : AppCompatActivity(R.layout.activity_registration) {

    private lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val spannableString = SpannableString("Нажимая на кнопку, вы соглашаетесь \n с политикой конфиденциальности и обработки персональных \n данных, а также принимаете пользовательское соглашение")
        val color1 = ForegroundColorSpan(Color.MAGENTA)
        val color2 = ForegroundColorSpan(Color.MAGENTA)
        spannableString.setSpan(color1, 39, 67, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(color2, 122, 149, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        binding.Info.text = spannableString

        binding.RegistrationBar.setOnClickListener{
            val intent = Intent(this, HelloWorld::class.java)
            startActivity(intent)
        }
    }
}