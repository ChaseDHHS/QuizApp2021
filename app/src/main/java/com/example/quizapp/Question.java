package com.example.quizapp;

public class Question {

    String questionText;
    boolean correctAnswer;

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public boolean isCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Question(String questionText, boolean correctAnswer) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;


    }
}
