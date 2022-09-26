package com.t.rokas.healthydiet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class FullScreenActivity extends AppCompatActivity {

    // Variables
    private ImageView fullScreenImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);

        // Take value by id
        fullScreenImageView = findViewById(R.id.fullScreenImageView);

        // Hide the bar on the top
        getSupportActionBar().hide();

        // Gets the intent back
        Intent intent = getIntent();

        // Local variable takes value of intent extra named id
        int position = intent.getExtras().getInt("id");

        // Create new image adapter object
        ImageAdapter imageAdapter = new ImageAdapter(this);

        // Shows the photo of the given position value
        fullScreenImageView.setImageResource(imageAdapter.photosArray[position]);
    }
}