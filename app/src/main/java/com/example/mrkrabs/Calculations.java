package com.example.mrkrabs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import androidx.annotation.Nullable;


public class Calculations extends Activity {

    private Button Calculate;

    private View.OnClickListener CalculateOnClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            CalculateButtonClicked();
        }

    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Calculate = new Button(this);

        Calculate.setOnClickListener(CalculateOnClickListener);
    }



    private void CalculateButtonClicked(){
        String URL = "https://www.numbeo.com/api/city_prices?api_key=3suzspurfdpdf4&query=Boston";
        RequestQueue request = Volley.newRequestQueue(this);
        Gson json=new Gson();

        JsonObjectRequest objectRequest= new JsonObjectRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String cityname = response.get(String,"name");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
    }
}
