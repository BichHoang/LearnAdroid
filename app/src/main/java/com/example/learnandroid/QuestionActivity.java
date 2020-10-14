package com.example.learnandroid;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnandroid.adapter.QuestionAdapter;
import com.example.learnandroid.databases.DatabaseAccess;
import com.example.learnandroid.model.Question;

import java.util.ArrayList;

/**
 * Created by Bich Hoang on 10/5/2020.
 */
public class QuestionActivity extends AppCompatActivity {
    ArrayList<Question> questions;
    DatabaseAccess databaseAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // ...
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_questions);
        initQuestionView();

    }

    public void initQuestionView(){
        // Lookup the recyclerview in activity layout
        RecyclerView recyclerView = findViewById(R.id.recycleView);

        // Initialize contacts
        databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        questions = databaseAccess.getQuestions();
        databaseAccess.close();
        // Create adapter passing in the sample user data
        QuestionAdapter adapter = new QuestionAdapter(questions);
        // Attach the adapter to the recyclerview to populate items
        recyclerView.setAdapter(adapter);
        // Set layout manager to position the items
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        // That's all!
    }
}
