package com.lsq.sudoku.pojo;

public class User {
    private String email;
    private String password;
    private String name;
    private String confirmname;
    public User() {
    }

    public User(String email, String password, String name, String confirmname) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.confirmname = confirmname;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConfirmname() {
        return confirmname;
    }

    public void setConfirmname(String confirmname) {
        this.confirmname = confirmname;
    }
}
