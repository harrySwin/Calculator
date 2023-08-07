package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onStop() {
        super.onStop()
        Log.i("LIFECYCLE","stopped")
    }
    override fun onStart() {
        super.onStart()
        Log.i("LIFECYCLE","started")
    }

    override fun onResume() {
        super.onResume()
        Log.i("LIFECYCLE","resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.i("LIFECYCLE","pause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("LIFECYCLE", "restart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LIFECYCLE","destroy")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialise numbers
        val number1 = findViewById<EditText>(R.id.number1)
        val number2 = findViewById<EditText>(R.id.number2)

        val equals = findViewById<Button>(R.id.equals)
        equals.setOnClickListener {
            //Check numbers are not null
            if ((number1.text.toString() != "") && (number2.text.toString() != "")) {
                //Check operator
                val radioGroup = findViewById<RadioGroup>(R.id.operators)
                val selectedId = radioGroup.checkedRadioButtonId;
                val operator = findViewById<RadioButton>(selectedId)
                if (operator.text == "plus") {
                    val result =
                        add(number1.text.toString().toDouble(), number2.text.toString().toDouble())
                    val output = findViewById<TextView>(R.id.output)
                    output.text = result.toString()
                } else if (operator.text == "multiply") {
                    val result =
                        multiply(number1.text.toString().toDouble(), number2.text.toString().toDouble())
                    val output = findViewById<TextView>(R.id.output)
                    output.text = result.toString()
                } else {
                    if ((number2.text.toString().toInt() != 0)) {
                        val result = divide(
                            number1.text.toString().toDouble(),
                            number2.text.toString().toDouble()
                        )
                        val output = findViewById<TextView>(R.id.output)
                        output.text = result.toString()
                    } else {
                        val output = findViewById<TextView>(R.id.output)
                        output.text = "divide by zero"
                    }
                }
            } else {
                Toast.makeText(baseContext, "Please enter two numbers", Toast.LENGTH_SHORT).show()
            }
        }
    }
    //Calculation functions
    private fun add(number1: Double, number2: Double) = number1 + number2
    private fun multiply(number1: Double, number2: Double) = number1 * number2
    private fun divide(number1: Double, number2: Double) = number1/number2
}


