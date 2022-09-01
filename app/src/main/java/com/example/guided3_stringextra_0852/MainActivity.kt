package com.example.guided3_stringextra_0852

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var etAngka : TextInputEditText
    private var btnRGroup : RadioGroup? = null
    private lateinit var btnRbutton : RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendMessage(view: View) {
        val intent = Intent(this, DisplayMessage::class.java)
        val message: String
        btnRGroup = findViewById(R.id.radioGroup)
        val rbc: Int = btnRGroup!!.checkedRadioButtonId
        btnRbutton = findViewById(rbc)
        message = btnRbutton.text.toString()

        intent.putExtra(EXTRA_MESSAGE, message)
        startActivity(intent)
    }

    fun sendNumberMessage(view: View) {
        val intent = Intent(this, DisplayNumber::class.java)
        etAngka = findViewById(R.id.tietKetikAngka)
        val angka: Int = (etAngka.text.toString().toInt())

        intent.putExtra("inputanAngka", angka.toString())
        startActivity(intent)
    }

    companion object {
        const val EXTRA_MESSAGE = "MESSAGE"
    }
}