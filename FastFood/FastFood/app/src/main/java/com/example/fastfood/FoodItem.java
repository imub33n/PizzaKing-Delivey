package com.example.fastfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class FoodItem extends AppCompatActivity {

    //Ingredients Screen

    //initialize variables
    private TextView titleFoodItem;
    private RadioGroup radioGroup1,radioGroup2;
    private RadioButton radioButton1,radioButton2;
    private CheckBox checkBox1,checkBox2,checkBox3;
    public static String Includes,Flavor,Sauce ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_item);
        //getting component from xml screen
        titleFoodItem = findViewById(R.id.titleFoodItem);
        //setting title for page
        titleFoodItem.setText("Please select your pizza flavor and sause type!!");
    }
//method called onClick on Add to cart button
    public void completeOrder(View view) {
        //getting components from xml screen
        radioGroup1 = findViewById(R.id.radioGroup1);
        radioGroup2 =  findViewById(R.id.radioGroup2);
        radioButton1 = findViewById(radioGroup1.getCheckedRadioButtonId());
        radioButton2 = findViewById(radioGroup2.getCheckedRadioButtonId());
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        //checking if radio buttons are checked before continuing
        if(radioGroup1.getCheckedRadioButtonId()==-1){
            Toast.makeText(getApplicationContext(), "Please select flavor", Toast.LENGTH_SHORT).show();
        }
        else if(radioGroup2.getCheckedRadioButtonId()==-1){
            Toast.makeText(getApplicationContext(), "Sauce type not selected", Toast.LENGTH_SHORT).show();
        }
        else{
            //saving data for recipt screen
            Flavor= radioButton1.getText().toString();
            Sauce= radioButton2.getText().toString();
            if(Includes!=""){
                Includes="";
            }
            if(checkBox1.isChecked()){
                Includes=Includes+checkBox1.getText().toString();
            } if(checkBox2.isChecked()){
                Includes=Includes+" "+checkBox2.getText().toString();
            } if(checkBox3.isChecked()){
                Includes=Includes+" "+checkBox3.getText().toString();
            }
            //calling next screen
            Intent intent= new Intent(getApplicationContext(), order.class);
            startActivity(intent);
        }
    }
}