package com.example.fastfood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;
import android.os.Looper;

public class MainActivity extends AppCompatActivity {

    //Splash Screen
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setting delay before signin screen appears
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(getApplicationContext(), SignIn.class);
                startActivity(intent);
            }
        }, 2000);//timer set for 2 seconds
    }
}