package com.example.anupo.comp304_003_assignment4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CustomerInfo extends AppCompatActivity {
    DatabaseHelper shoppingDB;
    EditText txtCustomerId,txtName,txtPassword, txtFirstName, txtLastName,txtAddress,txtPostalCode,txtCity;
    Button register; int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_info);

        shoppingDB =new DatabaseHelper(this);

        txtCustomerId=(EditText)findViewById(R.id.editCustomerID);
        txtName=(EditText)findViewById(R.id.editUserName);
        txtPassword=(EditText)findViewById(R.id.editPassword);
        txtFirstName=(EditText)findViewById(R.id.editFName);
        txtLastName=(EditText)findViewById(R.id.editLName);
        txtAddress=(EditText)findViewById(R.id.editAddress);
        txtPostalCode=(EditText)findViewById(R.id.editPostCode);
        txtCity=(EditText)findViewById(R.id.editCity);
        register=(Button)findViewById(R.id.btnRegistrationCustomer);
        /*//id=;
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //boolean isInserted=  shoppingDB.insertCustomerData()
                boolean isInserted=  shoppingDB.insertCustomerData(Integer.parseInt(txtCustomerId.getText().toString()),txtName.getText().toString(),txtPassword.getText().toString(), txtFirstName.getText().toString(),txtLastName.getText().toString(),txtAddress.getText().toString(),txtPostalCode.getText().toString(),txtCity.getText().toString());
                if(isInserted==true)
                {
                    Toast.makeText(CustomerInfo.this,"Data Inserted",Toast.LENGTH_LONG).show();

                }
                else
                    {
                    Toast.makeText(CustomerInfo.this,"Data Not Inserted",Toast.LENGTH_LONG).show();
                }
            }
        });*/
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                /*shoppingDB.insertCustomerData(Integer.parseInt(txtCustomerId.getText().toString()),txtName.getText().toString(),txtPassword.getText().toString(), txtFirstName.getText().toString(),txtLastName.getText().toString(),txtAddress.getText().toString(),txtPostalCode.getText().toString(),txtCity.getText().toString());
                Toast.makeText(CustomerInfo.this,"Data Inserted",Toast.LENGTH_LONG).show();
                */
                boolean isInserted=  shoppingDB.insertCustomerData(102,txtName.getText().toString(),txtPassword.getText().toString(), txtFirstName.getText().toString(),txtLastName.getText().toString(),txtAddress.getText().toString(),txtPostalCode.getText().toString(),txtCity.getText().toString());
                if(isInserted==true)
                {
                    Toast.makeText(CustomerInfo.this,"Data Inserted",Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(CustomerInfo.this,"Data Not Inserted",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
