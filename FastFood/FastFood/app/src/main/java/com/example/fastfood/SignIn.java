package com.example.fastfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {
    //initialize variables
    private Button signUpButton,signInButton;
    private EditText emailField,passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        //getting components from xml screen
        signUpButton= findViewById(R.id.signUp);
        signInButton= findViewById(R.id.signIn);
        emailField=findViewById(R.id.signInEmail);
        passwordField=findViewById(R.id.signInPassword);
        //sign up button action to take to signup page
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent);
            }
        });
        //conditions checking on pressing signin button
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(emailField.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "!!Please write your email address!!", Toast.LENGTH_SHORT).show();
                }
                else if(passwordField.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "!!Please enter your password!!", Toast.LENGTH_SHORT).show();
                }
                else if(emailField.getText().toString().matches("admin") && passwordField.getText().toString().matches("admin")){
                    Intent intent= new Intent(getApplicationContext(), Browse.class);
                    startActivity(intent);
                }
                else if(emailField.getText().toString().matches(SignUp.saveEmail) && passwordField.getText().toString().matches(SignUp.savePassword)){
                    Toast.makeText(getApplicationContext(),"Welcome!!", Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(getApplicationContext(), Browse.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "!!Wrong Email or Password, Try Again!!", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}