package com.example.pizzaapplication

import android.content.Intent
import android.os.*
import android.view.*
import android.widget.*
import androidx.activity.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.*

class PizzaOrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pizza_order)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val pizzaText = arrayOf("Pepperoni", "BBQ Chicken", "Margherita", "Hawaiian","Cheese")
        val pizzaSizeText = arrayOf("Small", "Medium", "Large")
        pizzaSize = intent.getIntExtra("Size", 0)
        pizzaToppings = intent.getIntExtra("Toppings", 0)
        pizzaCost = intent.getDoubleExtra("Cost", 0.0)
        pizzaType = when(intent.getIntExtra("Type",0)){
            R.drawable.pepperoni -> 0
            R.drawable.bbq_chicken -> 1
            R.drawable.margherita -> 2
            R.drawable.hawaiian -> 3
            else -> 4 // If seeing cheese then something is wrong
        }
        findViewById<ImageView>(R.id.pizzaimg).setImageResource(intent.getIntExtra("Type",R.drawable.pizza_crust))
        findViewById<TextView>(R.id.description).text = "${pizzaText[pizzaType]}\n\n${pizzaSizeText[pizzaSize]}\n\n${pizzaToppings} Toppings"
        findViewById<CheckBox>(R.id.deliverycheck).setOnCheckedChangeListener(this::checkBoxHandler)
        val seek = findViewById<SeekBar>(R.id.seekBar)
        seek.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                tipPercent = round(progress.toDouble()/seekBar.max.toDouble())
                tip = round(tipPercent*(pizzaCost*quantity))
                updatePage()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Notification that the user has started a touch gesture.
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Notification that the user has finished a touch gesture.
            }
        })

        updatePage()
    }

    private var pizzaType = 0
    private var pizzaSize = 0
    private var pizzaToppings = 0
    private var pizzaCost = 0.0

    private var quantity = 1
    private var fee = 0.0
    private var tip = 0.0
    private var tipPercent = 0.0
    private val tax = 0.635
    private var total = 0.0

    private fun round(d:Double):Double{
        return String.format("%.2f",d).toDouble()
    }

    private fun getTotal():Double{
        var cost = pizzaCost*quantity
        cost += ((tax * cost) + fee + tip)
        return cost
    }

    private fun updatePage(){
        val newSubTotal = round(pizzaCost * quantity)
        total = getTotal()
        findViewById<SeekBar>(R.id.seekBar).max = newSubTotal.toInt()
        findViewById<TextView>(R.id.quantity).text = "${quantity}"
        findViewById<TextView>(R.id.subtotal).text = "Subtotal:\t\t${round(newSubTotal)}"
        findViewById<TextView>(R.id.textView13).text = "Tax(6.36%):\t\t$${round(tax*(newSubTotal))}"
        findViewById<TextView>(R.id.tax).text = "Tip:\t\t$${tip}"
        findViewById<TextView>(R.id.tipPercentage).text = "${tipPercent*100}%"
        findViewById<TextView>(R.id.textView15).text = "Total:\t\t$${round(total)}"
        findViewById<TextView>(R.id.fee).text = "Delivery Fee:\t\t$${fee}"
    }

    fun editBtnHandler(view: View){
        if (view.id != R.id.edit)
            return
        finish()
    }

    fun orderBtn(view:View){
        val intent = Intent(this,PizzaSelectionActivity::class.java)
        Toast.makeText(this,"Sucessfully ordered ${quantity} pizza! Total:${round(total)}",Toast.LENGTH_LONG).show()
        startActivity(intent)
    }

    fun quantityHandler(view:View){
        if (view.id == R.id.min){
            quantity-=1
        }else if(view.id==R.id.plus){
            quantity+=1
        }
        if (quantity < 1)
            quantity=1
        updatePage()
    }

    private fun checkBoxHandler(btn: CompoundButton, isChecked:Boolean){
        fee = 0.00
        if(btn.isChecked){
            fee = 2.00 * quantity
        }
        updatePage()
    }
}