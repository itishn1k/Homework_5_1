package com.example.homework_5_1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homework_5_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View {
    private lateinit var binding: ActivityMainBinding
    private val presenter = Presenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        initClickers()
        presenter.attachView(this)
    }

    private fun initClickers() {
        with(binding) {
            btnInc.setOnClickListener {
                presenter.increment()
            }
            btnDec.setOnClickListener {
                presenter.decrement()
            }
        }
    }

    override fun changeCount(count: Int) {
        binding.tvZero.text = count.toString()
    }

    override fun changeColorToGreen() {
        binding.tvZero.setTextColor(Color.parseColor("#268F2B"))
    }

    override fun showToast() {
        Toast.makeText(this, "Поздравляем", Toast.LENGTH_SHORT).show()
    }
}