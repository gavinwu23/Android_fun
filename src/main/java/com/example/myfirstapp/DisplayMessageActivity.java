package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    // im guessing almost every activity.java has this thing
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // we know an intent started this activity so lets grab that

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();

        // EXTRA_MESSAGE is a public STATIC variable so can directly access it
        // remember that it's key-value pair, extra_message is the key that will map us to the value
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text

        // findviewbyid our textbox id is textView
        TextView textView =  findViewById(R.id.textView);
        textView.setText(message); // setText method to set the text of it
    }
}
