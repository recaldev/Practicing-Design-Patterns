package com.github.recaldev.practicingdesingpatterns

import android.os.Bundle
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity
import com.github.recaldev.practicingdesingpatterns.databinding.ActivityMainBinding
import com.github.recaldev.practicingdesingpatterns.strategy.Duck
import com.github.recaldev.practicingdesingpatterns.strategy.Duck.DuckType
import com.github.recaldev.practicingdesingpatterns.strategy.Duck.DuckType.*
import com.github.recaldev.practicingdesingpatterns.strategy.impl.DecoyDuck
import com.github.recaldev.practicingdesingpatterns.strategy.impl.MallardDuck
import com.github.recaldev.practicingdesingpatterns.strategy.impl.RedheadDuck
import com.github.recaldev.practicingdesingpatterns.strategy.impl.RubberDuck
import com.github.recaldev.practicingdesingpatterns.utils.RandomEnum
import kotlinx.android.synthetic.main.activity_main.view.*
import java.security.SecureRandom

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var screenHeight: Int = 0
    private var screenWidth: Int = 0

    private val duckTypes = RandomEnum(DuckType::class.java)
    private val secureRandom = SecureRandom()
    private val ducks = mutableListOf<Duck>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        screenHeight = displayMetrics.heightPixels
        screenWidth = displayMetrics.widthPixels

        binding.btnCreateDuck.setOnClickListener { flyLittleDuck() }
        binding.btnResetScreen.setOnClickListener { resetScreen() }
    }

    private fun randomizeDuck(): Duck = when (duckTypes.random()) {
        MALLARD_DUCK -> MallardDuck()
        REDHEAD_DUCK -> RedheadDuck()
        RUBBER_DUCK -> RubberDuck()
        DECOY_DUCK -> DecoyDuck()
    }

    private fun flyLittleDuck() {
        val yPosition = secureRandom.nextInt((screenHeight - (screenHeight / 2))).toFloat()

        ducks.add(randomizeDuck().apply {
            display(binding.root.container)
            fly(screenWidth.toFloat(), yPosition)
        })
    }

    private fun resetScreen() {
        ducks.forEach { it.stopFlying() }
        binding.root.container.removeAllViews()
        ducks.clear()
    }
}