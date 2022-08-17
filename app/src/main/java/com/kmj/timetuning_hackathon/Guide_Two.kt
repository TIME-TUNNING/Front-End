package com.kmj.timetuning_hackathon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kmj.timetuning_hackathon.databinding.FragmentGuideTwoBinding

// ***** 가이드 2번째 화면입니다. *****
class Guide_Two : Fragment() {
    lateinit var binding: FragmentGuideTwoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGuideTwoBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

}