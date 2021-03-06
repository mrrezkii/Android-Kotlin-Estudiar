package com.esdgabut.estudiar.data.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.esdgabut.estudiar.data.model.ReviewModel
import com.esdgabut.estudiar.data.model.TentorModel
import com.esdgabut.estudiar.data.view.adapter.ReviewAdapter
import com.esdgabut.estudiar.databinding.ActivityDetailTentorBinding
import com.esdgabut.estudiar.utils.createReviews

class DetailTentorActivity : AppCompatActivity() {

    private val data by lazy { intent.getParcelableExtra<TentorModel>("data") }
    private lateinit var adapter: ReviewAdapter

    private val binding: ActivityDetailTentorBinding by lazy {
        ActivityDetailTentorBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupView()
    }

    private fun setupView() {
        adapter = ReviewAdapter(createReviews() as ArrayList<ReviewModel>)
        binding.listReview.adapter = adapter
        Glide.with(binding.ivPhoto)
            .load(data?.url)
            .into(binding.ivPhoto)
        binding.tvTitle.text = data?.name
        binding.tvBack.setOnClickListener {
            finish()
        }
    }
}