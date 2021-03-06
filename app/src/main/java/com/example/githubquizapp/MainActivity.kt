package com.example.githubquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN

        startQuiz.setOnClickListener { view->
            if((playerInput.text.toString()).isEmpty()){
                Toast.makeText(this,"Please Enter your name",Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this , DisplayQuestions::class.java)
                intent.putExtra(Information.user_name,playerInput.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}