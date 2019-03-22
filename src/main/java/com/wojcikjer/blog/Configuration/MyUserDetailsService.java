package com.wojcikjer.blog.Configuration;

import com.wojcikjer.blog.Configuration.MyUserPrincipal;
import com.wojcikjer.blog.Entities.User;
import com.wojcikjer.blog.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .map(user -> new MyUserPrincipal(user))
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

}
