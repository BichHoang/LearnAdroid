package com.example.learnandroid.model;

/**
 * Created by Bich Hoang on 10/5/2020.
 */
public class Answer {
    int id_answer;
    int id_qusetion;
    int is_correct;
    String answer;

    public int getId_answer() {
        return id_answer;
    }

    public void setId_answer(int id_answer) {
        this.id_answer = id_answer;
    }

    public int getId_qusetion() {
        return id_qusetion;
    }

    public void setId_qusetion(int id_qusetion) {
        this.id_qusetion = id_qusetion;
    }

    public int getIs_correct() {
        return is_correct;
    }

    public void setIs_correct(int is_correct) {
        this.is_correct = is_correct;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Answer(int id_answer, int id_qusetion, int is_correct, String answer) {
        this.id_answer = id_answer;
        this.id_qusetion = id_qusetion;
        this.is_correct = is_correct;
        this.answer = answer;
    }
}
