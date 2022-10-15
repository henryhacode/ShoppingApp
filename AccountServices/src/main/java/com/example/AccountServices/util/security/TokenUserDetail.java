package com.example.AccountServices.util.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.Jwt;

import java.security.Principal;
import java.util.Collection;

public class TokenUserDetail {
    private static Jwt jwt = (Jwt)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    public static String getEmail(){
        return jwt.getClaims().get("email").toString();
    }

    //firstName
    public static String getGivenName(){
        return jwt.getClaims().get("given_name").toString();
    }

    //lastName
    public static String getFamilyName(){
        return jwt.getClaims().get("family_name").toString();
    }
}
