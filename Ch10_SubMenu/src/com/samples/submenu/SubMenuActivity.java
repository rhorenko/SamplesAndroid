package com.samples.submenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class SubMenuActivity extends Activity {

    public static final int HELP = 101;
    
    public static final int NEW = 201;
    public static final int OPEN = 202;
    public static final int SAVE = 203;
    
    public static final int CUT = 301;
    public static final int COPY = 302;
    public static final int PASTE = 303;
    

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
              
        SubMenu subMenuFile = menu.addSubMenu("File");
        subMenuFile.add(Menu.NONE, NEW, Menu.NONE, "New");
        subMenuFile.add(Menu.NONE, OPEN, Menu.NONE, "Open");
        subMenuFile.add(Menu.NONE, SAVE, Menu.NONE, "Save");
        
        SubMenu subMenuEdit = menu.addSubMenu("Edit");
        subMenuEdit.add(Menu.NONE, CUT, Menu.NONE, "Cut");
        subMenuEdit.add(Menu.NONE, COPY, Menu.NONE, "Copy");
        subMenuEdit.add(Menu.NONE, PASTE, Menu.NONE, "Paste");
        
        menu.add(Menu.NONE, HELP, Menu.NONE, "Help");
        
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        CharSequence message;
        switch (item.getItemId()) {
            case NEW:
                message = "New item selected";
                break;
            case OPEN:
                message = "Open item selected";
                break;
            case SAVE:
                message = "Save item selected";
                break;
            case CUT:
                message = "Cut item selected";
                break;
            case COPY:
                message = "Copy item selected";
                break;
            case PASTE:
                message = "Paste item selected";
                break;
            case HELP:
                message = "Help item selected";
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