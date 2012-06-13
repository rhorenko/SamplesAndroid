package com.samples.contacteditor;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class ListContactActivity extends ListActivity {
    private static final int IDM_ADD = 101;
    private static final int IDM_EDIT = 102;
    private static final int IDM_DELETE = 103;
    private long mId = -1;

    ArrayList<ContactItem> mList;
    private ListAdapter mAdapter;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);     
        mList = new ArrayList<ContactItem>();
        fillContacts();
        updateList();
    }
    
    private void updateList() {
        mAdapter = new SimpleAdapter(this, mList, R.layout.main, 
                new String[] {ContactItem.NAME, ContactItem.PHONE}, 
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
        mId = this.getSelectedItemId();

        switch (item.getItemId()) {
            case IDM_ADD: {
                Intent intent = new Intent();
                intent.setClass(this, NewContactActivity.class);
                // эапускаем деятельнсть 
                startActivityForResult(intent, IDM_ADD);
            }  
                break;
            case IDM_EDIT:
                if (mId >= 0) { 
                    ContactItem mItem = mList.get((int)mId);
                    Intent intent = new Intent();
                    intent.putExtra(ContactItem.NAME, mItem.getName()); 
                    intent.putExtra(ContactItem.PHONE, mItem.getPhone());
                   
                    intent.setClass(this, EditContactActivity.class);  
                 // эапускаем деятельнсть 
                    startActivityForResult(intent, IDM_EDIT);
                }
                else {
                    Toast.makeText(this, R.string.toast_notify, Toast.LENGTH_SHORT)
                        .show();
                }
                break;
            case IDM_DELETE:
                if (mId >= 0) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    ContactItem mItem = mList.get((int)mId);
                    builder.setMessage(R.string.title_delete + "\n" 
                            + mItem.getName() + "\n" + mItem.getPhone());
                    builder.setPositiveButton(
                            "Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            mList.remove((int)mId);
                            updateList();
                        }
                    });
                    builder.setNegativeButton(
                            "No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                            }
                    });
                    builder.setCancelable(false);
                    builder.show();
                }
                else {
                    Toast.makeText(this, R.string.toast_notify, Toast.LENGTH_SHORT)
                        .show();
                }
                updateList();
                break;
        }
        return(super.onOptionsItemSelected(item));
    }
   
   protected void onActivityResult(
           int requestCode, int resultCode, Intent data) {
       super.onActivityResult(requestCode, resultCode, data);
       
       if (resultCode == RESULT_OK) {
           Bundle extras = data.getExtras();
           
           switch (requestCode) {
               case IDM_ADD:
                   mList.add(new ContactItem(
                           extras.getString(ContactItem.NAME), 
                           extras.getString(ContactItem.PHONE)));
                   break;
               case IDM_EDIT:
                   mList.set((int)mId, new ContactItem(
                           extras.getString(ContactItem.NAME), 
                           extras.getString(ContactItem.PHONE)));
                   break;
           }
           updateList();
       }
   }
    
    public void fillContacts() {
        mList.add(new ContactItem("Jacob Anderson", "412412411"));
        mList.add(new ContactItem("Emily Duncan", "161863187"));
        mList.add(new ContactItem("Michael Fuller", "896443658"));
        mList.add(new ContactItem("Emma Greenman", "964990543"));
        mList.add(new ContactItem("Joshua Harrison", "759285086"));
        mList.add(new ContactItem("Madison Johnson", "950285777"));
        mList.add(new ContactItem("Matthew Cotman", "687699999"));
        mList.add(new ContactItem("Olivia Lawson", "161863187"));
        mList.add(new ContactItem("Andrew Chapman",  "546599645"));
        mList.add(new ContactItem("Daniel Honeyman", "876545644"));
        mList.add(new ContactItem("Isabella Jackson", "907868756"));
        mList.add(new ContactItem("William Patterson", "687699693"));
        mList.add(new ContactItem("Joseph Godwin", "965467575"));
        mList.add(new ContactItem("Samantha Bush", "907865645"));
        mList.add(new ContactItem("Christopher Gateman", "896874556"));
    }
}
