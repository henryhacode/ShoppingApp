package com.example.ProductServices.util.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.Jwt;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

public class TokenUserDetail {
    public static String getEmail(){
        try {
            Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return jwt.getClaims().get("email").toString();
        }catch (Exception e){
            return "";
        }
    }

    //firstName
    public static String getGivenName(){
        try {
            Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return jwt.getClaims().get("given_name").toString();
        }catch (Exception e){
            return "";
        }
    }

    //lastName
    public static String getFamilyName(){
        try {
            Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return jwt.getClaims().get("family_name").toString();
        }catch (Exception e){
            return "";
        }
    }

    //has role USER
    public static boolean hasRoleUser(){
        try {
            Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            List<String> roles = (List<String>) jwt.getClaims().get("roles");
            if (roles == null || roles.size() == 0) {
                return false;
            }
            return roles.contains("USER");
        }catch (Exception e){
            return false;
        }
    }

    //has role ADMIN
    public static boolean hasRoleAdmin(){
        try {
            Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            List<String> roles = (List<String>) jwt.getClaims().get("roles");
            if (roles == null || roles.size() == 0) {
                return false;
            }
            return roles.contains("ADMIN");
        }catch (Exception e){
            return false;
        }
    }


}
