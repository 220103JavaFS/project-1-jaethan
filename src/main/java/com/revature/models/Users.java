package com.revature.models;

import java.util.Objects;

public class Users {
    private int userId;
    private String username;
    private String password;
    private String userFirstName;
    private String userLastName;
    private String email;
    private Roles roleId;

    public Users() {
    }

    public Users(int userId, String username, String password, String userFirstName, String userLastName, String email, Roles roleId) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.email = email;
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Roles getRoleId() {
        return roleId;
    }

    public void setRoleId(Roles roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return getUserId() == users.getUserId() && Objects.equals(getUsername(), users.getUsername()) && Objects.equals(getPassword(), users.getPassword()) && Objects.equals(getUserFirstName(), users.getUserFirstName()) && Objects.equals(getUserLastName(), users.getUserLastName()) && Objects.equals(getEmail(), users.getEmail()) && Objects.equals(getRoleId(), users.getRoleId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getUsername(), getPassword(), getUserFirstName(), getUserLastName(), getEmail(), getRoleId());
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", email='" + email + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}