package com.example.web2payapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.web2payapp.databinding.ActivityRecBinding

class Rec : AppCompatActivity() {

    private lateinit var binding: ActivityRecBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imagerecArrowgoback.setOnClickListener{
            val navBack = Intent(this,MainActivity::class.java)
            startActivity(navBack)


        }
    }
}