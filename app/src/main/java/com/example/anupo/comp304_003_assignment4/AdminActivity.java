package com.example.anupo.comp304_003_assignment4;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AdminActivity extends AppCompatActivity {
    TextView headingText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        headingText=(TextView)findViewById(R.id.headingAdmin);
        displayInfo();
    }
    //Retrieve information by SharedPreferences
    public void displayInfo(){
        SharedPreferences sharePref=getSharedPreferences("loginInfo", Context.MODE_PRIVATE );
        String uName=sharePref.getString("userName","");
        headingText.setText("Welcome "+uName +" in Admin panel");
    }
}
