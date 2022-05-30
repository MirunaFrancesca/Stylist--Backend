package com.stylist.rest.webservices.restfulwebservices.service;

import com.stylist.rest.webservices.restfulwebservices.model.User;
import com.stylist.rest.webservices.restfulwebservices.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class SessionUtilsService {
    @Autowired
    private final UserRepo userJPARepository;

    public SessionUtilsService(UserRepo userJPARepository) {
        this.userJPARepository = userJPARepository;
    }

    public User getCurrentUserId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                    .getPrincipal();
            String username = userDetails.getUsername();
            String password = userDetails.getPassword();
            return this.userJPARepository.findByUsernameAndPassword(username, password);
        }
        return null;
    }
}
