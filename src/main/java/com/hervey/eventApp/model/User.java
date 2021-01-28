package com.hervey.eventApp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    @NotBlank(message = "can't be empty")
    private String username;

    @NotBlank(message = "can't be empty")
    private String email;

    private String phoneNumber;

    @NotBlank(message = "can't be empty")
    private String password;

    @NotBlank(message = "can't be empty")
    @Transient
    private String confirmPass;

//    @OneToMany(mappedBy = "user")
//    private List<Subscription> subscriptions = new ArrayList<>();

    public User() {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passWord) {
        this.password = passWord;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String confirmPassword) {
        this.confirmPass = confirmPassword;
    }
}

