package com.github.recaldev.practicingdesingpatterns.strategy.behavior.impl

import android.widget.ImageView
import com.github.recaldev.practicingdesingpatterns.strategy.behavior.FlyBehavior

class FlyNoWay : FlyBehavior {

    override fun fly(duckImage: ImageView, xPosition: Float, yPosition: Float) {
        println("Sorry pal, I cannot fly...")
    }
}