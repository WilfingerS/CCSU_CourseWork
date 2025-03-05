package com.example.mathgame

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
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
        genRound() // Generate Starting Round
    }

    // Reused variables to limit findViewById calls
    private var num1 = 0
    private var num2 = 0
    private var result = 0
    private var score = 0
    private var totalscore = 0
    private var combo = 0
    private var operator:String = ""

    private fun getRand(min:Int,max:Int):Int{
        val rand = Random(System.currentTimeMillis()) // seeds with time when called so each is unique8
        // Needed to do max+1 so that max is included
        // alternative would be to do: val range = min..max
        return rand.nextInt(from=min,until=max+1) // Generate random number from range
    }

    private fun genNumbers(){
        num1 = getRand(11,100)
        num2 = getRand(10,99)
        if (num1 < num2 ){ // Switch if num2 is greater than the first number
            genNumbers() // just regenerate numbers
            /* Original thought process was to swap the number if 2 was greater
                val t = num1
                num1 = num2
                num2 = t
            */
        }
        findViewById<TextView>(R.id.num1).text = "$num1"
        findViewById<TextView>(R.id.num2).text = "$num2"
    }

    private fun genResult(){
        var posOps = 3 // possible operations 0-3 (+,-,*,/)
        if (num1%num2 != 0){ // This is to check if there is a remainder to remove division from possible choices
            posOps-- // reduce the number of operations down to 0-2 (+,-,*)
        }
        val op = getRand(0,posOps)
        result = when (op){
            1 -> {
                operator = "-"
                num1 - num2
            }
            2 -> {
                operator = "*"
                num1 * num2
            }
            3 -> {
                operator = "/"
                num1 / num2
            }
            else -> { // (0/default)
                operator = "+"
                num1 + num2
            } //failsafe to default at + operation
        }

        findViewById<TextView>(R.id.result).text = "$result"
    }

    private fun genRound(){
        genNumbers() // Generate Numbers for the Game
        genResult() // Generates Result Based on generated numbers
    }

    fun resetGame(view:View){
        score = 0
        totalscore = 0
        combo = 0
        findViewById<TextView>(R.id.message).text = ""
        findViewById<TextView>(R.id.score).text = "Score: $score/$totalscore"
        genRound()
    }

    fun buttonHandler(view: View){
        val booladd = ((num1 + num2) == result) && (view.id == R.id.button_plus)
        val boolsub = ((num1 - num2) == result) && (view.id == R.id.button_min)
        val boolmult = ((num1 * num2) == result) && (view.id == R.id.button_mult)
        val booldiv = ((num1 / num2) == result) && (num1%num2 == 0) && (view.id == R.id.button_div)
        val msgBox = findViewById<TextView>(R.id.message)
        var col = Color.parseColor("#00ff00") // green
        var msg:String = getString(R.string.CorrectMessage)

        if (booladd || boolsub || boolmult || booldiv){
            score++
            combo++
            if (combo >= 3){
                Toast.makeText(this,"Great work on three in a row",Toast.LENGTH_SHORT).show()
                combo = 0
            }
        }else{
            combo = 0
            msg = "Review: $num1 $operator $num2 = $result"
            col = Color.parseColor("#FF0000")
        }
        totalscore++
        msgBox.text = msg
        msgBox.setTextColor(col)
        findViewById<TextView>(R.id.score).text = "Score: $score/$totalscore"
        genRound() // Generate a new Round
    }

}