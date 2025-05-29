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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private lateinit var radioGroup: RadioGroup
    private lateinit var checkRed: CheckBox
    private lateinit var checkBlue: CheckBox
    private lateinit var checkGreen: CheckBox
    private lateinit var seekConfidence: SeekBar
    private lateinit var datePicker: DatePicker
    private lateinit var timePicker: TimePicker
    private lateinit var btnFinish: Button
}