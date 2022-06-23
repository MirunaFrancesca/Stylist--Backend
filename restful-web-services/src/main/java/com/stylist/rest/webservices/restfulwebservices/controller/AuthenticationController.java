package com.stylist.rest.webservices.restfulwebservices.controller;

import com.stylist.rest.webservices.restfulwebservices.config.JwtUtils;
import com.stylist.rest.webservices.restfulwebservices.dto.AuthRequestDTO;
import com.stylist.rest.webservices.restfulwebservices.dto.AuthResponseDTO;
import com.stylist.rest.webservices.restfulwebservices.model.User;
import com.stylist.rest.webservices.restfulwebservices.service.MyUserDetailsService;
import com.stylist.rest.webservices.restfulwebservices.service.UserService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final UserService userService;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public boolean registerUser(@RequestBody User newUser){
        return userService.createUser(newUser);
    }


    @PostMapping("/login")
    public AuthResponseDTO authenticate(@RequestBody AuthRequestDTO requestDTO) throws Exception {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            requestDTO.getUsername(),
                            requestDTO.getPassword()
                    )
            );
        } catch (BadCredentialsException e){
            throw new Exception("Invalid credentials", e);
        }

        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(requestDTO.getUsername());

        final String token = jwtUtils.generateToken(requestDTO.getUsername());

        return new AuthResponseDTO(token);
    }

    @GetMapping("/checkToken")
    public Boolean checkToken(@RequestParam("token") String token) {
        try {
            return !jwtUtils.isTokenExpired(token);
        }
        catch(ExpiredJwtException e) {
            System.out.println("run into exception");
            return false;
        }
    }
}
