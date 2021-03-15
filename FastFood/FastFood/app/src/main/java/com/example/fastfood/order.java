package com.example.fastfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class order extends AppCompatActivity {
    //initialize variables
    public Spinner spinner,spinner2;
    public EditText num,addres;
    public static String City,PaymentMethod,Number, Address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        //getting components from xml screen
        spinner = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        num= findViewById(R.id.cNumber);
        addres= findViewById(R.id.address);
//payment
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.payment, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

//City
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.city, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
    }
//method called onClick on Confirm order button
    public void confirmOrder(View view) {
        //Checking if all the fields are filled before continuing
        if(num.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Please write your number!", Toast.LENGTH_SHORT).show();
        }if(addres.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Please write your address!", Toast.LENGTH_SHORT).show();
        }if(spinner.getSelectedItem().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Please select a payment method!", Toast.LENGTH_SHORT).show();
        }if(spinner2.getSelectedItem().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Please select a city!", Toast.LENGTH_SHORT).show();
        }
        else{
            //storing data for recipt
            PaymentMethod =spinner.getSelectedItem().toString() ;
            City =spinner2.getSelectedItem().toString() ;
            Number =num.getText().toString();
            Address = addres.getText().toString();
            //calling next screen
            Intent intent= new Intent(getApplicationContext(), Recipt.class);
            startActivity(intent);
        }

    }
}