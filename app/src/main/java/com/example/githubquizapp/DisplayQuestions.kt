package com.example.githubquizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_display_questions.*

class DisplayQuestions : AppCompatActivity() {

    var gCurrentQuestionNumber : Int = 1
    var gSelectedOptionNumber : Int = 0
    var gCorrectQuestions : Int =0
    var gQuestionCollection : ArrayList<InfoType> ? = null

    var userNameIntent : String ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_questions)

        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN

        userNameIntent=intent.getStringExtra(Information.user_name)

        gQuestionCollection = Information.questions()
        showQuestions()

        op_1.setOnClickListener { view->
            showSelectedOption(op_1,1)
        }
        op_2.setOnClickListener { view->
            showSelectedOption(op_2,2)
        }
        op_3.setOnClickListener { view->
            showSelectedOption(op_3,3)
        }
        op_4.setOnClickListener { view->
            showSelectedOption(op_4,4)
        }
        btn_submit.setOnClickListener { view->
            submitSelected(view)
        }
    }

    private fun showQuestions(){

        defaultOptionView()

        var currentQuestion = gQuestionCollection!![gCurrentQuestionNumber-1]


        questionDisplay.text= (currentQuestion.question)
        imageDisplay.setImageResource(currentQuestion.image)
        progressBar.progress=gCurrentQuestionNumber
        progressText.text="$gCurrentQuestionNumber/10"
        op_1.text=currentQuestion.optionOne
        op_2.text=currentQuestion.optionTwo
        op_3.text=currentQuestion.optionThree
        op_4.text=currentQuestion.optionFour

        if(gCurrentQuestionNumber==gQuestionCollection!!.size){
            btn_submit.text="FINISH"
        }
        else{
            btn_submit.text="SUBMIT"
        }

    }
    private fun showSelectedOption(tv:TextView,selectedOpt :Int){

        defaultOptionView()

        gSelectedOptionNumber=selectedOpt
        tv.setTextColor(Color.parseColor("#363943"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this,R.drawable.selected_option_view)
    }
    private fun defaultOptionView(){
        var textViewList = ArrayList<TextView>()
        textViewList.add(op_1)
        textViewList.add(op_2)
        textViewList.add(op_3)
        textViewList.add(op_4)

        for(i in textViewList){
            i.setTextColor((Color.parseColor("#7a8089")))
            i.setTypeface(i.typeface,Typeface.NORMAL)
            i.background=ContextCompat.getDrawable(this , R.drawable.default_option_view)
        }
    }
    private fun submitSelected(view:View){


        if(gSelectedOptionNumber==0){
            gCurrentQuestionNumber++

            if(gCurrentQuestionNumber<=gQuestionCollection!!.size){
                showQuestions()
            }
            else{
                val intent= Intent(this,Result::class.java)
                intent.putExtra(Information.user_name,userNameIntent)
                intent.putExtra(Information.correct_questions,gCorrectQuestions)
                intent.putExtra(Information.total_questions,gQuestionCollection!!.size)
                startActivity(intent)
                finish()
            }

        }
        else{

            val question =gQuestionCollection!![gCurrentQuestionNumber-1]
            if(gSelectedOptionNumber!=question.answer){
                highlightOption(gSelectedOptionNumber,R.drawable.wrong)
            }
            else{
                gCorrectQuestions++

            }

            highlightOption(question.answer,R.drawable.right)

            if(gCurrentQuestionNumber==gQuestionCollection!!.size){
                btn_submit.text="FINISH"
            }
            else{
                btn_submit.text="GO TO NEXT QUESTION"
            }
            gSelectedOptionNumber=0
        }

    }
    private fun highlightOption(selected:Int , dw: Int){
        if(selected==1){
            op_1.background=ContextCompat.getDrawable(this,dw)
        }
        else if(selected==2){
            op_2.background=ContextCompat.getDrawable(this,dw)
        }
        else if(selected==3){
            op_3.background=ContextCompat.getDrawable(this,dw)
        }
        else if(selected==4){
            op_4.background=ContextCompat.getDrawable(this,dw)
        }
    }
}