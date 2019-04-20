package com.example.mrkrabs;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {


    private Button welcomebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcomebutton = findViewById(R.id.WelcomeButton);

        welcomebutton.setOnClickListener(this);
    }

    public void onClick(View a){
        gotosecondscreen();
    }

    private void gotosecondscreen(){
        Intent shift = new Intent(MainActivity.this, userinput.class);
    }
}