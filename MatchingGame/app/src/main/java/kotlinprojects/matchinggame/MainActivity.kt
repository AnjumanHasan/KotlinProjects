package kotlinprojects.matchinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import kotlinprojects.matchinggame.R.drawable.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button1: ImageButton = findViewById(R.id.button)
        var button2: ImageButton = findViewById(R.id.button2)
        var button3: ImageButton = findViewById(R.id.button3)
        var button4: ImageButton = findViewById(R.id.button4)
        var button5: ImageButton = findViewById(R.id.button5)
        var button6: ImageButton = findViewById(R.id.button6)
        var button7: ImageButton = findViewById(R.id.button7)
        var button8: ImageButton = findViewById(R.id.button8)
        var button9: ImageButton = findViewById(R.id.button9)
        var button10: ImageButton = findViewById(R.id.button10)
        var button11: ImageButton = findViewById(R.id.button11)
        var button12: ImageButton = findViewById(R.id.button12)

        val images : MutableList<Int> = mutableListOf(cottoncandy,cupcake,donut,icecream,pancake,pudding,
            cottoncandy,cupcake,donut,icecream,pancake,pudding)
        val buttons : Array<ImageButton> = arrayOf(button1,button2,button3,button4,button5,button6,button7,button8,
        button9,button10,button11,button12)

        images.shuffle()
        for (i in 0..11)
        {
           // buttons[i].setImageResource(cottoncandy)
            buttons[i].textDirection = 1
            buttons[i].setOnClickListener{
                if (buttons[i].textDirection == 1)
                {
                    buttons[i].setImageResource(images[i])
                }
            }
        }
    }
}