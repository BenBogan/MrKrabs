package com.example.mrkrabs;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class Results1 extends Activity implements OnClickListener{


    private Button Results1Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results1);

        Results1Button = findViewById(R.id.Results1Button);

        Results1Button.setOnClickListener(this);
    }

    public void onClick(View a){
        GoToResults1();
    }

    private void GoToResults1(){
        Intent shift = new Intent(Results1.this, MainActivity.class);
        startActivity(shift);
    }
}