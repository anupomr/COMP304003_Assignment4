package com.example.anupo.comp304_003_assignment4;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdminActivity extends AppCompatActivity {
    TextView headingText;
    DatabaseHelper shoppingDB;
    Button btnView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        //region Table Part
        try
        {
            shoppingDB = new DatabaseHelper(getApplicationContext());
            shoppingDB.dbInitialize("Admin", "CREATE TABLE Admin (employeeId INTEGER PRIMARY KEY ,userName TEXT ," +
                    "password TEXT,  fName TEXT,  lName TEXT);");
        }
        catch(Exception e)
        {
            Log.d("Admin", e.getMessage()+"");
        }
        ContentValues values = new ContentValues();
        values.put("employeeId",101);;
        values.put("userName","anupomr");
        values.put("password","123456");
        values.put("fName","Anupom");
        values.put("lName","Roy");
        String message="Success";

        try {
            shoppingDB.addRow(values);
            // finish();
            Log.d("success","Success");
            Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            Log.d("Admin",e.getMessage());
        }
        //endregion

        headingText=(TextView)findViewById(R.id.headingAdmin);
        displayInfo();

        btnView=(Button)findViewById(R.id.btnView);
        btnView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                //int id=101;
                try
                {
                Admin admin = shoppingDB.getAdminById(101, "employeeId");
                ((TextView)findViewById(R.id.showResult)).setText(admin.userName.toString()+" "+admin.password.toString());
                }
                catch(Exception e)
                {
                    Log.d("Admin",e.getMessage());
                }
            }
        });
    }
    //Retrieve information by SharedPreferences
    public void displayInfo()
    {
        SharedPreferences sharePref=getSharedPreferences("loginInfo", Context.MODE_PRIVATE );
        String uName=sharePref.getString("userName","");
        headingText.setText("Welcome "+uName.toUpperCase() +" in Admin panel");
    }
}
