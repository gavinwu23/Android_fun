// red < > means related files
// this is the main activity, which is the entry point for my app.
// ctr + s +alt to open settings


package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

// pressing alt+enter on an error displays some popups and then you can just automatically do some imports
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {


    // our key as for the intent
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // set the layout from the xml file


    }

    /** Called when the user taps the Send button */
    // we go into the .xml file, and then click the button
    // then go to onClick, drop down menu and then select this method.
    // im guessing it will hook up the event automactically?
    // print statements works.

    // notes:
    // this method is public access
    // void return type
    // and View object is the only paramater

    // these are required for the system to recognize the method as compatible
    // with the android:onclick

    // only View as paramater, otherwise it will crash

    // so intent is object that provides runtime binding between seperate components like 2 activities
    public void sendMessage(View view) {

        // takes 2 paramaters ( constructor ). the Context and a class
        // the class is the class that you basically want to load in
        // DisplayMessageActivity is a java class/file we made that we want to load in
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        // inside our xml, we have a plain text aka called editText,
        // and we want to hook that up using EditText object.
        // type case it for some reason? and call findViewById (R.id.editText) -> where .editText is our id of our plain text
        EditText editText = (EditText) findViewById(R.id.editText);

        // get the text from the textbox, cast it toString makes sense
        String message = editText.getText().toString();

        // putExtra, addes the value from we got from the text box. Intent can carry data as key-value pairs called extras
        // the key in this case is EXTRA_MESSAGE and value is the message from the text box.
        // somehow good practice to define the key as app package name
        intent.putExtra(EXTRA_MESSAGE, message);

        // starts the activity defined by the intent, which is Display
        startActivity(intent);
    }

}

