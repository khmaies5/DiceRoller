package com.khstudio.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * this activity allows the user to roll a dice and view the result
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // find button view in the layout
        val rollButton: Button = findViewById(R.id.button)

        // roll the dice on button click
        rollButton.setOnClickListener { rollDice() }

        // do a dice roll when app starts
        rollDice()
    }

    /**
     * Roll the dice and view the result
     */
    private fun rollDice() {
        // create new dice object with 6 sides
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // update the current screen with dice roll result
        val diceImageView: ImageView = findViewById(R.id.imageView)
        val drawableResource = when(diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImageView.setImageResource(drawableResource)
        // update the image content description
        diceImageView.contentDescription = diceRoll.toString()

    }
}