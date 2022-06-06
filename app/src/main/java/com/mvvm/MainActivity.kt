package com.mvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
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
        Demo()

        binding.setOnClickSubmit {
            /*accList.add(Account(binding.txtUser.text.toString(),binding.txtPhone.text.toString()))
            accountAdapter.update(accList)
            binding.txtUser.setText("")
            binding.txtPhone.setText("")*/

            startActivity(Intent(this@MainActivity, MainActivity2::class.java))
        }
    }

    fun Demo() {
        /*val y: Int = 10
        for(i in y downTo 1 step 3 ){
            Log.d("AAA", "\n$i")
        }*/
        /*var arrayList: ArrayList<String> = ArrayList()
        arrayList.add("Tâm")
        arrayList.add("Hà")
        arrayList.add("Nhật")
        Log.d("AAA", "Demo1: ${arrayList.size}")
        arrayList.removeAt(1)
        arrayList.set(1,"ABC")
        Log.d("AAA", "Demo2: ${arrayList.get(1)}")
        Log.d("AAA", "Demo1: ${arrayList.size}")*/
        Log.d("AAA", "Demo: ${Result(3,4)}")


    }
    fun Result(a: Int, b: Int): Int = (a+b)

}


