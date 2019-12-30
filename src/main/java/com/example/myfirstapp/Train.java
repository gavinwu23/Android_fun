package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class Train extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);
    }


    // we hooked up two buttons to this method
    // to differentiate between buttons we called- view == findViewByID (r.iddsaf) thats pretty cool
    //inside this activity xml we have a fragment space which we load fragments into here
    public void changeFramgment (View view ) {
        // create instance of fragment object
        // our fragment classes we made extends Fragment so use polymorphism
        Fragment fragment;

        if (view == findViewById(R.id.button4)) {
            fragment = new FragmentOne(); // frag1 class obj
            FragmentManager fm = getSupportFragmentManager(); // get a manager to do a transaction?
            FragmentTransaction ft = fm.beginTransaction(); // begin transaction
            ft.replace(R.id.fragmentPlace, fragment); // replace the fragment
            ft.commit(); // always commit after a replace/transaction
        }

        if (view == findViewById(R.id.button5)) {
            fragment = new FragmentTwo(); // frag2 class obj
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragmentPlace, fragment);
            ft.commit();
        }
    }
}
