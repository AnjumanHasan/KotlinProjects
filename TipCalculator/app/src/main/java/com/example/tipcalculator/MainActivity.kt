package com.example.tipcalculator

import android.animation.ArgbEvaluator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.content.ContextCompat

private val initialTip = 0
 class MainActivity : AppCompatActivity()  {
    lateinit var seekBar :SeekBar
    lateinit var bill : EditText
    lateinit var tipText : TextView
    lateinit var tip :TextView
    lateinit var totalValue :TextView
    lateinit var tipDescription : TextView
    lateinit var splitButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            seekBar =findViewById(R.id.seekBar)
            bill= findViewById(R.id.billTotal)
            tipText = findViewById(R.id.textTip)
            tip = findViewById(R.id.tipValue)
            totalValue  =findViewById(R.id.totalValue)
        tipDescription= findViewById(R.id.tipDescription)
        splitButton = findViewById(R.id.splitButton)
        seekBar.progress = initialTip
        tipText.text ="$initialTip%"
        tipDescription.text = ""

            splitButton.setOnClickListener{
                val intent = Intent(this,SplitPage :: class.java);
                val value = totalValue.text.toString()
                intent.putExtra("message_key",value)
                startActivity(intent)
            }
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                tipText.text = "$p1%"

                computeTipandTotal()
                setTipDescription(p1)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}

        })
        bill.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
             computeTipandTotal()

            }

        })
    }

    private fun setTipDescription(p1: Int) {
       val message = when(p1)
       {
           in 0..10 -> "Poor!"
           in 11..20 -> "Average!"
           in 21..30 -> "Good!"
           else -> "Amazing!"
       }
        tipDescription.text = message
        val color =ArgbEvaluator().evaluate(
            p1.toFloat()/seekBar.max,
            ContextCompat.getColor(this,R.color.poorTip),
            ContextCompat.getColor(this,R.color.amazingTip)
        ) as Int
        tipDescription.setTextColor(color)
    }

    private fun computeTipandTotal() {
        if (bill.text.isEmpty())
            {
            tip.text=""
                totalValue.text =""
                return
            }

        val amount = bill.text.toString().toDouble()
        val tipamount = seekBar.progress

        val tipValue= amount*tipamount/100
        val total = amount + tipValue

        tip.text = "%.2f".format(tipValue)
        totalValue.text = "%.2f".format(total)
    }


}