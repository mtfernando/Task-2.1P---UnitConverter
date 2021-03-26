package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //Declaring global variables
    Spinner spinner;
    TextView userInput, placeholder1, placeholder2, placeholder3, output1, output2, output3;
    ImageButton measureButton, temperatureButton, weightButton;
    int spinnerPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing variables for each view
        spinner = findViewById(R.id.spinner);
        userInput = findViewById(R.id.userEntry);

        placeholder1 = findViewById(R.id.placeholder1);
        placeholder2 = findViewById(R.id.placeholer2);
        placeholder3 = findViewById(R.id.placeholder3);

        output1 = findViewById(R.id.output1);
        output2 = findViewById(R.id.output2);
        output3 = findViewById(R.id.output3);

        measureButton = findViewById(R.id.measureButton);
        temperatureButton = findViewById(R.id.temperatureButton);
        weightButton = findViewById(R.id.weightButton);

        //Initializing Spinner
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
        if(spinnerPosition!=0){
            Toast.makeText(getApplicationContext(), "Error! Incorrect Unit Selection.", Toast.LENGTH_SHORT).show();
        }
//        Code to process user input and display conversions
        else{ //Output length in cm, ft, and inches.
            double inputValue = Double.parseDouble(userInput.getText().toString());
            System.out.println(inputValue);

            //Calculate conversions
            double cm = inputValue*100;
            double ft = inputValue*3.28084;
            double inches = inputValue*3.28084*12;

            //Output to view
            output1.setText(String.format("%.2f", cm));
            placeholder1.setText("Centimetre");

            output2.setText(String.format("%.2f", ft));
            placeholder2.setText("Foot");

            output3.setText(String.format("%.2f",inches));
            placeholder3.setText("Inch");
        }
    }

    public void temperatureConversion(View view) {
//Spinner position must be 1 - MUST BE CHECKED. Display Toast if incorrect.
        if (spinnerPosition != 1) {
            Toast.makeText(getApplicationContext(), "Error! Incorrect Unit Selection.", Toast.LENGTH_SHORT).show();
        }
//        Code to process user input and display conversions
        else {
            double inputValue = Double.parseDouble(userInput.getText().toString());
            System.out.println(inputValue);

            //Calculate conversions
            double kelvin = inputValue + 273.15;
            double fahrenheit = (inputValue*9/5)+32;

            //Output to view
            output1.setText(String.format("%.2f", fahrenheit));
            placeholder1.setText("Fahrenheit");

            output2.setText(String.format("%.2f", kelvin));
            placeholder2.setText("Kelvin");
        }
    }
    public void weightConversion(View view) {
//Spinner position must be 2 - MUST BE CHECKED. Display Toast if incorrect.
        if (spinnerPosition != 2) {
            Toast.makeText(getApplicationContext(), "Error! Incorrect Unit Selection.", Toast.LENGTH_SHORT).show();
            System.out.println("Toast Now!");
        }
//        Code to process user input and display conversions
        else {
            double inputValue = Double.parseDouble(userInput.getText().toString());
            System.out.println(inputValue);

            //Calculate conversions
            double gram = inputValue*1000;
            double ounce = inputValue*35.274;
            double pound = inputValue*2.205;

            //Output to view
            output1.setText(String.format("%.2f", gram));
            placeholder1.setText("Gram");

            output2.setText(String.format("%.2f", ounce));
            placeholder2.setText("Ounce(Oz)");

            output3.setText(String.format("%.2f",pound));
            placeholder3.setText("Pound(lb)");
        }

    }
}