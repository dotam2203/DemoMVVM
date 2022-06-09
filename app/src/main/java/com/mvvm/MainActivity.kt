package com.mvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mvvm.adapter.AccountAdapter
import com.mvvm.databinding.ActivityMainBinding
import com.mvvm.model.Account

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var accountAdapter = AccountAdapter(object : AccountAdapter.onItemClick{
        override fun onClick(acc: Account) {
            binding.txtUser.setText(acc.userName)
            binding.txtPhone.setText(acc.phone)
        }
    })
    val accList : ArrayList<Account> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rcvAcc.apply {
            adapter = accountAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        binding.setOnClickSubmit {
            accList.add(Account(binding.txtUser.text.toString(),binding.txtPhone.text.toString()))
            accountAdapter.update(accList)
            binding.txtUser.setText("")
            binding.txtPhone.setText("")

            startActivity(Intent(this@MainActivity, MainCalculator::class.java))
        }
    }

}


