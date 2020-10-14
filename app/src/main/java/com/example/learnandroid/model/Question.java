package com.example.learnandroid.model;

/**
 * Created by Bich Hoang on 10/5/2020.
 */
public class Question {
    int id_question;
    int id_exam;
    int id_skill;
    String question;
    String picture;

    public Question(int id_question, int id_exam, int id_skill, String question, String picture) {
        this.id_question = id_question;
        this.id_exam = id_exam;
        this.id_skill = id_skill;
        this.question = question;
        this.picture = picture;
    }

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public int getId_exam() {
        return id_exam;
    }

    public void setId_exam(int id_exam) {
        this.id_exam = id_exam;
    }

    public int getId_skill() {
        return id_skill;
    }

    public void setId_skill(int id_skill) {
        this.id_skill = id_skill;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
