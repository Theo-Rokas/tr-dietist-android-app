package com.t.rokas.healthydiet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter { // Image adapter object extends base adapter

    // Variable
    private Context mContext;

    // Array of photos
    public int[] photosArray = {
            R.drawable.photo1, R.drawable.photo2,
            R.drawable.photo3, R.drawable.photo4,
            R.drawable.photo5, R.drawable.photo6,
            R.drawable.photo7, R.drawable.photo8
    };

    public ImageAdapter(Context mContext) {
        this.mContext = mContext;
    } // Returns context

    @Override
    public int getCount() {
        return photosArray.length;
    } // Returns photos array length

    @Override
    public Object getItem(int position) {
        return photosArray[position];
    } // Returns specific photo

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext); // Creates image view with context
        imageView.setImageResource(photosArray[position]); // Set specific image by position value
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP); // Scale image at the center
        imageView.setLayoutParams(new GridView.LayoutParams(350, 350)); // Set photos array to grid layout
        return imageView;
    }
}