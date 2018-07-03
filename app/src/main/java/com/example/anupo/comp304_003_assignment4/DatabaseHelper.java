package com.example.anupo.comp304_003_assignment4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="ShoppingDB.db";
    public static final String tableName="Customer";
    /*public static final String col_customerId="CustomerId";
    public static final String col_userName="UserName";
    public static final String col_password="Password";
    public static final String col_firstName="FirstName";
    public static final String col_lastName="LastName";
    public static final String col_address="Address";
    public static final String col_postalCode="PostalCode";*/

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME,null,  1);
         SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table " + tableName + " (CustomerId INTEGER PRIMARY KEY AUTOINCREMENT,UserName TEXT,Password TEXT, FirstName TEXT,LastName TEXT,LastName TEXT,LastName TEXT) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     db.execSQL("DROP TABLE IF EXISTS "+tableName);
     onCreate(db);
    }
}
