package com.samples.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    
    private int mGalleryItemBackground;
    private Context mContext;

    private final Integer[] mImage = {
        R.drawable.photo1, R.drawable.photo2,
        R.drawable.photo3, R.drawable.photo4,
        R.drawable.photo5, R.drawable.photo6,
        R.drawable.photo7, R.drawable.photo8,
    };
    
    public ImageAdapter(Context c) {
        mContext = c;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView view = new ImageView(mContext);

        view.setImageResource(mImage[position]);
        view.setPadding(20,20,20,20);
        view.setLayoutParams(new Gallery.LayoutParams(140, 190));
        view.setScaleType(ImageView.ScaleType.FIT_XY);
        view.setBackgroundResource(mGalleryItemBackground);
        return view;
    }
    
    public int getCount() {
        return mImage.length;
    }

    public Object getItem(int position) {
        return mImage[position];
    }

    public long getItemId(int position) {
        return mImage[position];
    }
}
