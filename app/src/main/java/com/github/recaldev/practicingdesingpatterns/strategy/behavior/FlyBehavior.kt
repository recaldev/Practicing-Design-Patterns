package com.github.recaldev.practicingdesingpatterns.strategy.behavior

import android.widget.ImageView

interface FlyBehavior {
    fun fly(duckImage: ImageView, xPosition: Float, yPosition: Float)
}