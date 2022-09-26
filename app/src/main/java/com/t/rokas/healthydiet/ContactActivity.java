package com.t.rokas.healthydiet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ContactActivity extends AppCompatActivity {

    // Variables
    private EditText firstNameEditText, lastNameEditText, phoneEditText, emailEditText;
    private Button saveButton;
    private DatabaseReference databaseReference;
    private ContactMember contactMember;
    private long maxId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        // Take values by id
        firstNameEditText = (EditText) findViewById(R.id.firstNameEditText);
        lastNameEditText = (EditText) findViewById(R.id.lastNameEditText);
        phoneEditText = (EditText) findViewById(R.id.phoneEditText);
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        saveButton = (Button) findViewById(R.id.saveButton);

        // Create new contact member object
        contactMember = new ContactMember();

        // Get the reference of the database child ContactMembers, if not exists creates it
        databaseReference = FirebaseDatabase.getInstance().getReference().child("ContactMembers");

        // When database is changed makes maxId equal to the number of children
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                    maxId = (dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        // When button is clicked do something
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Local variables
                String firstName = firstNameEditText.getText().toString().trim(); // Takes value of first name field
                String lastName = lastNameEditText.getText().toString().trim(); // Takes value of last name field
                String phone = phoneEditText.getText().toString().trim(); // Takes value of phone field
                String email = emailEditText.getText().toString().trim(); // Takes value of email field

                // Check if none of the fields are empty
                if(!firstName.equals("") && !lastName.equals("") && !phone.equals("") && !email.equals("")) {
                    contactMember.setFirstName(firstName); // Set contact member first name
                    contactMember.setLastName(lastName); // Set contact member last name
                    contactMember.setPhone(phone); // Set contact member phone
                    contactMember.setEmail(email); // Set contact member email

                    // Creates a new contact member in database with id maxId + 1 and print success message
                    databaseReference.child(String.valueOf(maxId + 1)).setValue(contactMember);
                    Toast.makeText(ContactActivity.this, "Data inserted successfully", Toast.LENGTH_LONG).show();
                }
                // If one of the fields are empty
                else{
                    // if first name is empty print error message
                    if(firstName.equals("")){
                        Toast.makeText(ContactActivity.this, "First name field is required", Toast.LENGTH_SHORT).show();
                    }
                    // if last name is empty print error message
                    else if(lastName.equals("")){
                        Toast.makeText(ContactActivity.this, "Last name field is required", Toast.LENGTH_SHORT).show();
                    }
                    // if phone is empty print error message
                    else if(phone.equals("")){
                        Toast.makeText(ContactActivity.this, "Phone field is required", Toast.LENGTH_SHORT).show();
                    }
                    // if email is empty print error message
                    else if(email.equals("")){
                        Toast.makeText(ContactActivity.this, "Email field is required", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}