package com.example.personalityquiz1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.os.CountDownTimer
import android.widget.*
import org.w3c.dom.Text
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var radioGroup: RadioGroup
    private lateinit var checkCzerwony: CheckBox
    private lateinit var checkNiebieski: CheckBox
    private lateinit var checkZielony: CheckBox
    private lateinit var seekPewnosc: SeekBar
    private lateinit var datePicker: DatePicker
    private lateinit var timePicker: TimePicker
    private lateinit var koniecButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        radioGroup = findViewById(R.id.radioGroup)
        checkCzerwony = findViewById(R.id.checkCzerwony)
        checkNiebieski = findViewById(R.id.checkNiebieski)
        checkZielony = findViewById(R.id.checkZielony)
        seekPewnosc = findViewById(R.id.seekPewnosc)
        datePicker = findViewById(R.id.datePicker)
        timePicker = findViewById(R.id.timePicker)
        koniecButton = findViewById(R.id.koniec)
        val wynikTekst = findViewById<TextView>(R.id.wynikTekst)
        koniecButton.setOnClickListener {
            val selectedId = radioGroup.checkedRadioButtonId
            val odpowiedzPytanie1 = if (selectedId != -1){
                findViewById<RadioButton>(selectedId).text.toString()
            } else {
                "Brak odpowiedzi"
            }

            val kolory = mutableListOf<String>()
            if(checkCzerwony.isChecked) kolory.add("Czerwony")
            if(checkNiebieski.isChecked) kolory.add("Niebieski")
            if(checkZielony.isChecked) kolory.add("Zielony")

            val poziomPewnosci = seekPewnosc.progress

            val dzien = datePicker.dayOfMonth
            val miesiac = datePicker.month + 1
            val rok = datePicker.year

            val godzina = timePicker.hour
            val minuta = timePicker.minute

            val wynik = if(poziomPewnosci>5 && kolory?.contains("Czerwony") == true){
                "Jestes ekstrowertykiem"
            }else{
                "Jestes introwertykiem"
            }

            wynikTekst.text = wynik
        }



    }



}