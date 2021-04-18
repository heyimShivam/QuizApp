package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       window.decorView.systemUiVisibility=View.SYSTEM_UI_FLAG_FULLSCREEN
        setContentView(R.layout.activity_main)
        val btnStart: Button =findViewById(R.id.btnStart)
        btnStart.setOnClickListener{
            val nameBox:TextView=findViewById(R.id.nameBox)
            if(nameBox.text.toString().isEmpty()){
               Toast.makeText(this, "Enter Your Name", Toast.LENGTH_SHORT).show()
            }else{
                val intent= Intent(this,QuizQuestionActivity::class.java)

                startActivity(intent)
                finish()
            }
        }
    }
}