package com.example.anupo.comp304_003_assignment4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.SharedPreferences;
import android.content.Context;


public class MainActivity extends AppCompatActivity {
DatabaseHelper shoppingDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shoppingDB=new DatabaseHelper(this);
    }
    // Save login info By Shared Preference
    public void saveLoginInfo(View view)
    {
        SharedPreferences sha=getSharedPreferences("loginInfo", Context.MODE_PRIVATE );

    }
}
