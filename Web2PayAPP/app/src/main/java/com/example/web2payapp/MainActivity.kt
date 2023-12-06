package com.example.web2payapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.web2payapp.databinding.ActivityMainBinding


private lateinit var sqLitehelper: SQLiteHelper
private lateinit var txtuser: EditText
private lateinit var txtpassword: EditText
private lateinit var botaocadastro: Button
private lateinit var botao: Button


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sqLitehelper = SQLiteHelper(this)
        txtuser = findViewById(R.id.editemail_name)
        txtpassword = findViewById(R.id.editlogin_senha)
        botaocadastro = findViewById(R.id.cadastro_btn)
        botao = findViewById(R.id.login_btn)
        binding.escuro.setOnCheckedChangeListener { compoundButton, ischecked ->
            if (ischecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }

        }


        botao.setOnClickListener {
            sqLitehelper = SQLiteHelper(this)

            if (sqLitehelper.autentica(txtuser.text.toString(), txtpassword.text.toString()))
            {
                val gomenu = Intent(this, Cad::class.java)
                startActivity(gomenu)

            }
        }
        botaocadastro.setOnClickListener {
            adicionarlogin()
        }
    }
    private fun adicionarlogin() {
        txtuser = findViewById(R.id.editemail_name)
        txtpassword = findViewById(R.id.editlogin_senha)

        var username = txtuser.text.toString()
        var passworduser = txtpassword.text.toString()


        val log = Login(username = username, password = passworduser)

        val status = sqLitehelper.insereuser(log)

        if (status > -1) {
            Toast.makeText(this, "Adicionado com sucesso", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Não Salvo", Toast.LENGTH_SHORT).show()
        }
    }
}