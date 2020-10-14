package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.learnandroid.databases.DatabaseAccess;
import com.example.learnandroid.model.Question;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn;
    DatabaseAccess databaseAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
                startActivity(intent);
                String pathdb = getDatabasePath("nihongo.db").getPath();
                Toast.makeText(MainActivity.this, pathdb, Toast.LENGTH_SHORT).show();
//                Toast.makeText(MainActivity.this, "Click", Toast.LENGTH_SHORT).show();
//
//                if(questions.size() > 0){
//                    for (int i = 0; i < questions.size(); i++){
//                        Toast.makeText(MainActivity.this, "" + questions.get(i).getQuestion(), Toast.LENGTH_SHORT).show();
//                    }
//                }else{
//                    Toast.makeText(MainActivity.this, "Empty", Toast.LENGTH_SHORT).show();
//                }
//                String pathdb = getDatabasePath("nihongo.db").getPath();
//                Toast.makeText(MainActivity.this, pathdb, Toast.LENGTH_SHORT).show();
            }
        });
    }
}