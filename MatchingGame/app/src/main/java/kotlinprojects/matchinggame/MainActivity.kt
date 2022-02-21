package kotlinprojects.matchinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import kotlinprojects.matchinggame.R.drawable.*

class MainActivity : AppCompatActivity() {

    private lateinit var cards : List<MemoryCard>
    private lateinit var buttons : Array<ImageButton>
    private var indexofSelectedCard : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button1: ImageButton = findViewById(R.id.button)
        var button2: ImageButton = findViewById(R.id.button2)
        var button3: ImageButton = findViewById(R.id.button3)
        var button4: ImageButton = findViewById(R.id.button4)
        var button6: ImageButton = findViewById(R.id.button6)
        var button7: ImageButton = findViewById(R.id.button7)
        var button8: ImageButton = findViewById(R.id.button8)
        var button5: ImageButton = findViewById(R.id.button5)
        var button9: ImageButton = findViewById(R.id.button9)
        var button10: ImageButton = findViewById(R.id.button10)
        var button11: ImageButton = findViewById(R.id.button11)
        var button12: ImageButton = findViewById(R.id.button12)



        val images : MutableList<Int> = mutableListOf(cottoncandy,donut,icecream,pancake,pudding,cupcake,
            cottoncandy,cupcake,donut,icecream,pancake,pudding)
        buttons  = arrayOf(button1,button2,button3,button4,button5,button6,button7,button8,
        button9,button10,button11,button12)


        images.shuffle()
        cards = buttons.indices.map { index ->
            MemoryCard(images[index], isFaceUp = false, isMatched = false)
        }

        buttons.forEachIndexed { index, button ->
            button.setOnClickListener {

                updateModels(index)
                updateViews()

            }

        }

    }

    private fun updateViews() {
        cards.forEachIndexed { index, card ->
            var button = buttons[index]
            button.setBackgroundResource(if (card.isFaceUp) card.identifier else (help))
            if(card.isMatched)
            {
                button.alpha =0.08f
            }
        }

    }

    private fun updateModels(position : Int) {
        val card = cards[position]
        if(card.isFaceUp)
        {
            Toast.makeText(this, "Invalid Move!", Toast.LENGTH_SHORT).show()
            return
        }
        if(indexofSelectedCard == null)
        {
            restoreCards()
            indexofSelectedCard = position
        }
        else
        {
            checkForMatch(indexofSelectedCard!!,position)
            indexofSelectedCard =null
        }


        card.isFaceUp = !card.isFaceUp
    }

    private fun restoreCards() {
        for(card in cards)
        {
            if (!card.isMatched)
            {
                card.isFaceUp= false
            }
        }
    }

    private fun checkForMatch(card1 :Int, card2 : Int) {
        if (cards[card1].identifier==cards[card2].identifier)
        {
            cards[card1].isMatched =true
            cards[card2].isMatched =true
            Toast.makeText(this, "You found a Match!", Toast.LENGTH_SHORT).show()
        }

    }
}