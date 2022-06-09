package com.mvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mvvm.databinding.ItemAccountBinding
import com.mvvm.model.Account

class AccountAdapter (val _itemClick : onItemClick) : RecyclerView.Adapter<AccountAdapter.ViewHolder>() {
    var acc:List<Account> = listOf()
    inner class ViewHolder(val binding :  ItemAccountBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onItemClickk(acc: Account){
            binding.setOnItemClick {
                _itemClick.onClick(acc)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemAccountBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            binding.acc = acc[position]
            onItemClickk(acc[position])
        }
    }
    override fun getItemCount(): Int {
        return acc.size
    }
    fun update(accs: List<Account>){
        acc = accs
        notifyDataSetChanged()
    }
    interface onItemClick{
        fun onClick(acc:Account)
    }
}