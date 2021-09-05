package com.esdgabut.estudiar.data.view.fragment.bottomnav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.esdgabut.estudiar.databinding.FragmentObrolanBinding

class ObrolanFragment : Fragment() {

    private lateinit var binding: FragmentObrolanBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentObrolanBinding.inflate(inflater, container, false)
        return binding.root
    }

}