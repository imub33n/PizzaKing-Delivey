package com.example.fastfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    //initialize variables
    private Button signInButton,signUpButton;
    private EditText name,email,password;
    public static String saveName="Admin";
    public static String saveEmail,savePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        //getting components from xml screen
        name=findViewById(R.id.nameHere);
        email=findViewById(R.id.emailHere);
        password=findViewById(R.id.passwordHere);
        signInButton= findViewById(R.id.signIn2);
        signUpButton= findViewById(R.id.signUp2);
        //sign In button action to take to sign in page
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SignIn.class);
                startActivity(intent);
            }
        });
        //conditions checking on pressing signup button
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().isEmpty()){
                    //show a pop up message
                    Toast.makeText(getApplicationContext(), "!!Please write your name!!", Toast.LENGTH_SHORT).show();
                }
                else if(email.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "!!Please write your email!!", Toast.LENGTH_SHORT).show();
                }
                else if(password.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "!!Please write your password!!", Toast.LENGTH_SHORT).show();
                }else{
                    //storing data for later use
                    saveName= name.getText().toString();
                    savePassword= password.getText().toString();
                    saveEmail=email.getText().toString();

                    Toast.makeText(getApplicationContext(), "Successfully Registered!! SignIn to Continue!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }

            }
        });
    }
}