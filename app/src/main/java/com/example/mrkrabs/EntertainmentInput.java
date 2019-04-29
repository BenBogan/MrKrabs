package com.example.mrkrabs;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class EntertainmentInput extends Activity implements OnClickListener{


    private Button EntertainmentButton;
    private EditText DiningOut;
    private EditText Alcohol;
    private EditText Fitness;
    private EditText Other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entertainment_input);

        DiningOut=findViewById(R.id.DiningOut);
        Alcohol=findViewById(R.id.Alcohol);
        Fitness = findViewById(R.id.Fitness);
        Other=findViewById(R.id.Other);

        EntertainmentButton = findViewById(R.id.EntertainmentButton);

        EntertainmentButton.setOnClickListener(this);
    }

    public void onClick(View a){

        String Diningout1 = DiningOut.getText().toString();
        String Alcohol1 = Alcohol.getText().toString();
        String Fitness1= Fitness.getText().toString();
        String Other1= Other.getText().toString();

        ((GlobalClass) this.getApplication()).setDining(Diningout1);
        ((GlobalClass) this.getApplication()).setAlcohol(Alcohol1);
        ((GlobalClass) this.getApplication()).setFitness(Fitness1);
        ((GlobalClass) this.getApplication()).setMisc(Other1);


        GoToResults();

    }

    private void GoToResults(){
        Intent shift = new Intent(EntertainmentInput.this, Results1.class);
        startActivity(shift);
    }
}