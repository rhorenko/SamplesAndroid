package com.samples.dbcontacts;

import java.util.HashMap;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;

public class ContactProvider extends ContentProvider {
    public static final String DB_CONTACTS = "contacts.db";
    
    private static final UriMatcher mUriMatcher;
    private static HashMap<String, String> mContactMap;
    
    private SQLiteDatabase db;

    static {
        mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        mUriMatcher.addURI("com.samples.dbcontacts.ContactProvider", 
                ContactDbHelper.TABLE_NAME, ContactDbHelper.URI_CODE);
        mUriMatcher.addURI("com.samples.dbcontacts.ContactProvider", 
                ContactDbHelper.TABLE_NAME + "/#", ContactDbHelper.URI_CODE_ID);

        mContactMap = new HashMap<String, String>();
        mContactMap.put(ContactDbHelper._ID, ContactDbHelper._ID);
        mContactMap.put(ContactDbHelper.COL_NAME, ContactDbHelper.COL_NAME);
        mContactMap.put(ContactDbHelper.COL_PHONE, ContactDbHelper.COL_PHONE);
    }

    public String getDbName() {
        return(DB_CONTACTS);
    }
    
    public int getDbVersion() {
        return(1);
    }
    
    @Override
    public boolean onCreate() {
        
        db = (new ContactDbHelper(getContext())).getWritableDatabase();
        return (db == null) ? false : true;
    }
   
    @Override
    public Cursor query(Uri url, String[] projection, 
            String selection, String[] selectionArgs, String sort) {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        qb.setTables(ContactDbHelper.TABLE_NAME);
        
        if (isCollectionUri(url)) {
            qb.setProjectionMap(mContactMap);
        }
        else {
            qb.appendWhere(ContactDbHelper._ID + "=" 
                    + url.getPathSegments().get(1));
        }
        
        String orderBy;
        
        if (TextUtils.isEmpty(sort)) {
            //orderBy=getDefaultSortOrder();
            orderBy = ContactDbHelper.COL_NAME;
        } else {
            orderBy = sort;
        }

        Cursor c = qb.query(db, projection, selection, selectionArgs, 
                null, null, orderBy);
        c.setNotificationUri(getContext().getContentResolver(), url);
        return c;
    }

    @Override
    public Uri insert(Uri url, ContentValues initialValues) {

        ContentValues values;
        
        if (initialValues!=null) {
            values=new ContentValues(initialValues);
        } else {
            values=new ContentValues();
        }

        if (!isCollectionUri(url)) {
            throw new IllegalArgumentException("Unknown URL " + url);
        }
        
        for (String colName : getRequiredColumns()) {
            if (values.containsKey(colName) == false) {
                throw new IllegalArgumentException(
                        "Missing column: " + colName);
            }
        }

        long rowId = db.insert(ContactDbHelper.TABLE_NAME, ContactDbHelper.COL_NAME, values);
        if (rowId > 0) {
            Uri uri = ContentUris.withAppendedId(ContactDbHelper.URI_CONTENT, rowId);
            getContext().getContentResolver().notifyChange(uri, null);
            return uri;
        }

        throw new SQLException("Failed to insert row into " + url);
    }

    @Override
    public int delete(Uri url, String where, String[] whereArgs) {
        int count;
        
        if (isCollectionUri(url)) {
            count = db.delete(ContactDbHelper.TABLE_NAME, where, whereArgs);
        }
        else {
            String segment = url.getPathSegments().get(1);
            //rowId = Long.parseLong(segment);
            count = db.delete(ContactDbHelper.TABLE_NAME, ContactDbHelper._ID + "="
                    + segment
                    + (!TextUtils.isEmpty(where) ? " AND (" + where
                    + ')' : ""), whereArgs);
        }

        getContext().getContentResolver().notifyChange(url, null);
        return count;
    }

    @Override
    public int update(Uri url, ContentValues values, 
            String where, String[] whereArgs) {
        int count;
        
        if (isCollectionUri(url)) {
            count=db.update(ContactDbHelper.TABLE_NAME, values, where, whereArgs);
        }
        else {
            String segment=url.getPathSegments().get(1);
            count = db.update(ContactDbHelper.TABLE_NAME, values, ContactDbHelper._ID + "="
                    + segment
                    + (!TextUtils.isEmpty(where) ? " AND (" + where
                    + ')' : ""), whereArgs);
        }
    
        getContext().getContentResolver().notifyChange(url, null);
        return count;
    }
    
    private boolean isCollectionUri(Uri url) {
        return(mUriMatcher.match(url) == ContactDbHelper.URI_CODE);
    }
    
/*    private HashMap<String, String> getDefaultProjection() {
        return(mContactProj);
    }*/
    
    private String[] getRequiredColumns() {
        return(new String[] {ContactDbHelper.COL_NAME});
    }

    @Override
    public String getType(Uri uri) {       
        return null;
    }
}
