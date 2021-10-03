package com.example.demo.controller;

import com.example.demo.model.VehicleAppUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController()
public class UserInfoController {

    @GetMapping("/me")
    public String currentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String user = (String) authentication.getPrincipal();
        Collection<? extends GrantedAuthority> roles = authentication.getAuthorities();
        return user + "\n" + roles;
    }
}
