package com.example.loginpage;

public class storingdata {
    String name,username,password,email,phoneno;

    public storingdata() {
    }

    public storingdata(String name, String username, String password, String email, String phoneno) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneno = phoneno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }
}
