package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    // dummy object
    // everytime i come to this creen it always creates a new dummy object
    // theres a print statement in dummy constructor and its always called
    //when intent loads this class..hmmmmmmmmmmmm
    private Dummy hello = new Dummy("Fuck me");

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
        // notes setText only accepts strings..if like an int, it crashes :(
        TextView textView =  findViewById(R.id.textView);
        textView.setText(message);
        //textView.setText(hello.getLuckyPhrase()); // setText method to set the text of it

    } // oncreate method


    //==============================================================================================================
    // method for the nextscreen button which creates
    // a train from main -> here -> nextScreen for fun to see if it works
    public void goToNextScreen (View view) {

        Intent intent = new Intent(this, Train.class);
        startActivity(intent);
    }

}
