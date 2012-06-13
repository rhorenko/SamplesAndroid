package com.samples.dbcontacts;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class ContactActivity extends ListActivity {
    private static final int IDM_ADD = 101;
    private static final int IDM_EDIT = 102;
    private static final int IDM_DELETE = 103;
    
    private Cursor mCursor; 
    private ListAdapter mAdapter;
    
    private static final String[] mContent = new String[] {
            ContactDbHelper._ID, ContactDbHelper.COL_NAME,
            ContactDbHelper.COL_PHONE};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);     
        mCursor = managedQuery(
                ContactDbHelper.URI_CONTENT, mContent, null, null, null);
        
        mAdapter = new SimpleCursorAdapter(this, 
                R.layout.row, mCursor, 
                new String[] {ContactDbHelper.COL_NAME, ContactDbHelper.COL_PHONE}, 
                new int[] {R.id.name, R.id.phone});
        setListAdapter(mAdapter);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, IDM_ADD, Menu.NONE, R.string.menu_add)
            .setIcon(R.drawable.ic_menu_add)
            .setAlphabeticShortcut('a');
        menu.add(Menu.NONE, IDM_EDIT, Menu.NONE, R.string.menu_edit)
            .setIcon(R.drawable.ic_menu_edit)
            .setAlphabeticShortcut('e');
        menu.add(Menu.NONE, IDM_DELETE, Menu.NONE, R.string.menu_delete)
            .setIcon(R.drawable.ic_menu_delete)
            .setAlphabeticShortcut('d');

        return(super.onCreateOptionsMenu(menu));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final long id = this.getSelectedItemId();
        
        switch (item.getItemId()) {
            case IDM_ADD: {
                CallAddContactDialog();
            }  
                break;
            case IDM_EDIT:
                if (id > 0) {     
                    CallEditContactDialog(id);
                }
                else {
                    Toast.makeText(this, R.string.toast_notify, Toast.LENGTH_SHORT)
                        .show();
                }
                break;
            case IDM_DELETE:
                if (id > 0) {
                    CallDeleteContactDialog(id);
                }
                else {
                    Toast.makeText(this, R.string.toast_notify, Toast.LENGTH_SHORT)
                        .show();
                }
                break;
        }
        return(super.onOptionsItemSelected(item));
    }
    
    private void CallAddContactDialog() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View root = inflater.inflate(R.layout.dialog, null);
        
        final EditText textName = (EditText)root.findViewById(R.id.name);
        final EditText textPhone = (EditText)root.findViewById(R.id.phone);
        
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setView(root);
        b.setTitle(R.string.title_add);
        b.setPositiveButton(
                R.string.btn_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                ContentValues values = new ContentValues(2);
                
                values.put(ContactDbHelper.COL_NAME, textName.getText().toString());
                values.put(ContactDbHelper.COL_PHONE, textPhone.getText().toString());
                
                getContentResolver().insert(ContactDbHelper.URI_CONTENT, values);
                mCursor.requery();
            }
        });
        b.setNegativeButton(
                R.string.btn_cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {}
        });
        b.show(); 
    }
    
    private void CallEditContactDialog(final long id) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View root = inflater.inflate(R.layout.dialog, null);
        
        final EditText textName = (EditText)root.findViewById(R.id.name);                 
        final EditText textPhone = (EditText)root.findViewById(R.id.phone);
        
        mCursor.moveToPosition(this.getSelectedItemPosition());
        textName.setText(mCursor.getString(1));
        textPhone.setText(mCursor.getString(2));
        
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setView(root);
        b.setTitle(R.string.title_edit);
        
        b.setPositiveButton(
                R.string.btn_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
              ContentValues values = new ContentValues(2);
              
              values.put(ContactDbHelper.COL_NAME, textName.getText().toString());
              values.put(ContactDbHelper.COL_PHONE, textPhone.getText().toString());
              
              getContentResolver().update(
                      ContactDbHelper.URI_CONTENT, values, "_ID=" + id, null);
              mCursor.requery();
            }
        });
        
        b.setNegativeButton(
                R.string.btn_cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {}
        });
        
        b.show(); 
    }
    
    private void CallDeleteContactDialog(final long id) {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle(R.string.title_delete);
        
        b.setPositiveButton(
                R.string.btn_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                getContentResolver().delete(
                        ContactDbHelper.URI_CONTENT, "_ID=" + id, null);
                mCursor.requery();
            }
        });
        
        b.setNegativeButton(
                R.string.btn_cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {}
        });
        
        b.show();
    }
}
