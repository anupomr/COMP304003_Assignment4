package com.example.anupo.comp304_003_assignment4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.SharedPreferences;
import android.content.Context;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
DatabaseHelper shoppingDB;
    Button btnRegister,btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //shoppingDB=new DatabaseHelper(this);

        //Register new Customer
        btnRegister= (Button)findViewById(R.id.btnRegisterCustomer);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, CustomerInfo.class);
                startActivity(intent);
            }
        });
      btnLogin=(Button)findViewById(R.id.btnLogin);
      btnLogin.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

          }
      });

    }
    // Validate Login Info
    public void loginValidity()
    {
        SharedPreferences sha=getSharedPreferences("loginInfo", Context.MODE_PRIVATE );

    }
        // Save login info By Shared Preference
    public void saveLoginInfo(View view)
    {
        SharedPreferences sha=getSharedPreferences("loginInfo", Context.MODE_PRIVATE );

    }




}
