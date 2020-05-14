package com.github.recaldev.practicingdesingpatterns.strategy.impl

import android.content.res.Resources
import android.util.TypedValue
import android.util.TypedValue.applyDimension
import com.github.recaldev.practicingdesingpatterns.R
import com.github.recaldev.practicingdesingpatterns.strategy.Duck
import com.github.recaldev.practicingdesingpatterns.strategy.behavior.impl.FlyNoWay
import com.github.recaldev.practicingdesingpatterns.strategy.behavior.impl.FlyWithWings
import com.github.recaldev.practicingdesingpatterns.strategy.behavior.impl.MuteQuack
import com.github.recaldev.practicingdesingpatterns.strategy.behavior.impl.Quack

class MallardDuck : Duck() {

    init {
        flyBehavior = FlyWithWings()
        quackBehavior = Quack()
    }

    override fun swim() {
        // Swimming like a duck...
    }

    override fun resource() = R.drawable.ic_mallard_duck

    override fun size(resources: Resources) = applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, 70f,
        resources.displayMetrics
    ).toInt()
}