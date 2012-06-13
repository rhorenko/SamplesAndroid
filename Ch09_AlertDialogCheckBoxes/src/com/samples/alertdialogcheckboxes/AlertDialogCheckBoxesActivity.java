package com.samples.alertdialogcheckboxes;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class AlertDialogCheckBoxesActivity extends Activity {
    
    private final static int IDD_COLOR = 0;
    final CharSequence[] mColors = {"Red", "Green", "Blue"};
    final boolean[] mCheckedItems = {true, false, false};
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final Button callButton = (Button)findViewById(R.id.button);
        
        // добавляем слушатель события для кнопки вызова диалога
        callButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(IDD_COLOR);  
            }  
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
        case IDD_COLOR:
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Pick a color");
            
            builder.setMultiChoiceItems(mColors, mCheckedItems, new DialogInterface.OnMultiChoiceClickListener() {      
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    mCheckedItems[which] = isChecked;
                }
            });
            
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    StringBuilder state = new StringBuilder();
                    for (int i = 0; i < mColors.length; i++) {
                        state.append("Color: " + mColors[i] + ", state: ");
                        if (mCheckedItems[i])
                            state.append("checked\n");
                        else
                            state.append("unchecked\n");
                    }
                    Toast.makeText(getApplicationContext(), 
                            state.toString(), Toast.LENGTH_LONG).show();
                }
            });
            
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                    Toast.makeText(getApplicationContext(), "Dialog cancel", Toast.LENGTH_SHORT).show();
                    }
            });
            
            builder.setCancelable(false);
            return builder.create();
        default:
        return null;
        }
    }
}