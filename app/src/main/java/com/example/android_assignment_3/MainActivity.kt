package com.example.android_assignment_3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private lateinit var screen: TextView
    private lateinit var btn0: Button
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    private lateinit var btnAdd: Button
    private lateinit var btnSub: Button
    private lateinit var btnMul: Button
    private lateinit var btnDiv: Button
    private lateinit var btnDot: Button
    private lateinit var btnEqual: Button
    private lateinit var btnDel: Button

    private var firstNumber = 0.0
    private var secondNumber = 0.0
    private var operation = ""


    private fun init() {
        screen = findViewById(R.id.screen)
        btn0 = findViewById(R.id.b0)
        btn1 = findViewById(R.id.b1)
        btn2 = findViewById(R.id.b2)
        btn3 = findViewById(R.id.b3)
        btn4 = findViewById(R.id.b4)
        btn5 = findViewById(R.id.b5)
        btn6 = findViewById(R.id.b6)
        btn7 = findViewById(R.id.b7)
        btn8 = findViewById(R.id.b8)
        btn9 = findViewById(R.id.b9)
        btnAdd = findViewById(R.id.add)
        btnSub = findViewById(R.id.substract)
        btnMul = findViewById(R.id.multiply)
        btnDiv = findViewById(R.id.divide)
        btnDot = findViewById(R.id.dot)
        btnEqual = findViewById(R.id.equals)
        btnDel = findViewById(R.id.del)

        btn0.setOnClickListener { addText(btn0) }
        btn1.setOnClickListener { addText(btn1) }
        btn2.setOnClickListener { addText(btn2) }
        btn3.setOnClickListener { addText(btn3) }
        btn4.setOnClickListener { addText(btn4) }
        btn5.setOnClickListener { addText(btn5) }
        btn6.setOnClickListener { addText(btn6) }
        btn7.setOnClickListener { addText(btn7) }
        btn8.setOnClickListener { addText(btn8) }
        btn9.setOnClickListener { addText(btn9) }
        btnDot.setOnClickListener { addText(btnDot) }

        btnAdd.setOnClickListener { addOperation(btnAdd) }
        btnSub.setOnClickListener { addOperation(btnSub) }
        btnMul.setOnClickListener { addOperation(btnMul) }
        btnDiv.setOnClickListener { addOperation(btnDiv) }

        btnEqual.setOnClickListener { equal() }

        btnDel.setOnLongClickListener {
            clearText()
            true
        }
        btnDel.setOnClickListener { delText() }
    }


    private fun clearText() {
        screen.text = ""
    }

    @SuppressLint("SetTextI18n")
    private fun addText(button: Button) {
        screen.text = screen.text.toString() + button.text.toString()
    }

    private fun delText() {
        var text = screen.text.toString()
        if (text.isNotEmpty()) {
            text = text.substring(0, text.length - 1)
            screen.text = text
        }
    }

    private fun addOperation(button: Button) {
        firstNumber = screen.text.toString().toDouble()
        operation = button.text.toString()
        screen.text = ""
    }

    private fun equal() {
        val screenText = screen.text.toString()
        if (screenText == "") {
            firstNumber = 0.0
            return
        }

        secondNumber = screenText.toDouble()

        var result = 0.0

        when (operation) {
            "+" -> result = firstNumber + secondNumber
            "-" -> result = firstNumber - secondNumber
            "x" -> result = firstNumber * secondNumber
            "÷" -> result = firstNumber / secondNumber
        }

        if (result % 1 == 0.0) {
            screen.text = result.toInt().toString()
        } else {
            screen.text = result.toString()
        }

        firstNumber = 0.0

    }

}


