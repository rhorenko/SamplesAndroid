package com.samples.dbcontacts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.provider.BaseColumns;

public class ContactDbHelper extends SQLiteOpenHelper 
        implements BaseColumns {
    
    public static final String TABLE_NAME = "contact";
    public static final String COL_NAME = "first_name";
    public static final String COL_PHONE = "phone";
    
    public static final Uri URI_CONTENT
        = Uri.parse("content://com.samples.dbcontacts.ContactProvider/contact");
    public static final int URI_CODE = 1;
    public static final int URI_CODE_ID = 2;
    
    public ContactDbHelper(Context context) {
        super(context, ContactProvider.DB_CONTACTS, null, 1);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        Cursor c = db.rawQuery(
         "SELECT name FROM sqlite_master WHERE type='table' AND name='" 
                + TABLE_NAME + "'", null);
        
        try {
            if (c.getCount()==0) {
                db.execSQL("CREATE TABLE " + TABLE_NAME 
                        + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " 
                        + COL_NAME + " TEXT, " + COL_PHONE + " TEXT);");
                
                ContentValues values = new ContentValues();
                              
                values.put(COL_NAME, "Jacob Anderson");
                values.put(COL_PHONE, "412412411");
                db.insert(TABLE_NAME, COL_NAME, values);  
                
                values.put(COL_NAME, "Emily Duncan");
                values.put(COL_PHONE, "161863187");
                db.insert(TABLE_NAME, COL_NAME, values);             
                
                values.put(COL_NAME, "Michael Fuller");
                values.put(COL_PHONE, "896443658");
                db.insert(TABLE_NAME, COL_NAME, values);      
                
                values.put(COL_NAME, "Emma Greenman");
                values.put(COL_PHONE, "964990543");
                db.insert(TABLE_NAME, COL_NAME, values);
                
                values.put(COL_NAME, "Joshua Harrison");
                values.put(COL_PHONE, "759285086");
                db.insert(TABLE_NAME, COL_NAME, values);
                
                values.put(COL_NAME, "Madison Johnson");
                values.put(COL_PHONE, "950285777");
                db.insert(TABLE_NAME, COL_NAME, values);  
                
                values.put(COL_NAME, "Matthew Cotman");
                values.put(COL_PHONE, "687699999");
                db.insert(TABLE_NAME, COL_NAME, values);
                
                values.put(COL_NAME, "Olivia Lawson");
                values.put(COL_PHONE, "161863187");
                db.insert(TABLE_NAME, COL_NAME, values);
                
                values.put(COL_NAME, "Andrew Chapman");
                values.put(COL_PHONE, "546599645");
                db.insert(TABLE_NAME, COL_NAME, values);
                
                values.put(COL_NAME, "Daniel Honeyman");
                values.put(COL_PHONE, "876545644");
                db.insert(TABLE_NAME, COL_NAME, values);
                
                values.put(COL_NAME, "Isabella Jackson");
                values.put(COL_PHONE, "907868756");
                db.insert(TABLE_NAME, COL_NAME, values);
                
                values.put(COL_NAME, "William Patterson");
                values.put(COL_PHONE, "687699693");
                db.insert(TABLE_NAME, COL_NAME, values);
                
                values.put(COL_NAME, "Joseph Godwin");
                values.put(COL_PHONE, "965467575");
                db.insert(TABLE_NAME, COL_NAME, values);
                
                values.put(COL_NAME, "Samantha Bush");
                values.put(COL_PHONE, "907865645");
                db.insert(TABLE_NAME, COL_NAME, values);
               
                values.put(COL_NAME, "Christopher Gateman");
                values.put(COL_PHONE, "896874556");
                db.insert(TABLE_NAME, COL_NAME, values);
            }
        }
        finally {
            c.close();
        }
    }

    
    @Override
    public void onUpgrade(
            SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}