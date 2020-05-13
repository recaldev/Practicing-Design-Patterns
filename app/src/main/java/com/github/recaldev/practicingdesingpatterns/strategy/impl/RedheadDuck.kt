package com.github.recaldev.practicingdesingpatterns.strategy.impl

import android.content.res.Resources
import android.util.TypedValue
import com.github.recaldev.practicingdesingpatterns.R
import com.github.recaldev.practicingdesingpatterns.strategy.Duck

class RedheadDuck : Duck() {

    override fun quack() {
        // Quaking like a duck...
    }

    override fun swim() {
        // Swimming like a duck...
    }

    override fun resource(): Int = R.drawable.ic_red_head_duck

    override fun size(resources: Resources) = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, 95f,
        resources.displayMetrics
    ).toInt()
}