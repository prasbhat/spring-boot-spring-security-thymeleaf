package com.example.ppb.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int systemRoleId;

    @Column(unique = true)
    private String role;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "roles")
    private Set<UserRole> userRole = new HashSet<>();

    public int getSystemRoleId() {
        return systemRoleId;
    }

    public void setSystemRoleId(int systemRoleId) {
        this.systemRoleId = systemRoleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<UserRole> userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "systemRoleId=" + systemRoleId +
                ", role='" + role + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
