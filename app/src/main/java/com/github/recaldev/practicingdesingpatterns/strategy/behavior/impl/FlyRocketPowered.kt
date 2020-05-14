package com.github.recaldev.practicingdesingpatterns.strategy.behavior.impl

import android.widget.ImageView
import com.github.recaldev.practicingdesingpatterns.strategy.behavior.FlyBehavior

class FlyRocketPowered : FlyBehavior {

    override fun fly(duckImage: ImageView, xPosition: Float, yPosition: Float) {
        println("To infinity and beyond...")
    }
}