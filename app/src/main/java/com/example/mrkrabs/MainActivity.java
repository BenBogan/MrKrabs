package com.example.mrkrabs;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
//These are the Imports

//MainActivity is a simple class. The user is greeted with text, and a button to continue.
public class MainActivity extends Activity implements OnClickListener{

    private Button welcomebutton; //This is the continue button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcomebutton = findViewById(R.id.WelcomeButton);

        welcomebutton.setOnClickListener(this);
    }

    public void onClick(View a){
        GoToGeneral();
    } //On the button click the user is directed to the following screen

    private void GoToGeneral(){
        Intent GeneralShift = new Intent(MainActivity.this, AllInputs.class);
        startActivity(GeneralShift);
    }
}