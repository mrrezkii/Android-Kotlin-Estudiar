package com.esdgabut.estudiar.data.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.esdgabut.estudiar.data.model.TentorModel
import com.esdgabut.estudiar.databinding.AdapterTentorBinding

class TentorCardStackAdapter(
    private var tentors: List<TentorModel> = emptyList(),
    val listerner: OnAdapterListener
) : RecyclerView.Adapter<TentorCardStackAdapter.ViewHolder>() {

    class ViewHolder(val binding: AdapterTentorBinding) : RecyclerView.ViewHolder(binding.root)

    interface OnAdapterListener {
        fun onClick(result: TentorModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        AdapterTentorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tentor = tentors[position]
        holder.binding.itemName.text = "${tentor.name}"
        Glide.with(holder.binding.itemImage)
            .load(tentor.url)
            .into(holder.binding.itemImage)
        holder.itemView.setOnClickListener {
            listerner.onClick(tentor)
        }
    }

    override fun getItemCount(): Int = tentors.size

    fun getTentors(): List<TentorModel> = tentors

    fun setTentors(tentors: List<TentorModel>) {
        this.tentors = tentors
    }
}