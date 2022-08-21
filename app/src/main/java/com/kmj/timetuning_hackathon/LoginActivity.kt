package com.kmj.timetuning_hackathon

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kmj.timetuning_hackathon.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        // 스플래쉬 화면 설정
        setTheme(R.style.Theme_TimeTuning_hackathon)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginSignupBtn.setOnClickListener{
            startActivity(Intent(this,SignUpActivity::class.java))
        }

        binding.loginSignInBtn.setOnClickListener {
            login()
        }
    }

    //로그인함수
    private fun login(){
        if(binding.loginIdEt.text.toString().isEmpty()){
            Toast.makeText(this,"아이디를 입력해주세요!",Toast.LENGTH_SHORT).show()
            return
        }
        if (binding.loginPasswordEt.text.toString().isEmpty()){
            Toast.makeText(this,"비밀번호를 입력해주세요!",Toast.LENGTH_SHORT).show()
            return
        }

        val id: String = binding.loginIdEt.text.toString()
        val password : String = binding.loginPasswordEt.text.toString()

        //  디비연결
        val newDB = NewScheduleDatabase.getInstance(this)!!
        // 디비에 일치하는 함수가 있는지
        val user = newDB.UserDao().getUser(id,password)

        user?.let {
            Log.d("LOGIN_ACT/GET_USER","userId : ${user.number}, $user")
            saveJwt(user.number)

            Toast.makeText(this,"반가워요!",Toast.LENGTH_SHORT).show()
            startMainActivity()
        return
        }
        Toast.makeText(this,"회원 정보가 존재하지 않습니다.",Toast.LENGTH_SHORT).show()

    }

    private  fun saveJwt(jwt:Int){
        val spf = getSharedPreferences("auth", MODE_PRIVATE)
        val editor = spf.edit()

        editor.putInt("jwt",jwt)
        editor.apply()
    }

    //로그인시 메인 화면으로
    private fun startMainActivity(){
        //val intent = Intent(this, MainActivity::class.java )
        val intent = Intent(this, GuideActivty::class.java )
        startActivity(intent)
    }


}