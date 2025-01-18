package com.algaier.MeterReading.Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "UserInformation")
public class UserInformation {

    public UserInformation(){

    }

    public UserInformation(String userGivenname, String userLastname, String user2FAKey,
                           LocalDate registriDate, LocalDateTime loginTime,
                           boolean state, String password, LocalDateTime lastLoginTime) {
        this.userGivenname = userGivenname;
        this.userLastname = userLastname;
        this.user2FAKey = user2FAKey;
        this.registriDate = registriDate;
        this.loginTime = loginTime;
        this.state = state;
        this.password = password;
        this.lastLoginTime = lastLoginTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Email")
    private String email;

    @Column(name = "UserGivenname")
    private String userGivenname;

    @Column(name = "UserLastname")
    private String userLastname;

    @Column(name = "User2FAKey")
    private String user2FAKey;

    @Column(name = "RegistriDate")
    private LocalDate registriDate;

    @Column(name = "LoginTime")
    private LocalDateTime loginTime;

    @Column(name = "State")
    private boolean state;

    @Column(name = "Password")
    private String password;

    @Column(name = "LastLoginTime")
    private LocalDateTime lastLoginTime;


    public String getUserGivenname() {
        return userGivenname;
    }

    public String getUserLastname() {
        return userLastname;
    }

    public String getUser2FAKey() {
        return user2FAKey;
    }

    public LocalDate getRegistriDate() {
        return registriDate;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public String getEmail() {
        return email;
    }

    public boolean isState() {
        return state;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public void setUserGivenname(String userGivenname) {
        this.userGivenname = userGivenname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    public void setUser2FAKey(String user2FAKey) {
        this.user2FAKey = user2FAKey;
    }

    public void setRegistriDate(LocalDate registriDate) {
        this.registriDate = registriDate;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}