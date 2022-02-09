package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SplitPage : AppCompatActivity()  {

    lateinit var splitButton: Button
    lateinit var splitIn : TextView
    lateinit var bill : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_split_page)
        splitButton=findViewById(R.id.finalSplit)
        splitIn = findViewById(R.id.splitIn)
        bill=findViewById(R.id.totalValue)
    }
}