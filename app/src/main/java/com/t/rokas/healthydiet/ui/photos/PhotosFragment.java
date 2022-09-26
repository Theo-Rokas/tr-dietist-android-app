package com.t.rokas.healthydiet.ui.photos;

import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.t.rokas.healthydiet.FullScreenActivity;
import com.t.rokas.healthydiet.ImageAdapter;
import com.t.rokas.healthydiet.R;


public class PhotosFragment extends Fragment {

    private PhotosViewModel mViewModel;

    // Variables
    private Activity referenceActivity;
    private View parentHolder;
    private GridView photosGridView;

    public static PhotosFragment newInstance() {
        return new PhotosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        referenceActivity = getActivity(); // Get the current activity we are in
        parentHolder = inflater.inflate(R.layout.photos_fragment, container, false); // Is the view that will be returned

        // Take value by id
        photosGridView = (GridView) parentHolder.findViewById(R.id.photosGridView);

        // Set it as an image adapter
        photosGridView.setAdapter(new ImageAdapter(referenceActivity));

        // When photo is clicked do something
        photosGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(referenceActivity.getApplicationContext(), FullScreenActivity.class); // Creates an  intent from this class to FullScreenActivity
                intent.putExtra("id",position); // Put an extra named id with position as value
                startActivity(intent); // Start the intent
            }
        });

        return parentHolder; // Return the view as told before
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(PhotosViewModel.class);
        // TODO: Use the ViewModel
    }

}