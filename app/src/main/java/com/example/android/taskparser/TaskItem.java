package com.example.android.taskparser;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by daniilzilin on 13.04.2018.
 */

public class TaskItem implements Parcelable {
    private String mTaskName;
    private boolean check = false;

    public TaskItem(String taskName){
        mTaskName = taskName;
    }

    private TaskItem(Parcel in){
        mTaskName = in.readString();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public static final Parcelable.Creator<TaskItem> CREATOR = new Parcelable.Creator<TaskItem>(){
        public TaskItem createFromParcel (Parcel in){
            return new TaskItem(in);
        }

        public TaskItem[] newArray(int size){
            return new TaskItem[size];
        }
    };
}
