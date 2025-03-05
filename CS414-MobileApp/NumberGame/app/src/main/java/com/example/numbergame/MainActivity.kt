package com.example.numbergame

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

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
        // Added Code
        genNumbers(MAXnum)

        /* This will just have code to run inside
        findViewById<Button>(R.id.button_l).setOnClickListener {

        }*/

    }
    // Variables
    private var num1 = 0
    private var num2 = 0
    private var score = 0
    private var highscore = 0

    private val MAXnum = 20 // How big the random number can be
    // val = final/constant

    // Functions
    private fun genRandNum(max:Int):Int{
        return Random.nextInt(max)
    }

    private fun genNumbers(max:Int){ // Generate new set of numbers and set the variables
        num1  = genRandNum(max)
        num2 = genRandNum(max)
        findViewById<TextView>(R.id.Num1).text = "$num1"
        findViewById<TextView>(R.id.Num2).text = "$num2"
    }

    private fun updateScore(){
        if (score > highscore){ // Update highscore, if score exceeds highscore
            highscore = score
            findViewById<TextView>(R.id.highscore).text = "Highscore: $highscore"
        }
        findViewById<TextView>(R.id.Score).text = "Score: $score"
    }

    fun checkScore(view:View){
        val bool1 = view.id == R.id.button_l && num1 < num2 // Less than
        val bool2 = view.id == R.id.button_e && num1 == num2 // Equal to
        val bool3 = view.id == R.id.button_g && num1 > num2 // Greater than
        var msg:String = ""
        if (bool1 || bool2 || bool3){ // Answered correctly
            score++
            msg = "Correct!!!"
        }else{ // Answered Incorrectly (Lost game restart from 0)
            score = 0
            msg = "You good my dude? are you high?"
        }

        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
        updateScore()
        genNumbers(MAXnum)
    }
}

