package com.github.recaldev.practicingdesingpatterns.strategy.behavior.impl

import com.github.recaldev.practicingdesingpatterns.strategy.behavior.QuackBehavior

class Squeak : QuackBehavior {

    override fun quack() {
        println("Quack with a squeak sound...")
    }
}