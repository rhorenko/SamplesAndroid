package com.samples.customdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomDialogActivity extends Activity {
    
    private final static int IDD_CUSTOM = 0;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final Button callButton = (Button)findViewById(R.id.button);
        
        // добавляем слушатель события для кнопки вызова диалога
        callButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(IDD_CUSTOM);  
            }  
        });
    }
    
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
        case IDD_CUSTOM:
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(
                R.layout.custom_layout, (ViewGroup)findViewById(R.id.toast_layout));

            TextView text = (TextView)layout.findViewById(R.id.text);
            text.setText("Are you sure you want to exit?");
            ImageView image = (ImageView) layout.findViewById(R.id.image);
            image.setImageResource(R.drawable.android3d);

            
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(layout);
            builder.setMessage("This is a custom dialog!");
            
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    CustomDialogActivity.this.finish();
                }
            });
            
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                    }
            });
            
            builder.setCancelable(false);
            return builder.create();
        default:
        return null;
        }
    }
}