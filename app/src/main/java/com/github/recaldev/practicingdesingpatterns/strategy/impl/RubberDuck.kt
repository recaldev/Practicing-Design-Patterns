package com.github.recaldev.practicingdesingpatterns.strategy.impl

import android.content.res.Resources
import android.util.TypedValue
import com.github.recaldev.practicingdesingpatterns.R
import com.github.recaldev.practicingdesingpatterns.strategy.Duck

class RubberDuck : Duck() {

    override fun quack() {
        // Quaking like a duck? But I'm no real duck!
    }

    override fun swim() {
        // Swimming like a duck...
    }

    override fun resource(): Int = R.drawable.ic_rubber_duck

    override fun size(resources: Resources) = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, 50f,
        resources.displayMetrics
    ).toInt()
}