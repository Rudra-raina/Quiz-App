package com.example.githubquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {

    var userName : String? = null
    var correctQ : Int = 0
    var totalQ : Int =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN

        userName=intent.getStringExtra(Information.user_name)
        correctQ=intent.getIntExtra(Information.correct_questions,0)
        totalQ=intent.getIntExtra(Information.total_questions,0)

        tv_name.text=userName.toString()
        tv_score.text="Your score is $correctQ out of ${totalQ}"

        btn_finish.setOnClickListener { view->
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}