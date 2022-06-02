package com.mvvm

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mvvm.databinding.ActivityMain2Binding

class MainActivity2:AppCompatActivity() {
    lateinit var binding : ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtTitle.text.toString()
    }
    fun onClickBtn(view : android.view.View){
        binding.tvTitle.text = binding.txtTitle.text
    }
}