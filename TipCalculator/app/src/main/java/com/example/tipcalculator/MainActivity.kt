package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import java.util.*
import android.view.View

private val initialTip = 0
class MainActivity : AppCompatActivity()  {
    lateinit var seekBar :SeekBar
    lateinit var bill : EditText
    lateinit var tipText : TextView
    lateinit var tip :TextView
    lateinit var totalValue :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            seekBar =findViewById(R.id.seekBar)
            bill= findViewById(R.id.billTotal)
            tipText = findViewById(R.id.textTip)
            tip = findViewById(R.id.tipValue)
            totalValue  =findViewById(R.id.totalValue)

        seekBar.progress = initialTip
        tipText.text ="$initialTip%"
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                tipText.text = "$p1%"

                computeTipandTotal()
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