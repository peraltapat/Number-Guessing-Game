package com.example.numberguessinggame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        assignNumbersInsideButtons()

        btnLeft.setOnClickListener {
            checkAnswer(isLeftButtonSelected = true)
            assignNumbersInsideButtons()
        }

        btnRight.setOnClickListener {
            checkAnswer(isLeftButtonSelected = false)
            assignNumbersInsideButtons()
        }
    }

    private fun checkAnswer(isLeftButtonSelected: Boolean){
        val leftNum = btnLeft.text.toString().toInt()
        val rightNum = btnRight.text.toString().toInt()
        val isAnswerCorrect = if(isLeftButtonSelected) leftNum > rightNum else rightNum > leftNum
        if(isAnswerCorrect){
            backgroundView.setBackgroundColor(Color.GREEN)
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
        }else{
            backgroundView.setBackgroundColor(Color.RED)
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun assignNumbersInsideButtons() {
        val r = Random()
        val leftNum = r.nextInt(50) //bound is the maximum number that you want to hit
        var rightNum = leftNum
        while (rightNum == leftNum){
            rightNum = r.nextInt(50)
        }
        btnLeft.text = leftNum.toString()
        btnRight.text = rightNum.toString()
    }
}