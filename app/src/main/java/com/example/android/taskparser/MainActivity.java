package com.example.android.taskparser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText mEditText;
    String line;
    Intent sendIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String intentText = intent.getStringExtra(Intent.EXTRA_TEXT);

        sendIntent = new Intent(this,  ToBuyListActivity.class);

        if(intentText != null) {
            line = intentText;
            sendIntent.putExtra(Intent.EXTRA_TEXT, line);
            startActivity(sendIntent);
        }
    }

    public void onClickMain(View view){
        mEditText = (EditText) findViewById(R.id.edit_text);
        line = mEditText.getText().toString();
        sendIntent.putExtra(Intent.EXTRA_TEXT, line);
        startActivity(sendIntent);
    }
}
