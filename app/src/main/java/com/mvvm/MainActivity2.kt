package com.mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mvvm.databinding.ActivityMain2Binding

class MainActivity2:AppCompatActivity() {
    lateinit var binding : ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.setOnClickSum{
            var a: Float = binding.txtNumber1.text.toString().toFloat()
            var b: Float = binding.txtNumber2.text.toString().toFloat()
            binding.tvResult.text = "$a + $b = ${Sum(a,b)}"
        }
        binding.setOnClickSub {
            var a: Float = binding.txtNumber1.text.toString().toFloat()
            var b: Float = binding.txtNumber2.text.toString().toFloat()
            binding.tvResult.text = "$a - $b = ${Sub(a,b)}"
        }
        binding.setOnClickMul {
            var a: Float = binding.txtNumber1.text.toString().toFloat()
            var b: Float = binding.txtNumber2.text.toString().toFloat()
            binding.tvResult.text = "$a x $b = ${Mul(a,b)}"
        }
        binding.setOnClickDiv {
            var a: Float = binding.txtNumber1.text.toString().toFloat()
            var b: Float = binding.txtNumber2.text.toString().toFloat()
            binding.tvResult.text = "$a / $b = ${Div(a,b)}"
        }
    }
    fun Sum(a: Float, b: Float) : Float = a+b
    fun Sub(a: Float, b: Float) : Float = a-b
    fun Mul(a: Float, b: Float) : Float = a*b
    fun Div(a: Float, b: Float) : Float = a/b
}