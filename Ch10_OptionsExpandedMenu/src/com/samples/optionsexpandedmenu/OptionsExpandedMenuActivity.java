package com.samples.optionsexpandedmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class OptionsExpandedMenuActivity extends Activity {
    public static final int OPEN = 101;
    public static final int SAVE = 102;
    public static final int EDIT = 103;
    public static final int HELP = 104;
    public static final int EXIT = 105;
    public static final int FIND_REPLACE = 106;
    public static final int FIND_NEXT = 107;
    public static final int FIND_PREV = 108;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, OPEN, Menu.NONE, "Open")
            .setIcon(R.drawable.ic_menu_open);
        menu.add(Menu.NONE, SAVE, Menu.NONE, "Save")
            .setIcon(R.drawable.ic_menu_save);
        menu.add(Menu.NONE, EDIT, Menu.NONE, "Edit")
            .setIcon(R.drawable.ic_menu_edit);
        menu.add(Menu.NONE, HELP, Menu.NONE, "Help")
            .setIcon(R.drawable.ic_menu_help);
        menu.add(Menu.NONE, EXIT, Menu.NONE, "Exit")
            .setIcon(R.drawable.ic_menu_exit);
        menu.add(Menu.NONE, FIND_REPLACE, Menu.NONE, "Find/Replace");
        menu.add(Menu.NONE, FIND_NEXT, Menu.NONE, "Find Next");
        menu.add(Menu.NONE, FIND_PREV, Menu.NONE, "Find Previous");
        return(super.onCreateOptionsMenu(menu));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        CharSequence message;
        switch (item.getItemId()) {
            case OPEN:
                message = "Open item selected";
                break;
            case SAVE:
                message = "Save item selected";
                break;
            case HELP:
                message = "Help item selected";
                break;
            case EDIT:
                message = "Edit item selected";
                break;
            case EXIT:
                message = "Exit item selected";
                break;
            case FIND_REPLACE:
                message = "Find/Replace item selected";
                break;
            case FIND_NEXT:
                message = "Find Next item selected";
                break;
            case FIND_PREV:
                message = "Find Previous item selected";
                break;
            default:
                return false;
        }
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        return true;
    }
}