package com.github.recaldev.practicingdesingpatterns.strategy

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.WRAP_CONTENT

private const val ANIMATION_DURATION = 2000L

abstract class Duck {

    enum class DuckType {
        MALLARD_DUCK, REDHEAD_DUCK, RUBBER_DUCK, DECOY_DUCK
    }

    private lateinit var duckBitmap: Bitmap
    private lateinit var leftToRightTranslate: TranslateAnimation
    private lateinit var rightToLeftTranslate: TranslateAnimation

    lateinit var duckImage: ImageView

    abstract fun quack()
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

    fun fly(xPosition: Float, yPosition: Float) {
        duckImage.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                duckImage.viewTreeObserver.removeOnGlobalLayoutListener(this)

                val duckWidth = duckImage.width.toFloat()

                leftToRightTranslate = TranslateAnimation(-duckWidth, xPosition + duckWidth, yPosition, yPosition).apply {
                    duration = ANIMATION_DURATION
                    interpolator = AccelerateDecelerateInterpolator()
                    setAnimationListener(object : Animation.AnimationListener {
                        override fun onAnimationEnd(animation: Animation) {
                            duckImage.scaleX = -1f
                            duckImage.startAnimation(rightToLeftTranslate)
                        }

                        override fun onAnimationRepeat(animation: Animation) = Unit
                        override fun onAnimationStart(animation: Animation) = Unit
                    })
                }

                rightToLeftTranslate = TranslateAnimation(xPosition + duckWidth, -duckWidth, yPosition, yPosition).apply {
                    duration = ANIMATION_DURATION
                    interpolator = AccelerateDecelerateInterpolator()
                    setAnimationListener(object : Animation.AnimationListener {
                        override fun onAnimationEnd(animation: Animation?) {
                            duckImage.scaleX = 1f
                            duckImage.startAnimation(leftToRightTranslate)
                        }

                        override fun onAnimationRepeat(animation: Animation) = Unit
                        override fun onAnimationStart(animation: Animation) = Unit
                    })
                }

                duckImage.startAnimation(leftToRightTranslate)
            }
        })
    }

    fun stopFlying() {
        duckImage.clearAnimation()
        leftToRightTranslate = TranslateAnimation(0f, 0f, 0f, 0f)
        rightToLeftTranslate = TranslateAnimation(0f, 0f, 0f, 0f)
    }
}