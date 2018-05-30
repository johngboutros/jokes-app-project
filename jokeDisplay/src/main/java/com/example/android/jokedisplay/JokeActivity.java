package com.example.android.jokedisplay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class JokeActivity extends AppCompatActivity {

    public final static String ARG_JOKE = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
    }
}
