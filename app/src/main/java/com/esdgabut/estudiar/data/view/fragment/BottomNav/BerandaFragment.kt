package com.esdgabut.estudiar.data.view.fragment.BottomNav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.esdgabut.estudiar.databinding.FragmentBerandaBinding

class BerandaFragment : Fragment() {

    private lateinit var binding: FragmentBerandaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBerandaBinding.inflate(inflater, container, false)
        return binding.root
    }

}