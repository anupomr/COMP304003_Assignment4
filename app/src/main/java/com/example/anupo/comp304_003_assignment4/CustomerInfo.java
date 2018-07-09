package com.example.anupo.comp304_003_assignment4;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CustomerInfo extends AppCompatActivity {
    DatabaseHelper shoppingDB;
    EditText txtCustomerId,txtName,txtPassword, txtFirstName, txtLastName,txtAddress,txtPostalCode,txtCity;
    Button register; //int id;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_info);
        try
        {
            shoppingDB = new DatabaseHelper(getApplicationContext());
            shoppingDB.dbInitialize("Customer", "CREATE TABLE Customer (id INTEGER PRIMARY KEY ,username TEXT ," +
                    "password TEXT,  fName TEXT,  lName TEXT,  address TEXT,  postalCode TEXT,  city TEXT);");
        }
        catch(Exception e)
        {
            Log.d("Customer", e.getMessage()+"");
        }

        register=(Button)findViewById(R.id.btnRegistrationCustomer);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

               String txtName,txtPassword, txtFirstName, txtLastName,txtAddress,txtPostalCode,txtCity;
                int txtCustomerId=Integer.parseInt(((EditText)findViewById(R.id.editCustomerID)).getText().toString());
                txtName=((EditText)findViewById(R.id.editUserName)).getText().toString();
                txtPassword=((EditText)findViewById(R.id.editPassword)).getText().toString();
                txtFirstName=((EditText)findViewById(R.id.editFName)).getText().toString();
                txtLastName=((EditText)findViewById(R.id.editLName)).getText().toString();
                txtAddress=((EditText)findViewById(R.id.editAddress)).getText().toString();
                txtPostalCode=((EditText)findViewById(R.id.editPostCode)).getText().toString();
                txtCity=((EditText)findViewById(R.id.editCity)).getText().toString();

                DatabaseHelper db = new DatabaseHelper(getApplicationContext());
                ContentValues values = new ContentValues();

                values.put("id",txtCustomerId);;
                values.put("username",txtName);
                values.put("password",txtPassword);
                String message="Success";

                try {
                    db.addRow(values);
                    // finish();
                    Log.d("success","Success");
                    Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
                }
                catch (Exception e)
                {
                    Log.d("Customer",e.getMessage());
                }

            }
        });
        findViewById(R.id.view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Customer customer = shoppingDB.getCustomerById(Integer.parseInt(((EditText)findViewById(R.id.editCustomerID)).getText().toString()), "id");

                    ((TextView)findViewById(R.id.result)).setText(customer.username.toString()+" "+customer.password.toString());
                }
                catch(Exception e)
                {
                    Log.d("Customer",e.getMessage());
                }
            }
        });

    }
}
