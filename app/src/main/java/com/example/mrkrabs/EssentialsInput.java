package com.example.mrkrabs;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class EssentialsInput extends Activity implements OnClickListener{


    private Button EssentialsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.essentials_input);

        EssentialsButton = findViewById(R.id.EssentialsButton);

        EssentialsButton.setOnClickListener(this);
    }

    public void onClick(View a){
        GoToEntertainment();
    }

    private void GoToEntertainment(){
        Intent shift = new Intent(EssentialsInput.this, EntertainmentInput.class);
        startActivity(shift);
    }
}