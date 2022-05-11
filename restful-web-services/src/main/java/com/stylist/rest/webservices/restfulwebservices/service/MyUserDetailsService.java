package com.stylist.rest.webservices.restfulwebservices.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public MyUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        com.stylist.rest.webservices.restfulwebservices.model.User userCredentials = userService.findByUsername(s);
        return new User(userCredentials.getUsername(), userCredentials.getPassword(), new ArrayList<>());
    }
}