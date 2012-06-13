package com.samples.dbcontacts;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class ContactDbHelper extends SQLiteOpenHelper 
        implements BaseColumns {
    
    public static final String TABLE_NAME = "contact";
    public static final String NAME = "first_name";
    public static final String PHONE = "phone";
    
    public ContactDbHelper(Context context) {
        super(context, ContactProvider.DB_CONTACTS, null, 1);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME 
                + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " 
                + NAME + " TEXT, " + PHONE + " TEXT);");
        
        ContentValues values = new ContentValues();
                      
        values.put(NAME, "Jacob Anderson");
        values.put(PHONE, "412412411");
        db.insert(TABLE_NAME, NAME, values);  
        
        values.put(NAME, "Emily Duncan");
        values.put(PHONE, "161863187");
        db.insert(TABLE_NAME, NAME, values);             
        
        values.put(NAME, "Michael Fuller");
        values.put(PHONE, "896443658");
        db.insert(TABLE_NAME, NAME, values);      
        
        values.put(NAME, "Emma Greenman");
        values.put(PHONE, "964990543");
        db.insert(TABLE_NAME, NAME, values);
        
        values.put(NAME, "Joshua Harrison");
        values.put(PHONE, "759285086");
        db.insert(TABLE_NAME, NAME, values);
        
        values.put(NAME, "Madison Johnson");
        values.put(PHONE, "950285777");
        db.insert(TABLE_NAME, NAME, values);  
        
        values.put(NAME, "Matthew Cotman");
        values.put(PHONE, "687699999");
        db.insert(TABLE_NAME, NAME, values);
        
        values.put(NAME, "Olivia Lawson");
        values.put(PHONE, "161863187");
        db.insert(TABLE_NAME, NAME, values);
        
        values.put(NAME, "Andrew Chapman");
        values.put(PHONE, "546599645");
        db.insert(TABLE_NAME, NAME, values);
        
        values.put(NAME, "Daniel Honeyman");
        values.put(PHONE, "876545644");
        db.insert(TABLE_NAME, NAME, values);
        
        values.put(NAME, "Isabella Jackson");
        values.put(PHONE, "907868756");
        db.insert(TABLE_NAME, NAME, values);
        
        values.put(NAME, "William Patterson");
        values.put(PHONE, "687699693");
        db.insert(TABLE_NAME, NAME, values);
        
        values.put(NAME, "Joseph Godwin");
        values.put(PHONE, "965467575");
        db.insert(TABLE_NAME, NAME, values);
        
        values.put(NAME, "Samantha Bush");
        values.put(PHONE, "907865645");
        db.insert(TABLE_NAME, NAME, values);
       
        values.put(NAME, "Christopher Gateman");
        values.put(PHONE, "896874556");
        db.insert(TABLE_NAME, NAME, values);

    }

    
    @Override
    public void onUpgrade(
            SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }   
}