package com.github.recaldev.practicingdesingpatterns.strategy.behavior.impl

import com.github.recaldev.practicingdesingpatterns.strategy.behavior.QuackBehavior

class Quack : QuackBehavior {

    override fun quack() {
        println("Quack like a real duck...")
    }
}