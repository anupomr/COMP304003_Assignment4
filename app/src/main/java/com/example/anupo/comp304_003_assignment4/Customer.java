package com.example.anupo.comp304_003_assignment4;

public class Customer
{
    int id;
    String username,  password,  fName,  lName,  address,  postalCode,  city;

    public Customer() {
    }
    public Customer(int id, String username, String password, String fName, String lName, String address, String postalCode, String city)
    {
        this.id=id;
        this.username=username;
        this.password=password;
        this.fName=fName;
        this.lName=lName;
        this.address=address;
        this.postalCode=postalCode;
        this.city=city;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
