package com.esdgabut.estudiar.data.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.esdgabut.estudiar.data.model.TentorModel
import com.esdgabut.estudiar.databinding.AdapterTentorBinding

class TentorCardStackAdapter(
    private var tentors: List<TentorModel> = emptyList()
) : RecyclerView.Adapter<TentorCardStackAdapter.ViewHolder>() {

    class ViewHolder(val binding: AdapterTentorBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        AdapterTentorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tentor = tentors[position]
        holder.binding.itemName.text = "${tentor.id}. ${tentor.name}"
        holder.binding.itemCity.text = tentor.city
        Glide.with(holder.binding.itemImage)
            .load(tentor.url)
            .into(holder.binding.itemImage)
        holder.itemView.setOnClickListener { v ->
            Toast.makeText(v.context, tentor.name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = tentors.size

    fun getTentors(): List<TentorModel> = tentors

    fun setTentors(tentors: List<TentorModel>) {
        this.tentors = tentors
    }
}