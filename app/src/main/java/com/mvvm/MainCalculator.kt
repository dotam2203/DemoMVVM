package com.mvvm

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mvvm.adapter.MathAdapter
import com.mvvm.databinding.ActivityMain2Binding
import com.mvvm.interfaces.OnClickButton
import com.mvvm.model.MathModel

class MainCalculator:AppCompatActivity() {
    private val RESULT_CAL: String? = "result_cal"
    lateinit var binding : ActivityMain2Binding
    val maths: ArrayList<MathModel> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        onClickStatus()
    }
    fun Sum(a: Float, b: Float) : Float = a+b
    fun Sub(a: Float, b: Float) : Float = a-b
    fun Mul(a: Float, b: Float) : Float = a*b
    fun Div(a: Float, b: Float) : Float = a/b
    fun Calculator(a: Float, b: Float, operation: (Float, Float)->Float): Float{
        return operation(a,b)
    }
    fun onClickStatus(){
        binding.onClickBtn = object : OnClickButton {
            override fun onCLickSum(view: View) {
                var a: Float = binding.txtNumber1.text.toString().toFloat()
                var b: Float = binding.txtNumber2.text.toString().toFloat()
                binding.tvResult.text = "$a + $b = ${Sum(a,b)}"
                maths.add(MathModel(a,b,Sum(a,b)))
            }

            override fun onCLickSub(view: View) {
                var a: Float = binding.txtNumber1.text.toString().toFloat()
                var b: Float = binding.txtNumber2.text.toString().toFloat()
                binding.tvResult.text = "$a - $b = ${Sub(a,b)}"
                maths.add(MathModel(a,b,Sub(a,b)))
            }

            override fun onCLickMul() {
                var a: Float = binding.txtNumber1.text.toString().toFloat()
                var b: Float = binding.txtNumber2.text.toString().toFloat()
                binding.tvResult.text = "$a x $b = ${Mul(a,b)}"
                maths.add(MathModel(a,b,Mul(a,b)))
            }

            override fun onCLickDiv() {
                var a: Float = binding.txtNumber1.text.toString().toFloat()
                var b: Float = binding.txtNumber2.text.toString().toFloat()
                binding.tvResult.text = "$a / $b = ${Div(a,b)}"
                maths.add(MathModel(a,b,Div(a,b)))
            }

            override fun onCLickResult(view: View) {
                passData(maths)
            }
        }
    }
    fun passData(maths: ArrayList<MathModel>){
        val intent = Intent(this@MainCalculator, MainResult::class.java)
        val bundle = Bundle()
        bundle.putParcelableArrayList(RESULT_CAL,maths)
        intent.putExtras(bundle)
        startActivity(intent)
    }

}

