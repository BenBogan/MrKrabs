package com.example.mrkrabs;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class GeneralInput extends Activity implements OnClickListener{


    private Button GeneralButton;
    private EditText MonthlyRent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.general_input);

        GeneralButton = findViewById(R.id.GeneralButton);

        GeneralButton.setOnClickListener(this);
    }

    public void onClick(View a){
        GoToRent();
    }

    private void GoToRent(){
        Intent shift = new Intent(GeneralInput.this, RentInput.class);
        startActivity(shift);
    }
}