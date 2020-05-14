package com.github.recaldev.practicingdesingpatterns.strategy.behavior.impl

import android.view.ViewTreeObserver
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import com.github.recaldev.practicingdesingpatterns.strategy.behavior.FlyBehavior

private const val ANIMATION_DURATION = 2000L

class FlyWithWings : FlyBehavior {

    private lateinit var leftToRightTranslate: TranslateAnimation
    private lateinit var rightToLeftTranslate: TranslateAnimation

    override fun fly(duckImage: ImageView, xPosition: Float, yPosition: Float) {
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
}