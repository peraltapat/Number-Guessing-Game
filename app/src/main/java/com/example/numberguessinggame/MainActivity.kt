package com.example.numberguessinggame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLeft.setOnClickListener {
            val leftNum = btnLeft.text.toString().toInt()
            val rightNum = btnRight.text.toString().toInt()
            if(leftNum > rightNum){
                backgroundView.setBackgroundColor(Color.GREEN)
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            }else
                backgroundView.setBackgroundColor(Color.RED)
                Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show()
        }
    }
}