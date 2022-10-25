package org.swagarelli.models;


public class Customer{

    // Properties
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private boolean isMember;

    // Constructors
    // No-arg constructor
    public Customer() {
        id = 0;
        firstName = "";
        lastName = "";
        email = "";
        password = "";
        address = "";
        isMember = false;
    }

    // Overloading the constructor with the parameters
    public Customer(String firstName, String lastName, String email, String password, String address, boolean isMember) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.isMember = isMember;
    }

    // Full Constructor

    public Customer(int id, String firstName, String lastName, String email, String password, String address, boolean isMember) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.isMember = isMember;
    }

    // Setters and Getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isMember() {
        return isMember;
    }

    public void setMember(boolean member) {
        isMember = member;
    }
}