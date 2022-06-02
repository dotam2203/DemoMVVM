package com.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mvvm.databinding.ActivityMainBinding
import com.mvvm.model.Account
import org.w3c.dom.Text

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
        }
    }
}


