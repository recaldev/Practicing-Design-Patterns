package com.github.recaldev.practicingdesingpatterns.utils

import java.security.SecureRandom

internal class RandomEnum<E : Enum<E>>(token: Class<E>) {

    private val values: Array<E> = token.enumConstants as Array<E>

    fun random(): E {
        return values[RND.nextInt(values.size)]
    }

    companion object {
        private val RND: SecureRandom = SecureRandom()
    }

}