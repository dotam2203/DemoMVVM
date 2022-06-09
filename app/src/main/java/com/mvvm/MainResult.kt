package com.mvvm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mvvm.adapter.MathAdapter
import com.mvvm.databinding.ActivityMathResultBinding
import com.mvvm.model.MathModel

class MainResult: AppCompatActivity() {
    private val RESULT_CAL: String? = "result_cal"
    var maths: ArrayList<MathModel>? = arrayListOf()
    lateinit var binding: ActivityMathResultBinding
    val mathAdapter = MathAdapter()
    val mathLayoutManager = LinearLayoutManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMathResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        receivingData()
        binding.rvMathList.apply {
            layoutManager = mathLayoutManager
            adapter = mathAdapter
        }
        maths?.let {
            mathAdapter.update(it)
        }
    }
    fun receivingData(){
        val bundle = intent.extras
        maths = bundle?.getParcelableArrayList(RESULT_CAL)
    }
}