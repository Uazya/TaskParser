package com.example.android.taskparser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by daniilzilin on 18.04.2018.
 */

public class TaskAdapter extends ArrayAdapter<TaskItem> {

    Context context;


    public TaskAdapter (Context context, ArrayList<TaskItem> items){
        super(context, 0, items);
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        final TaskItem item = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, null);
        }

        ((TextView) convertView.findViewById(R.id.list_item_text)).setText(item.getTaskName());

//        LinearLayout layout = (LinearLayout)convertView.findViewById(R.id.list_view);

        return convertView;
    }
}
