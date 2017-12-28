package com.example.ppb.service;

import com.example.ppb.model.UserRole;
import com.example.ppb.model.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class MyUserPrincipal implements UserDetails {

    private static final long serialVersionUID = 1L;

    private Users users;
    public MyUserPrincipal(Users users) {
        this.users = users;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final List<GrantedAuthority> authorities = new ArrayList<>();
        for ( UserRole privilege : users.getUserRole()) {
            authorities.add(new SimpleGrantedAuthority(privilege.getRoles().getRole()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return users.getPassword();
    }

    @Override
    public String getUsername() {
        return users.getEmailId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Users getUsers() {
        return users;
    }
}
