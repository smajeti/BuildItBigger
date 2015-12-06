package com.sai.androidjokeslibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public static final String JOKE_TXT_INTENT_ID = "JOKE_TXT_INTENT_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.sai.androidjokeslibrary.R.layout.activity_jokes_lib_main);

        Intent intent = getIntent();
        if (intent != null) {
            String jokeStr = intent.hasExtra(JOKE_TXT_INTENT_ID) ? intent.getStringExtra(JOKE_TXT_INTENT_ID) : "";
            TextView txtView = (TextView) findViewById(R.id.jokeTxtId);
            txtView.setText(jokeStr);
        }
    }
}
