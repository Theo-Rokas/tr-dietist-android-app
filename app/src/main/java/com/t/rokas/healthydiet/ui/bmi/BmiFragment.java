package com.t.rokas.healthydiet.ui.bmi;

import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.t.rokas.healthydiet.R;

public class BmiFragment extends Fragment {

    private BmiViewModel mViewModel;

    // Variables
    private Activity referenceActivity;
    private View parentHolder;
    private Spinner genderSpinner;
    private EditText weightEditText, heightEditText;
    private Button calculateButton;

    public static BmiFragment newInstance() {
        return new BmiFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        referenceActivity = getActivity(); // Get the current activity we are in
        parentHolder = inflater.inflate(R.layout.bmi_fragment, container, false); // Is the view that will be returned

        // Take values by id
        genderSpinner = (Spinner) parentHolder.findViewById(R.id.genderSpinner);
        weightEditText = (EditText) parentHolder.findViewById(R.id.weightEditText);
        heightEditText = (EditText) parentHolder.findViewById(R.id.heightEditText);
        calculateButton = (Button) parentHolder.findViewById(R.id.calculateButton);

        // When button is clicked do something
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Local variables
                String gender = genderSpinner.getSelectedItem().toString(); // Takes selected value of spinner
                float weight;
                float height;
                float bmi;

                // Check if spinner is man and the two fields are not empty
                if(gender.equals("Male") && !weightEditText.getText().toString().equals("") && !heightEditText.getText().toString().equals("")) {
                    weight = Float.parseFloat(weightEditText.getText().toString()); // Takes value of weight field
                    height = Float.parseFloat(heightEditText.getText().toString()); // Takes value of height field
                    bmi = weight / (height * height); // Calculates bmi

                    // Check in which category the bmi belongs and print message
                    if(bmi < 19.5) {
                        Toast.makeText(referenceActivity, "Your bmi is " + bmi +  " so you are scrawny", Toast.LENGTH_LONG).show();
                    }
                    else if(bmi < 24.9) {
                        Toast.makeText(referenceActivity, "Your bmi is " + bmi +  " so you are normal", Toast.LENGTH_LONG).show();
                    }
                    else if(bmi < 29.9) {
                        Toast.makeText(referenceActivity, "Your bmi is " + bmi +  " so you are 1st level obese", Toast.LENGTH_LONG).show();
                    }
                    else if(bmi < 41) {
                        Toast.makeText(referenceActivity, "Your bmi is " + bmi +  " so you are 2nd level obese", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(referenceActivity, "Your bmi is " + bmi +  " so you are 3rd level obese", Toast.LENGTH_LONG).show();
                    }
                }
                // Check if spinner is woman and the two fields are not empty
                else if(gender.equals("Female") && !weightEditText.getText().toString().equals("") && !heightEditText.getText().toString().equals("")) {
                    weight = Float.parseFloat(weightEditText.getText().toString()); // Takes value of weight field
                    height = Float.parseFloat(heightEditText.getText().toString()); // Takes value of height field
                    bmi = weight / (height * height); // Calculates bmi

                    // Check in which category the bmi belongs and print message
                    if(bmi < 18.5) {
                        Toast.makeText(referenceActivity, "Your bmi is " + bmi +  " so you are scrawny", Toast.LENGTH_LONG).show();
                    }
                    else if(bmi < 23.5) {
                        Toast.makeText(referenceActivity, "Your bmi is " + bmi +  " so you are normal", Toast.LENGTH_LONG).show();
                    }
                    else if(bmi < 28.6) {
                        Toast.makeText(referenceActivity, "Your bmi is " + bmi +  " so you are 1st level obese", Toast.LENGTH_LONG).show();
                    }
                    else if(bmi < 41) {
                        Toast.makeText(referenceActivity, "Your bmi is " + bmi +  " so you are 2nd level obese", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(referenceActivity, "Your bmi is " + bmi +  " so you are 3rd level obese", Toast.LENGTH_LONG).show();
                    }
                }
                // If one or both fields are empty
                else {
                    // If weight field is empty print error message
                    if(weightEditText.getText().toString().equals("")){
                        Toast.makeText(referenceActivity, "Weight field is required", Toast.LENGTH_SHORT).show();
                    }
                    // If height field is empty print error message
                    else if(heightEditText.getText().toString().equals("")){
                        Toast.makeText(referenceActivity, "Height field is required", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        return parentHolder; // Return the view as told before
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(BmiViewModel.class);
        // TODO: Use the ViewModel\
    }
}