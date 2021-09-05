package com.esdgabut.estudiar.data.view.fragment.Onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.esdgabut.estudiar.databinding.FragmentOnboarding3rdBinding

class Onboarding3rdFragment : Fragment() {

    private lateinit var binding: FragmentOnboarding3rdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboarding3rdBinding.inflate(inflater, container, false)
        return binding.root
    }

}