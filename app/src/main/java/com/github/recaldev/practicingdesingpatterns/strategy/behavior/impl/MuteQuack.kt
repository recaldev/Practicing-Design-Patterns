package com.github.recaldev.practicingdesingpatterns.strategy.behavior.impl

import com.github.recaldev.practicingdesingpatterns.strategy.behavior.QuackBehavior

class MuteQuack : QuackBehavior {

    override fun quack() {
        println("Sorry bro, I don't know how to quack...")
    }
}