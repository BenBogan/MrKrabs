package com.example.mrkrabs;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class EntertainmentInput extends Activity implements OnClickListener{


    private Button EntertainmentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entertainment_input);

        EntertainmentButton = findViewById(R.id.EntertainmentButton);

        EntertainmentButton.setOnClickListener(this);
    }

    public void onClick(View a){
        GoToResults();
    }

    private void GoToResults(){
        Intent shift = new Intent(EntertainmentInput.this, Results1.class);
        startActivity(shift);
    }
}