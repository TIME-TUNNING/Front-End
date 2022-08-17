package com.kmj.timetuning_hackathon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.kmj.timetuning_hackathon.databinding.ActivityInputTimeBinding

// 7. 가능한 시간 입력 화면
class InputTime : AppCompatActivity() {
    lateinit var binding:ActivityInputTimeBinding
    private var gson: Gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityInputTimeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val newScheduleObj = intent.getStringExtra("newSchedule")
        val newSchedule = gson.fromJson(newScheduleObj, NewSchedule::class.java)

        setInit(newSchedule)
    }

    private fun setInit(newSchedule:NewSchedule){

        // 선택된 날짜 recyclerview
        val selectedDatesRVAdapter = InputTimeRVAdapter(newSchedule.selectedDates)
        binding.createSelectedDateRv.adapter = selectedDatesRVAdapter

        val selectedDatesLayoutManager = LinearLayoutManager(this)
        selectedDatesLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.createSelectedDateRv.layoutManager = selectedDatesLayoutManager
    }
}