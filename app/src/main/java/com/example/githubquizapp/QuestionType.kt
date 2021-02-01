package com.example.githubquizapp

object Information{

     var user_name : String= "name"
     var correct_questions : String = "correct_question"
     var total_questions : String = "total_question"

    fun questions() : ArrayList<InfoType>{

        var listOfQuestions = ArrayList<InfoType>()

        var questionOne = InfoType(1,"Which country does this flag belong to",R.drawable.ic_flag_of_argentina,
        "America","Argentina","Australia","Armenia",2)

        listOfQuestions.add(questionOne)

        var questionTwo = InfoType(2,"Which country does this flag belong to",R.drawable.ic_flag_of_australia,
            "Bhutan","Sri Lanka","Australia","Pakistan",3)

        listOfQuestions.add(questionTwo)

        var questionThree = InfoType(3,"Which country does this flag belong to",R.drawable.ic_flag_of_belgium,
            "Nepal","Kuwait","Nigeria","Belgium",4)

        listOfQuestions.add(questionThree)

        var questionFour = InfoType(4,"Which country does this flag belong to",R.drawable.ic_flag_of_brazil,
            "America","Brazil","New Zealand","England",2)

        listOfQuestions.add(questionFour)

        var questionFive = InfoType(5,"Which country does this flag belong to",R.drawable.ic_flag_of_denmark,
            "Denmark","Argentina","Mexico","India",1)

        listOfQuestions.add(questionFive)

        var questionSix = InfoType(6,"Which country does this flag belong to",R.drawable.ic_flag_of_fiji,
            "Uruguay","Fiji","Canada","Morocco",2)

        listOfQuestions.add(questionSix)

        var questionSeven = InfoType(7,"Which country does this flag belong to",R.drawable.ic_flag_of_germany,
            "Afghanistan","West Indies","Salvador","Germany",4)

        listOfQuestions.add(questionSeven)

        var questionEight = InfoType(8,"Which country does this flag belong to",R.drawable.ic_flag_of_india,
            "England","Peru","India","Malaysia",3)

        listOfQuestions.add(questionEight)

        var questionNine = InfoType(9,"Which country does this flag belong to",R.drawable.ic_flag_of_kuwait,
            "America","Kuwait","Bolivia","Mexico",2)

        listOfQuestions.add(questionNine)

        var questionTen = InfoType(10,"Which country does this flag belong to",R.drawable.ic_flag_of_new_zealand,
            "Egypt","Romania","Russia","New Zealand",4)

        listOfQuestions.add(questionTen)

        return listOfQuestions
    }
}