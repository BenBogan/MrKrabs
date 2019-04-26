package com.example.mrkrabs;

import android.app.Activity;
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

public class RentInput extends Activity implements OnClickListener {

    private EditText RentInput1;
    private EditText Utilities1;
    private AutoCompleteTextView Location1;
    private AutoCompleteTextView Bedrooms1;
    private Button RentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rent_input);

        ArrayAdapter<String> Location = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, ApartmentLocation);

        Location1 = findViewById(R.id.Location);
        Location1.setAdapter(Location);

        ArrayAdapter<String> bedroom = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, NumBedrooms);

        Bedrooms1 = findViewById(R.id.Bedrooms);
        Bedrooms1.setAdapter(bedroom);

        RentInput1 = findViewById(R.id.RentInput);
        Utilities1 = findViewById(R.id.Utilities);

        RentButton = findViewById(R.id.RentButton);

        RentButton.setOnClickListener(this);
    }


    public void onClick(View a) {
        String Bedrooms = Bedrooms1.getText().toString();
        String Location = Location1.getText().toString();
        String Rent= RentInput1.getText().toString();
        String Utilities= Utilities1.getText().toString();

        ((GlobalClass) this.getApplication()).setRentPerMonth(Rent);
        ((GlobalClass) this.getApplication()).setBedrooms(Bedrooms);
        ((GlobalClass) this.getApplication()).setLocation(Location);
        ((GlobalClass) this.getApplication()).setUtilities(Utilities);
        GoToEssentials();
    }

    private void GoToEssentials() {
        Intent shift = new Intent(RentInput.this, EssentialsInput.class);
        startActivity(shift);
    }


    private static final String[] ApartmentLocation = new String[]{
            "In City", "Outside City"
    };

    private static final String[] NumBedrooms = new String[]{
            "1", "2", "3+"
    };
}