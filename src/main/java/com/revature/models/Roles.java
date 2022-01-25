package com.revature.models;

import java.util.Objects;

public class Roles {
    private int roleId;
    private String userRole;

    public Roles() {
    }

    public Roles(int roleId, String userRole) {
        this.roleId = roleId;
        this.userRole = userRole;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Roles)) return false;
        Roles roles = (Roles) o;
        return getRoleId() == roles.getRoleId() && Objects.equals(getUserRole(), roles.getUserRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoleId(), getUserRole());
    }

    @Override
    public String toString() {
        return "Roles{" +
                "roleId=" + roleId +
                ", userRole='" + userRole + '\'' +
                '}';
    }
}
