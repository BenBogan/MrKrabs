package com.example.mrkrabs;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

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

        if ((Diningout1.equals(""))||(Alcohol1.equals(""))||(Fitness1.equals(""))||(Other1.equals(""))) {
            Toast DestinationError = Toast.makeText(EntertainmentInput.this, "Please remember to enter a value for all fields, if not applicable enter 0", Toast.LENGTH_LONG);
            DestinationError.setGravity(Gravity.CENTER, 0, -1500);
            DestinationError.show();
            return;
        }

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