package com.example.anupo.comp304_003_assignment4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.SharedPreferences;
import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    DatabaseHelper shoppingDB;
    EditText usernameInput;
    Button btnRegister,btnLogin;

    RadioButton customerRadioButton, adminRadioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
              saveLoginInfo(v);
              customerRadioButton=(RadioButton)findViewById(R.id.customerRadioButton);
              adminRadioButton=(RadioButton)findViewById(R.id.adminRadioButton);
              if(adminRadioButton.isChecked())
              {startActivity(new Intent(MainActivity.this,AdminActivity.class));}
              else if(customerRadioButton.isChecked())
              {
                  try
                  {
                        Customer customer = shoppingDB.getCustomerByUserName("((EditText)findViewById(R.id.loginUserName)).getText().toString())", "username");
                        boolean compare=((EditText)findViewById(R.id.loginUserName)).getText().toString()==customer.username.toString();
                        if(compare==true)
                        {
                            ((TextView)findViewById(R.id.messageLogin)).setText("Login Success !!!");

                        }
                        else
                        {
                            ((TextView)findViewById(R.id.messageLogin)).setText("Login NOT Success");
                            finish();
                        }

                  }
                  catch(Exception e)
                  {
                      Log.d("Customer",e.getMessage());
                  }
                  startActivity(new Intent(MainActivity.this,OrderActivity.class));
              }
              else {return;}

          }
      });

    }
    // Validate Login Info
    public void loginValidity()
    {


    }
        // Save login info By Shared Preference
    public void saveLoginInfo(View view)
    {
        SharedPreferences sharePref=getSharedPreferences("loginInfo", Context.MODE_PRIVATE );
        SharedPreferences.Editor editor =sharePref.edit();
        usernameInput=(EditText)findViewById(R.id.loginUserName);
        editor.putString("userName",usernameInput.getText().toString());
        editor.apply();
        Toast.makeText(this,"Saved",Toast.LENGTH_LONG).show();

    }




}
