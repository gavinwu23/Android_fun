// red < > means related files
// this is the main activity, which is the entry point for my app.
// ctr + s +alt to open settings


package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

// pressing alt+enter on an error displays some popups and then you can just automatically do some imports
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

     private Dummy d = new Dummy("my name gwu");
     private boolean mature = false;

    // our key as for the intent
    // good practice to make a constant to pass it to putExtra.
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // set the layout from the xml file

        // set up the switch
        setSwitch();

        // set up the drop down list menu aka the spinner
        setSpinner();

        // second way to add a listener to the button
//
        // grab the button by its id and then do this
//        Button b = (Button) findViewById(R.id.button);
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // call method here
//            }
//        });


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
    public void buttonSend(View view) {

        // inside our xml, we have a plain text aka called editText,
        // and we want to hook that up using EditText object.
        // type case it for some reason? and call findViewById (R.id.editText) -> where .editText is our id of our plain text
        EditText editText = (EditText) findViewById(R.id.editText);

        // get the text from the textbox, cast it toString makes sense
        String message = editText.getText().toString();

        // check if the string we got back is empty, if it is then make a toast and show the popup
        if (message.isEmpty()) {
            // lets make a Toast (popup)
            Toast errorCheck = Toast.makeText(this, "Please enter something", Toast.LENGTH_SHORT);
            errorCheck.show();
            return;
        }

        // takes 2 paramaters ( constructor ). the Context and a class
        // the class is the class that you basically want to load in
        // DisplayMessageActivity is a java class/file we made that we want to load in
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        // putExtra, addes the value from we got from the text box. Intent can carry data as key-value pairs called extras
        // the key in this case is EXTRA_MESSAGE and value is the message from the text box.
        // somehow good practice to define the key as app package name
        intent.putExtra(EXTRA_MESSAGE, message);

        // starts the activity defined by the intent, which is Display
        startActivity(intent);
    }

    // method called when we click on the view image button which will direct us to a new screen showing a picture
    public void viewImageButton (View view) {

        // user wants an adult image :)
        if (this.mature) {
            Intent intent = new Intent(this, Adult.class);
            startActivity(intent);
            return;
        }

        // regular non 18 image
        Intent intent = new Intent(this, Image.class);
        startActivity(intent);
    }

    //=======================================================================================================================
    // method to set up the event handler for the switch
    // in this case the 18+ switch
    private void setSwitch ( ) {

        Switch s = (Switch) findViewById(R.id.switch1);
        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) { // we check isChecked T/F to do w.e we want
                if (isChecked) {
                    mature = true; // used when we click the image button to see if we want mature image or not
                }
                else {
                    mature = false;
                }
            }
        });
    }

    //===============================================================================================================================
    // set up the spinner (drop down menu)
    private void setSpinner ( ) {

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);

        // array adapter 3 paramaters, first is context, second is the array from strings.xml, and third is a layout(we use default layout)
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.weather,android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        mySpinner.setAdapter(adapter);

        // apply the listeners to the spinner
        mySpinner.setOnItemSelectedListener(this);
    }


    // listener for the spinner when we click item slected
    // to access element do parent.getItematposition(position)
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String msg = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), msg, Toast.LENGTH_SHORT).show();
        //System.out.println("hello");
    }

    // required from the interface
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

