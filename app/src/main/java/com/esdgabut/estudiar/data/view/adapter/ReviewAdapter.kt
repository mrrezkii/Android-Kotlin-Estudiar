package com.esdgabut.estudiar.data.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.esdgabut.estudiar.data.model.ReviewModel
import com.esdgabut.estudiar.databinding.AdapterReviewBinding

class ReviewAdapter(
    var reviews: ArrayList<ReviewModel>
) : RecyclerView.Adapter<ReviewAdapter.ViewHolder>() {

    class ViewHolder(val binding: AdapterReviewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        AdapterReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val review = reviews[position]
        holder.binding.tvName.text = review.name
        holder.binding.tvReview.text = review.review
        holder.binding.tvScore.text = review.score.toString()
    }

    override fun getItemCount() = reviews.size

    fun setData(data: List<ReviewModel>) {
        reviews.clear()
        reviews.addAll(data)
        notifyDataSetChanged()
    }


}