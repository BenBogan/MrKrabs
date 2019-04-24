package com.example.mrkrabs;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class RentInput extends Activity implements OnClickListener{


    private Button RentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rent_input);

        RentButton = findViewById(R.id.RentButton);

        RentButton.setOnClickListener(this);
    }

    public void onClick(View a){
        GoToRent();
    }

    private void GoToRent(){
        Intent shift = new Intent(RentInput.this, EssentialsInput.class);
        startActivity(shift);
    }
}