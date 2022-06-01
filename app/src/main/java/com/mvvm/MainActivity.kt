package com.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mvvm.databinding.ActivityMainBinding
import com.mvvm.model.Account

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var adapter = AccountAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rcvAcc.adapter = adapter
        binding.rcvAcc.layoutManager = LinearLayoutManager(this)
    }
}