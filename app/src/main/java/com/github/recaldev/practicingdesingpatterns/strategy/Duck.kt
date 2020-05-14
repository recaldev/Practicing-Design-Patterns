package com.github.recaldev.practicingdesingpatterns.strategy

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.WRAP_CONTENT
import com.github.recaldev.practicingdesingpatterns.strategy.behavior.FlyBehavior
import com.github.recaldev.practicingdesingpatterns.strategy.behavior.QuackBehavior

abstract class Duck {

    enum class DuckType {
        MALLARD_DUCK, REDHEAD_DUCK, RUBBER_DUCK, DECOY_DUCK
    }

    private lateinit var duckBitmap: Bitmap
    protected lateinit var flyBehavior: FlyBehavior
    protected lateinit var quackBehavior: QuackBehavior

    lateinit var duckImage: ImageView

    abstract fun swim()
    abstract fun resource(): Int
    abstract fun size(resources: Resources): Int

    fun display(root: ViewGroup) {
        if (::duckImage.isInitialized.not()) {
            duckImage = ImageView(root.context)
            root.addView(duckImage.apply {
                if (::duckBitmap.isInitialized.not()) {
                    duckBitmap = BitmapFactory.decodeResource(resources, resource())
                }
                setImageBitmap(duckBitmap)

                layoutParams = ConstraintLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)

                val size = size(resources)
                layoutParams.height = size
                layoutParams.width = size
            })
        }
    }

    fun performQuack() = quackBehavior.quack()

    fun performFly(xPosition: Float, yPosition: Float) = flyBehavior.fly(duckImage, xPosition, yPosition)

    fun stopFlying() = duckImage.clearAnimation()
}