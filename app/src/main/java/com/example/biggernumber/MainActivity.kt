package com.example.biggernumber

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet.Layout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random

class MainActivity : AppCompatActivity() {

    private lateinit var btnLeft : Button
    private lateinit var btnRight : Button
    private lateinit var backgroundView: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.backgroundView)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnLeft= findViewById(R.id.btnLeft)
        btnRight=findViewById(R.id.btnRight)
        backgroundView=findViewById(R.id.backgroundView)
        btnLeft.setOnClickListener {
            //code here will run everytime button is clicked
            //1. compare the numbers
            val leftNum=btnLeft.text.toString().toInt()
            val RightNum=btnRight.text.toString().toInt()
            if(leftNum>RightNum){
                //correct ans
                //change background color
                backgroundView.setBackgroundColor(Color.GREEN)
                //show notification--that is toast
                Toast.makeText(this, "Correct!", Toast.LENGTH_LONG).show()
            }
            else{
                //wrong answer
                backgroundView.setBackgroundColor(Color.RED)
                //show notification--that is toast
                Toast.makeText(this, "Wrong!", Toast.LENGTH_LONG).show()
            }

            //2. new random number is assigned
            assignNumbersToButton()
        }

        btnRight.setOnClickListener {
            //code here will run everytime button is clicked
            //1. compare the numbers
            val leftNum=btnLeft.text.toString().toInt()
            val RightNum=btnRight.text.toString().toInt()
            if(RightNum>leftNum){
                //correct ans
                //change background color
                backgroundView.setBackgroundColor(Color.GREEN)
                //show notification--that is toast
                Toast.makeText(this, "Correct!", Toast.LENGTH_LONG).show()
            }
            else{
                //wrong answer
                backgroundView.setBackgroundColor(Color.RED)
                //show notification--that is toast
                Toast.makeText(this, "Wrong!", Toast.LENGTH_LONG).show()
            }

            //2. new random number is assigned
            assignNumbersToButton()
        }

    }

    private fun assignNumbersToButton() {
        val r = Random()
        val leftNum : Int = r.nextInt(10)
        var RightNum : Int = r.nextInt(10)
        while(RightNum==leftNum){
            RightNum=r.nextInt(10)
        }
        btnLeft.text=leftNum.toString()
        btnRight.text=RightNum.toString()

    }
}