package com.mvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mvvm.databinding.ActivityItemBinding
import com.mvvm.model.Account

class AccountAdapter (val _itemClick : onItemClick) : RecyclerView.Adapter<AccountAdapter.ViewHolder>() {
    var acc:List<Account> = listOf()
    inner class ViewHolder(val binding :  ActivityItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onItemClickk(acc: Account){
            binding.setOnItemClick {
                _itemClick.onClick(acc)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountAdapter.ViewHolder {
        val view = ActivityItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: AccountAdapter.ViewHolder, position: Int) {
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