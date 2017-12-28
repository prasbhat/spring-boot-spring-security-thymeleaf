package com.example.ppb.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int systemUserId;

    @Column(unique = true)
    private String emailId;
    private String password;
    private String enabled;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "users")
    private Set<UserRole> userRole = new HashSet<>();

    public int getSystemUserId() {
        return systemUserId;
    }

    public void setSystemUserId(int systemUserId) {
        this.systemUserId = systemUserId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public Set<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<UserRole> userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "Users{" +
                "systemUserId=" + systemUserId +
                ", emailId='" + emailId + '\'' +
                ", password='" + password + '\'' +
                ", enabled='" + enabled + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
