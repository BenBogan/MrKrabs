package com.example.mrkrabs;

import android.app.Activity;
import android.view.Gravity;
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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RentInput extends Activity implements OnClickListener {

    private EditText RentInput1;
    private EditText Utilities1;
    private Spinner Location1;
    private EditText Bedrooms1;
    private Button RentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rent_input);

        String[] LocationOptions = new String[]{"Select","InCity","Out of City"};

        ArrayAdapter<String> Location = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, LocationOptions);

        Location1 = findViewById(R.id.Location);
        Location1.setAdapter(Location);

        Bedrooms1 = findViewById(R.id.Bedrooms);

        RentInput1 = findViewById(R.id.RentInput);
        Utilities1 = findViewById(R.id.Utilities);

        RentButton = findViewById(R.id.RentButton);

        RentButton.setOnClickListener(this);
    }


    public void onClick(View a) {
        String Bedrooms = Bedrooms1.getText().toString();
        String Location = Location1.getSelectedItem().toString();
        String Rent= RentInput1.getText().toString();
        String Utilities= Utilities1.getText().toString();

        if ((Bedrooms.equals(""))||(Location.equals("Select"))||(Rent.equals(""))||(Utilities.equals(""))) {
            Toast DestinationError = Toast.makeText(RentInput.this, "Please remember to enter a value for all fields, if not applicable enter 0", Toast.LENGTH_LONG);
            DestinationError.setGravity(Gravity.CENTER, 0, -1500);
            DestinationError.show();
            return;
        }

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
}