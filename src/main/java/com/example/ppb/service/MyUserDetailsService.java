package com.example.ppb.service;

import com.example.ppb.model.Users;
import com.example.ppb.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UsersRepository usersRepository;

    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepository.findByEmailId(username);
        if (null == users) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(users);
    }
}
