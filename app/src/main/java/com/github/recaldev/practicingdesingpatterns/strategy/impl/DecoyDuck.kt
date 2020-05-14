package com.github.recaldev.practicingdesingpatterns.strategy.impl

import android.content.res.Resources
import android.util.TypedValue
import com.github.recaldev.practicingdesingpatterns.R
import com.github.recaldev.practicingdesingpatterns.strategy.Duck
import com.github.recaldev.practicingdesingpatterns.strategy.behavior.impl.FlyNoWay
import com.github.recaldev.practicingdesingpatterns.strategy.behavior.impl.MuteQuack

class DecoyDuck : Duck() {

    init {
        flyBehavior = FlyNoWay()
        quackBehavior = MuteQuack()
    }

    override fun swim() {
        // Swimming like a duck...
    }

    override fun resource(): Int = R.drawable.ic_decoy_duck

    override fun size(resources: Resources) = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, 60f,
        resources.displayMetrics
    ).toInt()
}