package com.samples.optionsiconmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class OptionsIconMenuActivity extends Activity {
	
	public static final int IDM_OPEN = 101;
	public static final int IDM_SAVE = 102;
	public static final int IDM_EDIT = 103;
	public static final int IDM_HELP = 104;
	public static final int IDM_EXIT = 105;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(Menu.NONE, IDM_OPEN, Menu.NONE, "Open")
			.setIcon(R.drawable.ic_menu_open);
		menu.add(Menu.NONE, IDM_SAVE, Menu.NONE, "Save")
			.setIcon(R.drawable.ic_menu_save);
		menu.add(Menu.NONE, IDM_EDIT, Menu.NONE, "Edit")
			.setIcon(R.drawable.ic_menu_edit);
		menu.add(Menu.NONE, IDM_HELP, Menu.NONE, "Help")
		.setIcon(R.drawable.ic_menu_help);
		menu.add(Menu.NONE, IDM_EXIT, Menu.NONE, "Exit")
			.setIcon(R.drawable.ic_menu_exit);

		return(super.onCreateOptionsMenu(menu));
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		CharSequence message;
		switch (item.getItemId()) {
			case IDM_OPEN:
				message = "Open item selected";
				break;
			case IDM_SAVE:
				message = "Save item selected";
				break;
			case IDM_HELP:
				message = "Help item selected";
				break;
			case IDM_EDIT:
				message = "Edit item selected";
				break;
			case IDM_EXIT:
				message = "Exit item selected";
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