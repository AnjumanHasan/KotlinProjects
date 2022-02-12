package kotlinprojects.matchinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinprojects.matchinggame.R.drawable.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val images : MutableList<Int> = mutableListOf(cottoncandy,cupcake,donut,icecream,pancake,pudding)
        val buttons = arrayOf(R.id.button,R.id.button2,R.id.button3,R.id.button4,R.id.button5,
                R.id.button6,R.id.button7,R.id.button8,R.id.button9,R.id.button10,R.id.button11,R.id.button12)
    }
}