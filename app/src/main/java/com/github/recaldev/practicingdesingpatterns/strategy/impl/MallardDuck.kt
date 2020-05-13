package com.github.recaldev.practicingdesingpatterns.strategy.impl

import android.content.res.Resources
import android.util.TypedValue
import android.util.TypedValue.applyDimension
import com.github.recaldev.practicingdesingpatterns.R
import com.github.recaldev.practicingdesingpatterns.strategy.Duck

class MallardDuck : Duck() {

    override fun quack() {
        TODO("Not yet implemented")
    }

    override fun swim() {
        TODO("Not yet implemented")
    }

    override fun resource() = R.drawable.ic_mallard_duck

    override fun size(resources: Resources) = applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, 70f,
        resources.displayMetrics
    ).toInt()
}