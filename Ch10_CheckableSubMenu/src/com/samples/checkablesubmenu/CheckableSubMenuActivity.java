package com.samples.checkablesubmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class CheckableSubMenuActivity extends Activity {

    public static final int HELP = 101;
    
    public static final int COLOR_MENU_GROUP = 200;
    public static final int RED = 201;
    public static final int GREEN = 202;
    public static final int BLUE = 203;
    
    public static final int FONT_MENU_GROUP = 300;
    public static final int REGULAR = 301;
    public static final int BOLD = 302;
    public static final int ITALIC = 303;
    

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
              
        SubMenu subMenuFile = menu.addSubMenu("Color");
        subMenuFile.add(COLOR_MENU_GROUP, RED, Menu.NONE, "Red");
        subMenuFile.add(COLOR_MENU_GROUP, GREEN, Menu.NONE, "Green");
        subMenuFile.add(COLOR_MENU_GROUP, BLUE, Menu.NONE, "Blue");
        subMenuFile.setGroupCheckable(COLOR_MENU_GROUP, true, false);
        
        SubMenu subMenuEdit = menu.addSubMenu("Font Style");
        subMenuEdit.add(FONT_MENU_GROUP, REGULAR, Menu.NONE, "Regular")
            .setChecked(true);
        subMenuEdit.add(FONT_MENU_GROUP, BOLD, Menu.NONE, "Bold");
        subMenuEdit.add(FONT_MENU_GROUP, ITALIC, Menu.NONE, "Italic");
        subMenuEdit.setGroupCheckable(FONT_MENU_GROUP, true, true);
        
        menu.add(Menu.NONE, HELP, Menu.NONE, "Help");
        
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        CharSequence message;
        switch (item.getItemId()) {
            case RED:
                item.setChecked(!item.isChecked());
                message = "Red item selected";
                break;
            case GREEN:
                item.setChecked(!item.isChecked());
                message = "Green item selected";
                break;
            case BLUE:
                item.setChecked(!item.isChecked());
                message = "Blue item selected";
                break;
            case REGULAR:
                item.setChecked(true);
                message = "Regular item selected";
                break;
            case BOLD:
                item.setChecked(true);
                message = "Bold item selected";
                break;
            case ITALIC:
                item.setChecked(true);
                message = "Italic item selected";
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