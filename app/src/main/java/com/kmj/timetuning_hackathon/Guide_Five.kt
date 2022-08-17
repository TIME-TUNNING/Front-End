package com.kmj.timetuning_hackathon

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kmj.timetuning_hackathon.databinding.FragmentGuideFiveBinding

// ***** 가이드 5번째 화면입니다. *****
class Guide_Five : Fragment() {
    lateinit var binding: FragmentGuideFiveBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGuideFiveBinding.inflate(inflater,container,false)

        binding.guideFiveStartBtn.setOnClickListener {
            val intent= Intent(context,MainActivity::class.java)
            startActivity(intent)
        }


        // Inflate the layout for this fragment
        return binding.root
    }

}