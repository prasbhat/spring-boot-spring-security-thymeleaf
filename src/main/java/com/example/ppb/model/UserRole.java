package com.example.ppb.model;

import javax.persistence.*;

@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int systemUserRoleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emailId", referencedColumnName = "emailId", nullable = false)
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role", referencedColumnName = "role", nullable = false)
    private Roles roles;

    public int getSystemUserRoleId() {
        return systemUserRoleId;
    }

    public void setSystemUserRoleId(int systemUserRoleId) {
        this.systemUserRoleId = systemUserRoleId;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "systemUserRoleId=" + systemUserRoleId +
                ", users=" + users +
                ", roles=" + roles +
                '}';
    }
}
