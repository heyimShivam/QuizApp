package com.example.quizapp

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener{

    private var mCurrentPosition:Int=1
    private var mQuestionList:ArrayList<Question>?=null
    private var mSelectedOptionPosition:Int=0
    private var mcorrectAnswer=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

       mQuestionList=Constants.getQuestions()
       setQuestion()
        val btnSubmit:Button=findViewById(R.id.submit)
        btnSubmit.setOnClickListener(this)

    }

    private fun setQuestion(){
        defaultOptionView()
        val submit:Button=findViewById(R.id.submit)
        if(mCurrentPosition==mQuestionList!!.size){
            submit.text="FINISh"
        }else{
            submit.text="SUBMIT"
        }

        val question=mQuestionList!!.get(mCurrentPosition-1)
        val progressBar: ProgressBar =findViewById(R.id.progressBar)
        val progress: TextView =findViewById(R.id.tv_progress)
        progressBar.progress=mCurrentPosition
        progress.text="$mCurrentPosition"+"/"+progressBar.max
        val tv_question: TextView =findViewById(R.id.tv_question)
        tv_question.text=question!!.question
        val tv_image: ImageView =findViewById(R.id.tv_image)
        tv_image.setImageResource(question.image)
        val tv_option_1: TextView =findViewById(R.id.tv_option_1)
        val tv_option_2: TextView =findViewById(R.id.tv_option_2)
        val tv_option_3: TextView =findViewById(R.id.tv_option_3)
        val tv_option_4: TextView =findViewById(R.id.tv_option_4)

        tv_option_1.text=question.option1
        tv_option_2.text=question.option2
        tv_option_3.text=question.option3
        tv_option_4.text=question.option4
        tv_option_1.setOnClickListener(this)
        tv_option_2.setOnClickListener(this)
        tv_option_3.setOnClickListener(this)
        tv_option_4.setOnClickListener(this)
    }
    private fun defaultOptionView(){
        val tv_option_10: TextView =findViewById(R.id.tv_option_1)
        val tv_option_20: TextView =findViewById(R.id.tv_option_2)
        val tv_option_30: TextView =findViewById(R.id.tv_option_3)
        val tv_option_40: TextView =findViewById(R.id.tv_option_4)
        val options=ArrayList<TextView>()
        options.add(0,tv_option_10)
        options.add(1,tv_option_20)
        options.add(2,tv_option_30)
        options.add(3,tv_option_40)
        for(option in options){
         option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(
                    this,R.drawable.default_option_bg
            )
        }
    }

    override fun onClick(v: View?) {
        val tv_option_1: TextView =findViewById(R.id.tv_option_1)
        val tv_option_2: TextView =findViewById(R.id.tv_option_2)
        val tv_option_3: TextView =findViewById(R.id.tv_option_3)
        val tv_option_4: TextView =findViewById(R.id.tv_option_4)


when(v?.id){

    R.id.tv_option_1->{
        selectedOptionView(tv_option_1,1)
    }
    R.id.tv_option_2->{
        selectedOptionView(tv_option_2,2)
    }

    R.id.tv_option_3->{
        selectedOptionView(tv_option_3,3)
    }
    R.id.tv_option_4->{
        selectedOptionView(tv_option_4,4)
    }
    R.id.submit->{
       if(mSelectedOptionPosition==0){
           mCurrentPosition++
           when{
               mCurrentPosition<=mQuestionList!!.size->{
                   setQuestion()}
                  else->{
                       Toast.makeText(this,"You Have succesfully completed quiz",Toast.LENGTH_SHORT).show()
                   }
               }
           }else{
               val question =mQuestionList?.get(mCurrentPosition-1)
           if(question!!.correctAnswer!=mSelectedOptionPosition){
               answerView(mSelectedOptionPosition,R.drawable.wrong_option_bg)
           }else{
               mcorrectAnswer++           }
           answerView(question.correctAnswer,R.drawable.correct_option_bg)
           val btnSubmit:Button=findViewById(R.id.submit)
           if(mCurrentPosition==mQuestionList!!.size){

               btnSubmit.text="FINISH"
           }else{
               btnSubmit.text="GO TO NEXT QUESTION"
           }
           mSelectedOptionPosition=0
           }
       }
    }
}

    private fun answerView(answer:Int,drawableView:Int){
        val tv_option_1: TextView =findViewById(R.id.tv_option_1)
        val tv_option_2: TextView =findViewById(R.id.tv_option_2)
        val tv_option_3: TextView =findViewById(R.id.tv_option_3)
        val tv_option_4: TextView =findViewById(R.id.tv_option_4)
        when(answer){
            1 -> {
                tv_option_1.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                tv_option_2.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                tv_option_3.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                tv_option_4.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }
    private  fun selectedOptionView(tv: TextView,SelectedOptionNum:Int){
        defaultOptionView()
        mSelectedOptionPosition=SelectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(
                this,R.drawable.default_option_bg_select)

    }
}