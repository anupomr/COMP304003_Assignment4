package com.example.anupo.comp304_003_assignment4;

public class Admin
{
    int employeeId;
    String userName,password, fName, lName;
    public Admin()
    {
    }

    public Admin(int employeeId, String userName, String password, String fName, String lName) {
        this.employeeId = employeeId;
        this.userName = userName;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
}
