package com.example.sharedpre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.EditText
import com.example.sharedpre.utils.ContextUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val saveEmail = ContextUtil.getEmailSave(this).toString()
        if (saveEmail != null){
            edtEmail.setText(saveEmail)
        }

        //companion object에 들어가있는 변수는 바로 가져다 쓸 수 있다
        //ContextUtil.test
        checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            // 지금 체크된 상황을 그대로 ContextUtil을 이용해 자동로그인 여부로 저장
            ContextUtil.setAutoLogin(this,isChecked)
        }

        //화면이 만들어지면 저장된 자동로그인 여부 값을 반영
        checkBox.isChecked = ContextUtil.getAutoLogin(this)


        val email = edtEmail.editableText
        button.setOnClickListener {
            Log.d("TAG", "${email}")
                ContextUtil.setEmailSave(this,email)
        }
    }
}