package com.example.web2payapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate
import com.example.web2payapp.databinding.ActivityCadBinding
import com.example.web2payapp.databinding.ActivityMainBinding

private lateinit var escuro:Switch


class Cad : AppCompatActivity() {
    private lateinit var binding: ActivityCadBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        escuro = findViewById(R.id.escuro)

        binding.escuro.setOnCheckedChangeListener { compoundButton, ischecked ->
            if (ischecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }

        }
    }
}