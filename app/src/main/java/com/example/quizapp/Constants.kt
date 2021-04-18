package com.example.quizapp

object Constants {

     fun getQuestions():ArrayList<Question> {
         val questionlist = ArrayList<Question>()

         val Q1 = Question(1, "What Country dose this flag?", R.drawable.download, "america", "India", "USA", "Sri Lanka", 2)
         val Q2 = Question(2, "This Country flaf belongs to?", R.drawable.download1, "Egypt", "India", "USA", "Sri Lanka", 1)
         val Q3 = Question(3, "What Country dose this flag?", R.drawable.download3, "Egypt", "India", "France", "Sri Lanka", 3)

         questionlist.add(Q1)
         questionlist.add(Q2)
         questionlist.add(Q3)
         val Q4 = Question(4, "What Country dose this flag?", R.drawable.download, "Egypt", "India", "France", "Sri Lanka", 3)
         questionlist.add(Q4)
         return questionlist
     }
}