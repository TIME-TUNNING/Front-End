package com.kmj.timetuning_hackathon

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.kmj.timetuning_hackathon.databinding.ActivityInviteDialogBinding
import com.kmj.timetuning_hackathon.databinding.PlanInfoDialogBinding

class InviteDialog(
    val inputUser:String
) : DialogFragment() {
    lateinit var binding:ActivityInviteDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= ActivityInviteDialogBinding.inflate(inflater,container,false)

        // dialog 클릭 시 레이아웃 배경을 투명하게 해줌
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        // 입력받은 user 이름 화면에 띄우기
        binding.inviteDialogIdTv.text = inputUser

        // 취소 버튼 클릭
        binding.inviteDialogCancelBtn.setOnClickListener {
            dismiss()
        }

        // x 버튼 클릭
        binding.inviteDialogCancelIv.setOnClickListener {
            dismiss()
        }
        // 초대 버튼 클릭
        binding.inviteDialogInviteBtn.setOnClickListener {

        }

        return binding.root
    }
}