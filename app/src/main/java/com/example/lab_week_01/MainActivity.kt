package com.example.lab_week_01

import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import org.w3c.dom.Text

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

//        val infoDisplay = findViewById<TextView>(R.id.student_info_display)
        val infoDisplay = findViewById<TextView>(R.id.student_info_display)
        val infoSubmit = findViewById<Button>(R.id.info_submit)

        infoSubmit.setOnClickListener {
            val nameInput = findViewById<TextInputEditText>(R.id.name_input)
                ?.text.toString().trim()
            val nimInput = findViewById<TextInputEditText>(R.id.nim_input)?.text.toString().trim()

            if(!(nameInput.isNotEmpty() || nimInput.length == 11)){
//                val errorStringBoth = getString(R.string.name_empty).plus(" AND ").plus(R.string.nim_not_eleven)
                Toast.makeText(this, getString(R.string.both_fields_wrong), Toast.LENGTH_LONG).apply {
                    setGravity(Gravity.CENTER, 0, 0)
                    show()
                }
            }

            if(nameInput.isNotEmpty() && nimInput.length == 11){
                infoDisplay?.text = getString(R.string.name_greet).plus(" ").plus(nameInput)
                    .plus("\n").plus(nimInput)
            }

            //Good NIM, Empty Name
            else if (nimInput.length == 11){
                Toast.makeText(this, getString(R.string.name_empty), Toast.LENGTH_LONG).apply{
                    setGravity(Gravity.CENTER, 0, 0)
                    show()
                }
            }

            //Filled Name, Not Good NIM
            else if (nameInput.isNotEmpty()){
                Toast.makeText(this, getString(R.string.nim_not_eleven), Toast.LENGTH_LONG).apply {
                    setGravity(Gravity.CENTER, 0, 0)
                    show()
                }
            }

        }
    }
}