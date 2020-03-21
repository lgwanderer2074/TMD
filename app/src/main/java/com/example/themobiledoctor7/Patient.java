package com.example.themobiledoctor7;

public class Patient {
    private String fullname;
    private String email;
    private String password;
    private String ID;

    public Patient(String fName, String sName, String phoneN, String fullname, String email, String password) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.ID = ID;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", ID='" + ID + '\'' +
                '}';
    }
}
