package com.kmj.timetuning_hackathon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.kmj.timetuning_hackathon.databinding.ActivityGuideActivtyBinding

// ***** 가이드 화면입니다. *****
class GuideActivty : AppCompatActivity() {
    lateinit var binding:ActivityGuideActivtyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityGuideActivtyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //ViewPager 에 Adapter 적용
        val adapter=GuidePagerAdapter(this)
        binding.guideContentVp.adapter = adapter

    }

    class GuidePagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity){
        val fragments: List<Fragment>
        init {
            fragments= listOf(Guide_One(),Guide_Two(),Guide_Three(),Guide_Four(),Guide_Five())
            Log.d("??","fragment")
        }
        override fun getItemCount(): Int = fragments.size

        override fun createFragment(position: Int): Fragment = fragments[position]
    }
}