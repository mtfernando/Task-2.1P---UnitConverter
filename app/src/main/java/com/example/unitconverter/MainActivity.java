package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int spinnerPosition = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinnerLabels, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        System.out.println(position);
        spinnerPosition = position;
        System.out.println("New spinner position is " + spinnerPosition);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //Methods for button onClick - Unit Conversions and Spinner checks.
    public void lengthConversion(View view){
//Spinner position must be 0 - MUST BE CHECKED. Display Toast if incorrect.
//        Code to process user input and display conversions
    }

    public void temperatureConversion(View view){
//Spinner position must be 1 - MUST BE CHECKED. Display Toast if incorrect.
//        Code to process user input and display conversions
    }

    public void weightConversion(View view){
//Spinner position must be 2 - MUST BE CHECKED. Display Toast if incorrect.
//        Code to process user input and display conversions
    }
}