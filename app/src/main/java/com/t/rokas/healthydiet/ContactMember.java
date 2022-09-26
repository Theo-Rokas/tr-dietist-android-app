package com.t.rokas.healthydiet;

public class ContactMember { // Contact member object
    // Variables
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    public ContactMember() {} // Default Constructor don't know why i put it

    public String getFirstName() {
        return firstName;
    } // First name getter

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    } // First name setter

    public String getLastName() {
        return lastName;
    } // Last name getter

    public void setLastName(String lastName) {
        this.lastName = lastName;
    } // Last name setter

    public String getPhone() {
        return phone;
    } // Phone getter

    public void setPhone(String phone) {
        this.phone = phone;
    } // Phone setter

    public String getEmail() {
        return email;
    } // Email getter

    public void setEmail(String email) {
        this.email = email;
    } // Email setter
}
