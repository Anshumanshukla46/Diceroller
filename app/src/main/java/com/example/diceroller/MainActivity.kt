package com.example.diceroller

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//      to get Button's reference i.e., where to set listener
        val rollingButton: Button = findViewById(R.id.button)

        // show a random number when app starts
        rollDice()

        rollingButton.setOnClickListener {
            rollDice()
        }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6) // assuming sides of dice to be 6
        val diceRoll = dice.roll()

        // Update the screen with the Dice roll
        val diceImage :ImageView = findViewById(R.id.imageView)
        val drawableImage = when(diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // setting Image according to rolled number
        diceImage.setImageResource(drawableImage)

        // setting content description i.e., whenever screen read correct number should be spoken
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}