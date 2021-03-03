package com.example.changingscreens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.changingscreens.models.Pessoa

class SecondActivity : AppCompatActivity() {
    private lateinit var textMsg: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val pessoa = intent.extras?.get("MSG_IDA") as Pessoa

        val nome = pessoa.nome
        val idade = pessoa.idade()

        this.textMsg = findViewById(R.id.txtSecondMsg)
        this.textMsg.text = "$nome, você possui $idade anos!"

        this.textMsg.setOnClickListener({ cliqueVolta(it) })
    }

    fun cliqueVolta(view: View) {
        finish()
    }
}