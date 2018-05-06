package com.example.android.taskparser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TaskAdapter adapter;
    ArrayList<TaskItem> toBuyList, alredyBoughtList;
    String tag;

    String[] list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        tag = "StartOnCreate";
        if(toBuyList != null) {
            tag = "toBuyList ";
            Log.v(tag, toBuyList.toString());
        }

        Intent intent = getIntent();

        tag = "intent ";
        Log.v(tag, intent.toString());

        String intent_string = intent.getStringExtra(Intent.EXTRA_TEXT);

        if(intent_string != null){
            list = parse(intent_string);
        }
        else {
            list = new String[] {"one", "two", "three"};
        }

        tag = "list ";
        Log.v(tag, list.toString());

        if(toBuyList != null) {
            tag = "toBuyList ";
            Log.v(tag, toBuyList.toString());
        }

        if(toBuyList == null && alredyBoughtList == null) {
            toBuyList = new ArrayList<>();
            alredyBoughtList = new ArrayList<>();

            for (int i = 0; i < list.length; i++) {
                Log.v("After parse: ", list[i]);
                toBuyList.add(new TaskItem(list[i]));
            }
        }

        adapter = new TaskAdapter(this, toBuyList);

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }

    public String[] parse (String line){

        String[] result = line.split("\n");

        for(int i = 0; i < result.length; i++){
            result[i] = result[i].trim();
        }
        return result;
    }

    public void onClick(View view){
        String taskName = ((TextView) view).getText().toString();
        Log.v("onClick: taskName ", taskName);
        for(int i = 0; i < toBuyList.size(); i++){
            if(taskName.equals(toBuyList.get(i).getTaskName())) {
                Log.v("onClick: position ", String.valueOf(i));
                alredyBoughtList.add(toBuyList.get(i));
                toBuyList.remove(i);
            }
        }
        adapter.notifyDataSetChanged();
    }
}
