package com.example.changingscreens

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.changingscreens.models.Pessoa
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    private lateinit var btnCalcular: Button
    private lateinit var editNome: EditText
    private lateinit var editAno: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.editNome = findViewById(R.id.editTxtMainNome)
        this.editAno = findViewById(R.id.editTxtMainAno)
        this.btnCalcular = findViewById(R.id.btnMainVai)

        this.btnCalcular.setOnClickListener({ cliqueVai(it) })
    }

    fun cliqueVai(view: View) {
        val intent = Intent(this, SecondActivity::class.java)

        val nome = this.editNome.text.toString()
        val ano = this.editAno.text.toString().toInt()

        this.editNome.text.clear()
        this.editAno.text.clear()

        val pessoa: Pessoa = Pessoa(nome, ano)

        intent.putExtra("MSG_IDA", pessoa as Serializable)
        startActivity(intent)
    }
}