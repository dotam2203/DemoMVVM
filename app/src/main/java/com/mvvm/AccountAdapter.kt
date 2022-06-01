package com.mvvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AccountAdapter : RecyclerView.Adapter<AccountAdapter.ViewHolder>() {
    var user = arrayOf("Tam", "Nhat", "Ha", "Hang", "Quoc")
    var phone = arrayOf("0123", "0234", "0345", "0456", "0678")

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvUser: TextView = itemView.findViewById(R.id.tvUser)
        var tvPhone: TextView = itemView.findViewById(R.id.tvPhone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AccountAdapter.ViewHolder, position: Int) {
        holder.tvUser.text = user[position]
        holder.tvPhone.text = phone[position]
    }

    override fun getItemCount(): Int {
        return user.size
    }
}