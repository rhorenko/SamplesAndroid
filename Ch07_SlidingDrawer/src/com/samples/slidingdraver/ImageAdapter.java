package com.samples.slidingdraver;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    
    private Context mContext;
    private Integer[] mImages = {
            R.drawable.ic_launcher_allhide,
            R.drawable.ic_launcher_android,
            R.drawable.ic_launcher_browser,
            R.drawable.ic_launcher_calculator,
            R.drawable.ic_launcher_calendar,
            R.drawable.ic_launcher_camera,
            R.drawable.ic_launcher_contacts,
            R.drawable.ic_launcher_email,
            R.drawable.ic_launcher_email_generic,
            R.drawable.ic_launcher_gallery,
            R.drawable.ic_launcher_google_talk,
            R.drawable.ic_launcher_home,
            R.drawable.ic_launcher_im,
            R.drawable.ic_launcher_maps,
            R.drawable.ic_launcher_musicplayer_2,
            R.drawable.ic_launcher_phone_dialer
    };
    
    public ImageAdapter(Context c) {
        mContext = c;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } 
        else {
            imageView = (ImageView)convertView;
        }

        imageView.setImageResource(mImages[position]);
        return imageView;
    }
    
    public int getCount() {
        return mImages.length;
    }

    public Object getItem(int position) {
        return mImages[position];
    }

    public long getItemId(int position) {
        return mImages[position];
    }
}
