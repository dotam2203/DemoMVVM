package com.mvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mvvm.databinding.ItemMathBinding
import com.mvvm.model.MathModel

class MathAdapter(): RecyclerView.Adapter<MathAdapter.ViewHolder>(){
    var maths: List<MathModel> = listOf()
    class ViewHolder(val binding: ItemMathBinding): RecyclerView.ViewHolder(binding.root) {
        fun Data(result: String){
            binding.tvResultItem.text = result
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_math,parent,false)
        val view = ItemMathBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.Data(maths[position].Result())
    }

    override fun getItemCount(): Int {
        return maths.size
    }
    fun update(mathss: List<MathModel>){
        maths = mathss
        notifyDataSetChanged()
    }
}