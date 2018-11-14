/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal;

import java.time.LocalDate;

/**
 *
 * @author Sarthak
 */
public class User {

    private long customerID;
    private LocalDate DOB;
    private String fName;
    private String lName;
    private String username;
    private String password;
    private String address;
    private String email;
    private String mobile;
    private int pinCode;

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }
    
    public void setLName(String lName) {
        this.lName = lName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
     public void setPassword(String password) {
        this.password = password;
    }
     
     public void setUsername(String username) {
        this.username = username;
    }

    public long getCustomerID() {
        return customerID;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public String getFName() {
        return fName;
    }
    
    public String getLName() {
        return lName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public int getPinCode() {
        return pinCode;
    }

     public String getPassword() {
        return password;
    }
     
     public String getUsername() {
       return username;
    }
     
}
