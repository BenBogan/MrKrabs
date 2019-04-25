package com.example.mrkrabs;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListAdapter;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class GeneralInput extends Activity implements OnClickListener{


    private Button GeneralButton;
    private EditText CurrentCity;
    private EditText NewCity;
    private EditText ExpectedSalary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.general_input);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, Cities);
        AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.cities_list);
        textView.setAdapter(adapter);

        GeneralButton = findViewById(R.id.GeneralButton);

        GeneralButton.setOnClickListener(this);
    }

    public void onClick(View a){
        GoToRent();
    }
    private static final String[] Cities = new String[] {
            "Belgium", "France", "Italy", "Germany", "Spain"
    };
    private void GoToRent(){
        Intent shift = new Intent(GeneralInput.this, RentInput.class);
        startActivity(shift);
    }
}