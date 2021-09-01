package com.esdgabut.estudiar.data.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.esdgabut.estudiar.data.view.adapter.OnboardingAdapter
import com.esdgabut.estudiar.data.viewmodel.MainViewModel
import com.esdgabut.estudiar.data.viewmodel.factory.MainViewModelFactory
import com.esdgabut.estudiar.databinding.ActivityOnboardingBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class OnboardingActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val viewModelFactory: MainViewModelFactory by instance()
    private lateinit var viewModel: MainViewModel
    private val binding: ActivityOnboardingBinding by lazy {
        ActivityOnboardingBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupView()
        setupViewModelAndSetPref()
    }

    private fun setupView() {
        val adapter = OnboardingAdapter(supportFragmentManager, lifecycle)
        binding.viewpager.adapter = adapter
        binding.dotsIndicator.setViewPager2(binding.viewpager)
    }

    private fun setupViewModelAndSetPref() {
        viewModel =
            ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        binding.tvSkip.setOnClickListener {
            startActivity(
                Intent(
                    this@OnboardingActivity,
                    MainActivity::class.java
                )
            )
            viewModel.savePreferencesOnboarding(false)
            finish()
        }
    }
}