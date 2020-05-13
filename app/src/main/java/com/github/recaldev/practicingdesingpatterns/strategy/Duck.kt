package com.github.recaldev.practicingdesingpatterns.strategy

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.WRAP_CONTENT

abstract class Duck {

    enum class DuckType {
        MALLARD_DUCK, REDHEAD_DUCK, RUBBER_DUCK, DECOY_DUCK
    }

    private lateinit var duckBitmap: Bitmap

    lateinit var duckImage: ImageView

    abstract fun quack()
    abstract fun swim()
    abstract fun resource(): Int
    abstract fun size(resources: Resources): Int

    fun display(root: ViewGroup, xPosition: Float, yPosition: Float) {
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

                x = xPosition
                y = yPosition
            })
        }
    }
}