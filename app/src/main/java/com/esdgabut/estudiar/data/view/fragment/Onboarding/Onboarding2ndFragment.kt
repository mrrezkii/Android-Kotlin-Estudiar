package com.esdgabut.estudiar.data.view.fragment.Onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.esdgabut.estudiar.databinding.FragmentOnboarding2ndBinding

class Onboarding2ndFragment : Fragment() {

    private lateinit var binding: FragmentOnboarding2ndBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboarding2ndBinding.inflate(inflater, container, false)
        return binding.root
    }

}