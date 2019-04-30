package com.example.mrkrabs;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Spinner;

public class EssentialsInput extends Activity implements OnClickListener{


    private Button EssentialsButton;
    private Spinner Transportation;
    private EditText Grocery;
    private EditText Clothes;
    private EditText TransportationCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.essentials_input);

        String[] TransportOptions = new String[]{"Select","Public", "Personal"};

        ArrayAdapter<String> TransportAdapter = new ArrayAdapter<String>(this,
                R.layout.dropdown_layout, TransportOptions);

        Transportation = findViewById(R.id.TransportList);

        Transportation.setAdapter(TransportAdapter);


        Grocery=findViewById(R.id.Grocery);

        Clothes = findViewById(R.id.Clothes);

        TransportationCost = findViewById(R.id.TransportationCost);

        EssentialsButton = findViewById(R.id.EssentialsButton);

        EssentialsButton.setOnClickListener(this);
    }

    public void onClick(View a){

        String Grocery1 = Grocery.getText().toString();
        String Clothes1 = Clothes.getText().toString();
        String TransportationCost1= TransportationCost.getText().toString();
        String Transportation1= Transportation.getSelectedItem().toString();

        ((GlobalClass) this.getApplication()).setGrocery(Grocery1);
        ((GlobalClass) this.getApplication()).setClothes(Clothes1);
        ((GlobalClass) this.getApplication()).setTransportationCost(TransportationCost1);
        ((GlobalClass) this.getApplication()).setTransportation(Transportation1);


        GoToEntertainment();
    }

    private void GoToEntertainment(){
        Intent shift = new Intent(EssentialsInput.this, EntertainmentInput.class);
        startActivity(shift);
    }

}