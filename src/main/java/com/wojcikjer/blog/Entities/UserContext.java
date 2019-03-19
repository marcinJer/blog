package com.wojcikjer.blog.Entities;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserContext {

    public Optional<User> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)) {
            MyUserPrincipal principal = (MyUserPrincipal) authentication.getPrincipal();

            return principal.getUser();
        } throw new RuntimeException("User not found");
    }
}
