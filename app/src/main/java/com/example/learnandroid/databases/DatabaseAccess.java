package com.example.learnandroid.databases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.learnandroid.model.Answer;
import com.example.learnandroid.model.Question;
import com.example.learnandroid.model.Questions;

import java.util.ArrayList;

/**
 * Created by Bich Hoang on 10/5/2020.
 */
public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DBconfig(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    public ArrayList<Question> getQuestions(){
        ArrayList<Question> questions = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM Questions",null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            int id_question = cursor.getInt(cursor.getColumnIndex("id_question"));
            String question = cursor.getString(cursor.getColumnIndex("question"));
            int id_skill = cursor.getInt(cursor.getColumnIndex("id_skill"));
            int id_exam = cursor.getInt(cursor.getColumnIndex("id_exam"));
            String picture = cursor.getString(cursor.getColumnIndex("picture"));

            questions.add(new Question(id_question, id_exam, id_skill, question, picture));

            cursor.moveToNext();
        }
        cursor.close();
        return  questions;
    }

    public ArrayList<Answer> getAnswersByQuestion(int idQuestion){
        ArrayList<Answer> answers = new ArrayList<>();
        String sql = "SELECT * FROM Answers WHERE id_question = " + idQuestion;
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            int id_answer = cursor.getInt(cursor.getColumnIndex("id_answer"));
            int id_question = cursor.getInt(cursor.getColumnIndex("id_question"));
            int is_correct = cursor.getInt(cursor.getColumnIndex("is_correct"));
            String answer = cursor.getString(cursor.getColumnIndex("answer"));

            answers.add(new Answer(id_answer, id_question, is_correct, answer));

            cursor.moveToNext();
        }
        cursor.close();
        return  answers;
    }
}
