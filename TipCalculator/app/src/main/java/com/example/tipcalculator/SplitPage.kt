package com.example.tipcalculator

import android.opengl.ETC1
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SplitPage : AppCompatActivity()  {

    lateinit var splitButton: Button
    lateinit var splitIn : EditText
    lateinit var bill: TextView
    lateinit var splitShare: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_split_page)
        splitButton=findViewById(R.id.finalSplit)
        splitIn = findViewById(R.id.splitIn)
        splitShare=findViewById(R.id.splitShare)

        var bill : String? = intent.getStringExtra("value")




        splitButton.setOnClickListener {
            val value = bill.toString().toFloat()/splitIn.text.toString().toFloat()
                    splitShare.text="%.2f".format(value)
        }
    }
}



