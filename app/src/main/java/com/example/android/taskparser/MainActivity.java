package com.example.android.taskparser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TaskAdapter adapter;
    ArrayList<TaskItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        Intent intent = getIntent();

        String intent_string = intent.getStringExtra(Intent.EXTRA_TEXT);

        String[] list;

        if(intent_string != null){
            list = parse(intent_string);
        }
        else {
            list = new String[] {"one", "two", "three"};
        }

//        String[] arrayList = new String[] {"one", "two", "three"};

//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("one");
//        arrayList.add("two");
//        arrayList.add("three");

//        String line = "Овощи; Колбаса; \n Помидоры";
//        String[] res = parse(line);

        items = new ArrayList<>();

        for(int i = 0; i < list.length; i++){
            Log.v("After parse: ", list[i]);
            items.add(new TaskItem(list[i]));
        }

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
//        ListView listView = findViewById(R.id.list_view);
//        listView.setAdapter(adapter);

        adapter = new TaskAdapter(this, items);

        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }

    public String[] parse (String line){

        String[] result = line.split("\n");

        for(int i = 0; i < result.length; i++){
//            if(result[i].contains("\n")){
//                Log.v("in parse method:", result[i] + " contain \\n in position " + result[i].indexOf("\n"));
//                result[i] = result[i].substring(result[i].indexOf("\n"));
//            }
            result[i] = result[i].trim();
        }
        return result;
    }

    public void onClick(View view){
        String taskName = ((TextView) view).getText().toString();
        Log.v("onClick: taskName ", taskName);
        for(int i = 0; i < items.size(); i++){
            if(taskName.equals(items.get(i).getTaskName())) {
                Log.v("onClick: position ", String.valueOf(i));
                items.set(i, new TaskItem("removed"));
                Log.v("onClick: ", items.get(i).getTaskName());
            }
        }
        adapter.notifyDataSetChanged();
    }
}
