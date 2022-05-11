package com.stylist.rest.webservices.restfulwebservices.service;


import com.stylist.rest.webservices.restfulwebservices.model.User;
import com.stylist.rest.webservices.restfulwebservices.repo.UserRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userJPARepository;

    public UserServiceImpl(UserRepo userJPARepository) {
        this.userJPARepository = userJPARepository;
    }

    @Override
    public boolean createUser(User newUser) {
        userJPARepository.save(newUser);
        return true;
    }

    @Override
    public User findByUsername(String username) {
        return userJPARepository.findByUsername(username);
    }

    @Override
    public List<User> getAll() {
        return userJPARepository.findAll();
    }
}