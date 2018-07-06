package com.example.anupo.comp304_003_assignment4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelper";
    public static final String DATABASE_NAME="ShoppingDB";
    //DataBase Version
    private static final int DATABASE_VERSION = 1;
    public static String tableName;
    private static String tableCreatorString;
    //region oldCode
    /*
    //Table Name
    private static String CUSTOMER_TABLE = "Customer";
    private static String ADMIN_TABLE = "Admin";
    private static String ORDER_TABLE = "Order";
    private static String ITEM_TABLE = "Item";

    // Column Name for Customer Table
    private static final String COLUMN_CUSTOMER_ID = "customer_id";
    private static final String COLUMN_CUSTOMER_USERNAME = "customer_username";
    private static final String COLUMN_CUSTOMER_PASSWORD = "customer_password";
    private static final String COLUMN_CUSTOMER_FNAME = "customer_firstname";
    private static final String COLUMN_CUSTOMER_LNAME = "customer_lastname";
    private static final String COLUMN_CUSTOMER_ADDRESS = "customer_address";
    private static final String COLUMN_CUSTOMER_POSTAL_CODE = "customer_postalcode";
    private static final String COLUMN_CUSTOMER_CITY = "customer_city";

    // Column name for Admin Table
    private static final String COLUMN_ADMIN_ID = "admin_id";
    private static final String COLUMN_ADMIN_USERNAME = "admin_username";
    private static final String COLUMN_ADMIN_PASSWORD = "admin_password";
    private static final String COLUMN_ADMIN_FNAME = "admin_firstname";
    private static final String COLUMN_ADMIN_LNAME = "admin_lastname";

    // Column name for Order table
    private static final String COLUMN_ORDER_ID = "order_id";
    private static final String COLUMN_ORDER_ITEM_ID = "item_id";
    private static final String COLUMN_ORDER_CUSTOMER_ID = "customer_id";
    private static  double COLUMN_ORDER_AMOUNT = 0.0;
    private static final Date COLUMN_DELIVERYDATE = null;
    private static final Boolean COLUMN_STATUS =false;

    // Column name for Item Table
    private static final String COLUMN_ITEM_ID = "item_id";
    private static final String COLUMN_ITEM_NAME = "item_name";
    private static final double COLUMN_ITEM_PRICE = 0.0;
    private static final String category="item_category";
    //create table for Customer sql query
    private static final String CREATE_CUSTOMER_TABLE = " CREATE TABLE " + CUSTOMER_TABLE
            + "("
            + COLUMN_CUSTOMER_ID + " INTEGER PRIMARY KEY,"
            + COLUMN_CUSTOMER_USERNAME + " TEXT,"
            + COLUMN_CUSTOMER_PASSWORD + " TEXT,"
            + COLUMN_CUSTOMER_FNAME + " TEXT,"
            + COLUMN_CUSTOMER_LNAME + " TEXT,"
            + COLUMN_CUSTOMER_ADDRESS + " TEXT,"
            + COLUMN_CUSTOMER_POSTAL_CODE + " TEXT,"
            + COLUMN_CUSTOMER_CITY + " TEXT" + ")";

    // create table for admin sql querry

    private static final String CREATE_ADMIN_TABLE = " CREATE TABLE IF NOT EXISTS " + ADMIN_TABLE
            + "("
            + COLUMN_ADMIN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_ADMIN_USERNAME + " TEXT,"
            + COLUMN_ADMIN_PASSWORD + " TEXT,"
            + COLUMN_ADMIN_FNAME + " TEXT,"
            + COLUMN_ADMIN_LNAME + " TEXT"+ ")";
            */
    //endregion

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME,null,  DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tableCreatorString);
       // db.execSQL(CREATE_ADMIN_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+tableName);
     //db.execSQL("DROP TABLE IF EXISTS "+ADMIN_TABLE);
     onCreate(db);
    }
    //region Old CURD
    /*
    public boolean insertCustomerData(int id, String username, String password, String fName, String lName, String address, String pocalCode, String city)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_CUSTOMER_ID, id);
        values.put(COLUMN_CUSTOMER_USERNAME, username);
        values.put(COLUMN_CUSTOMER_PASSWORD, password);
        values.put(COLUMN_CUSTOMER_FNAME, fName);
        values.put(COLUMN_CUSTOMER_LNAME, lName);
        values.put(COLUMN_CUSTOMER_ADDRESS, address);
        values.put(COLUMN_CUSTOMER_POSTAL_CODE, pocalCode);
        values.put(COLUMN_CUSTOMER_CITY, city);
        long customerResult = db.insert(CREATE_CUSTOMER_TABLE, null, values);

        db.close();

        //if Data insert incorrectly it will return -1
        if (customerResult == -1) {
            return false;
        }
        else {
            return true;
        }
    }
    // Insert into admin table
    public boolean insertAdminData(int id, String username, String password, String fName, String lName) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_CUSTOMER_ID, id);
        values.put(COLUMN_ADMIN_USERNAME, username);
        values.put(COLUMN_ADMIN_PASSWORD, password);
        values.put(COLUMN_ADMIN_FNAME, fName);
        values.put(COLUMN_ADMIN_LNAME, lName);

        long adminResult = db.insert(CREATE_ADMIN_TABLE, null, values);

        db.close();

        //if Data insert incorrectly it will return -1
        if (adminResult == -1) {
            return false;
        }
        else {
            return true;
        }
    }
    */
    //endregion
    public void dbInitialize(String tableName, String tableCreatorString)
    {
        this.tableName=tableName;
        this.tableCreatorString=tableCreatorString;
    }
    public boolean addRow(ContentValues values)throws Exception{
        SQLiteDatabase db=this.getWritableDatabase();
        long nr=db.insert(tableName,null,values);
        db.close();
        return nr>-1;
    }
    public Customer getCustomerById(Integer id, String fieldName)throws Exception{
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from "+tableName+" where "+fieldName+"='"+id+"'",null);
        Customer customer=new Customer();
        if (cursor.moveToFirst()){
            cursor.moveToFirst();
            customer.setId(cursor.getInt(0));
            customer.setUsername(cursor.getString(1));
            customer.setPassword(cursor.getString(2));
            cursor.close();
        }else {customer=null;}
        db.close();
        return customer;
    }
}
