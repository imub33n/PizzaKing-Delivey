package com.example.fastfood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Recipt extends AppCompatActivity {
    //initialize variables
    public TextView personName,cNumber,address,pizzaName,pizzaPrice,includedItems,subTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipt);

        //getting components from xml screen
        personName=findViewById(R.id.namePerson);
        cNumber=findViewById(R.id.contactNo);
        address=findViewById(R.id.address);
        pizzaName=findViewById(R.id.pizzaName);
        pizzaPrice=findViewById(R.id.pizzaPrice);
        includedItems=findViewById(R.id.includedItems);
        subTotal=findViewById(R.id.subTotal);

        //casting data to receipt screen
        personName.setText("Name : "+SignUp.saveName);
        cNumber.setText("Contact No. : "+order.Number);
        address.setText(order.Address);
        pizzaName.setText(Browse.Item);
        pizzaPrice.setText("  Cost: "+Browse.PizzaPrice+"£");
        includedItems.setText("\nFlavor: "+ FoodItem.Flavor+"\nSauce: "+FoodItem.Sauce+"\nVeggies:"+FoodItem.Includes);
        float total= (float) ((Integer.parseInt(Browse.PizzaPrice))+(0.69));
        subTotal.setText("Sub Total(Inc. tax) : "+ total+"£");
    }
}