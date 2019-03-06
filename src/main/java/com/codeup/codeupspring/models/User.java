package com.codeup.codeupspring.models;


//Create a User class entity with enough properties to save the id, username, email, password. Make sure the class has the necessary constructors, getters and setters.

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue
    private long id;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String password;

    public User (){
    }

    public User(long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
