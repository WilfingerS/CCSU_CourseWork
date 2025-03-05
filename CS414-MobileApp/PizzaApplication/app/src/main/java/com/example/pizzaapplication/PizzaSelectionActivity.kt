package com.example.pizzaapplication


import android.content.Intent
import android.os.*
import android.view.*
import android.widget.*
import androidx.activity.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.*

class PizzaSelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_selection)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Start Setting Up
        val radioGroupIds = listOf(R.id.group_size,R.id.group_type)
        val checkBoxIds = listOf(R.id.checkBox,R.id.checkBox2,R.id.checkBox3,R.id.checkBox4,R.id.checkBox5,R.id.checkBox6)
        // ^ looked at documentation for how this is done

        for (id in radioGroupIds){ // Set listener for radio
            val obj = findViewById<RadioGroup>(id)
            obj.setOnCheckedChangeListener(this::radioGroupHandler)
        }
        for (id in checkBoxIds){ // Set custom listener for checkbox
            val obj = findViewById<CheckBox>(id)
            obj.setOnCheckedChangeListener(this::checkBoxHandler)
        }
        updateApp() // Setup app
    }

    private val pizzaObject = PizzaObject(R.drawable.pizza_crust)
    private val checkBoxIds = listOf(R.id.checkBox,R.id.checkBox2,R.id.checkBox3,R.id.checkBox4,R.id.checkBox5,R.id.checkBox6)

    private fun radioGroupHandler(group:RadioGroup,checkedId:Int){
        if (checkedId == -1)
            return
        val btn = findViewById<RadioButton>(checkedId)
        when(group.id){
            R.id.group_type->typeHandler(btn.text)
            R.id.group_size->sizeHandler(btn.text)
            else->return
        }
    }

    private fun checkBoxHandler(btn:CompoundButton,isChecked:Boolean){
        val toppings = pizzaObject.numOfToppings
        if(btn.isChecked){
            pizzaObject.setNumOfToppings(toppings+1)
        }else{
            pizzaObject.setNumOfToppings(toppings-1)
        }
        updateApp()
    }

    private fun sizeHandler(txt:CharSequence){
        val size = when(txt[0]){
            'S' -> 0
            'M' -> 1
            'L' -> 2
            else -> -1
        }
        pizzaObject.setSize(size)
        updateApp()
    }
    private fun typeHandler(txt:CharSequence){
        val drawable = when(txt){
            "Pepperoni"->R.drawable.pepperoni
            "BBQ Chicken"->R.drawable.bbq_chicken
            "Margherita"->R.drawable.margherita
            "Hawaiian"->R.drawable.hawaiian
            else -> R.drawable.pizza_crust
        }
        pizzaObject.setType(drawable)
        updateApp()
    }

    fun reset(view:View){
        if (view.id != R.id.reset_button)
            return
        findViewById<RadioGroup>(R.id.group_type).clearCheck()
        findViewById<RadioGroup>(R.id.group_size).clearCheck()
        for (id in checkBoxIds){
            val btn = findViewById<CheckBox>(id)
            if (btn != null)
                btn.isChecked = false
        }
        pizzaObject.reset(R.drawable.pizza_crust)
        updateApp()
    }

    fun checkout(view:View){
        val bool1 = pizzaObject.type != R.drawable.pizza_crust
        val bool2 = pizzaObject.getTotalCost() > 0
        // this bool doesnt need to worry about if they select size because of how
        // total cost is calculated within the Class

        if (bool1 && bool2){
            val intent = Intent(this,PizzaOrderActivity::class.java)
            intent.putExtra("Type",pizzaObject.type)
            intent.putExtra("Size",pizzaObject.size)
            intent.putExtra("Toppings",pizzaObject.numOfToppings)
            intent.putExtra("Cost",pizzaObject.totalCost)
            startActivity(intent)
        }else{
            Toast.makeText(this,"Finish Selecting Pizza",Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateApp(){
        val pizzaImage = findViewById<ImageView>(R.id.pizza_img)
        val totalText = findViewById<TextView>(R.id.textView5)
        pizzaImage.setImageResource(pizzaObject.type);
        totalText.text = "Subtotal:\t$${pizzaObject.getTotalCost()}"
    }
}