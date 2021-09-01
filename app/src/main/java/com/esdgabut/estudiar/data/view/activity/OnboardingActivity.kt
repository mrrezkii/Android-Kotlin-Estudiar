package com.esdgabut.estudiar.data.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.esdgabut.estudiar.data.view.adapter.OnboardingAdapter
import com.esdgabut.estudiar.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {

    private val binding: ActivityOnboardingBinding by lazy {
        ActivityOnboardingBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupView()
    }

    private fun setupView() {
        val adapter = OnboardingAdapter(supportFragmentManager, lifecycle)
        binding.viewpager.adapter = adapter
        binding.dotsIndicator.setViewPager2(binding.viewpager)
    }
}