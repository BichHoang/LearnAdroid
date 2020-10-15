package com.example.learnandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnandroid.R;
import com.example.learnandroid.databases.DatabaseAccess;
import com.example.learnandroid.model.Answer;
import com.example.learnandroid.model.Question;

import java.util.ArrayList;

/**
 * Created by Bich Hoang on 10/2/2020.
 */
public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {
    private ArrayList<Question> questions;
    private DatabaseAccess databaseAccess;
    private Context context;
    private int checked_positon = -1;

    public QuestionAdapter(ArrayList<Question> questions) {
        this.questions = questions;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView question;
        public RadioButton answer1;
        public RadioButton answer2;
        public RadioButton answer3;
        public RadioButton answer4;
        public RadioGroup radioGroup;
        public RecyclerView recyclerView;
        public ViewHolder(View v) {
            super(v);
            question = v.findViewById(R.id.txt_question);
            answer1 = v.findViewById(R.id.radio_answer1);
            answer2 = v.findViewById(R.id.radio_answer2);
            answer3 = v.findViewById(R.id.radio_answer3);
            answer4 = v.findViewById(R.id.radio_answer4);
            radioGroup = v.findViewById(R.id.radio_group);
            recyclerView = v.findViewById(R.id.recycleView);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public QuestionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View view = inflater.inflate(R.layout.recycle_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(view);
        context = parent.getContext();
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        databaseAccess = DatabaseAccess.getInstance(context);
        databaseAccess.open();
        ArrayList<Answer> answers = databaseAccess.getAnswersByQuestion(questions.get(position).getId_question());
        databaseAccess.close();
        String question_number = "Câu " + (position + 1) + ": ";
        holder.question.setText(question_number + questions.get(position).getQuestion());
        holder.answer1.setText(answers.get(0).getAnswer());
        holder.answer2.setText(answers.get(1).getAnswer());
        holder.answer3.setText(answers.get(2).getAnswer());
        holder.answer4.setText(answers.get(3).getAnswer());
//        holder.setIsRecyclable(false);
        holder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Toast.makeText(group.getContext(), "Click: " + checkedId, Toast.LENGTH_SHORT).show();
//                holder.recyclerView.smoothScrollToPosition(position + 1);
                if(checked_positon == position){
                    holder.radioGroup.clearCheck();
                }
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return questions.size();
    }
}
