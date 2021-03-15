package com.example.fastfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.widget.TextView;

public class Browse extends AppCompatActivity {
    //Select Item Screen
    //initialize variables
    public static String Item,Servers,PizzaPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
    }
    //method called onClick action on pizza pictures
    public void foodChoice(View view) {
        //next screen called
        Intent intent= new Intent(getApplicationContext(), FoodItem.class);
        startActivity(intent);
        //geting photo tag for photo that called on Click method
        int taag = Integer.parseInt((String)view.getTag());
        //every taged photo has a pecific name, pizza size and price
        switch (taag) {
            case 0:
                Item = "Orignal Full 21'";
                Servers= "6-8";
                PizzaPrice= "15";
                break;
            case 1:
                Item = "Orignal 10'";
                Servers= "2-3";
                PizzaPrice= "8";
                break;
            case 2:
                Item = "Orignal 15'";
                Servers= "4-5";
                PizzaPrice= "12";
                break;
            case 3:
                Item = "Special 21'";
                Servers= "6-8";
                PizzaPrice= "17";
                break;
        }
    }

}