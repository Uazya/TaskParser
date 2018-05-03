package com.example.android.taskparser;

/**
 * Created by daniilzilin on 13.04.2018.
 */

public class TaskItem {
    private String mTaskName;
    private boolean check = false;

    public TaskItem(String taskName){
        mTaskName = taskName;
    }

    public String getTaskName(){
        return mTaskName;
    }

    public void setCheck(){
        if(check == false){
            check = true;
        } else check = false;
    }

    public boolean isChecked(){
        return check;
    }
}
