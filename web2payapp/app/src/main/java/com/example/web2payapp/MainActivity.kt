package com.example.web2payapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.switchmaterial.SwitchMaterial


private lateinit var sqLitehelper: SQLiteHelper
private lateinit var txtuser: EditText
private lateinit var txtpassword: EditText
private lateinit var botaocadastro: Button
private lateinit var botao: Button


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sqLitehelper = SQLiteHelper(this)
        txtuser = findViewById(R.id.editemail_name)
        txtpassword = findViewById(R.id.editlogin_senha)
        botaocadastro = findViewById(R.id.cadastro_btn)
        botao = findViewById(R.id.login_btn)
        val switchbtn = findViewById<Switch>(R.id.escuro)

        switchbtn.setOnCheckedChangeListener { compoundButton, isChecked -> if (isChecked){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        }


        botao.setOnClickListener {
            sqLitehelper = SQLiteHelper(this)

            if (sqLitehelper.autentica(txtuser.text.toString(), txtpassword.text.toString()))
            {
                val gomenu = Intent(this, Menu::class.java)
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