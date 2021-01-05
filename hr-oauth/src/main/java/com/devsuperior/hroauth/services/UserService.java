package com.devsuperior.hroauth.services;

import com.devsuperior.hroauth.entities.User;
import com.devsuperior.hroauth.feignclients.UserFeingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserFeingClient userFeingClient;

    public User findByEmail(String email) {
        User user = userFeingClient.findByEmail(email).getBody();

        if (user == null) {
            throw new IllegalArgumentException("Email not found");
        }

        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userFeingClient.findByEmail(userName).getBody();

        if (user == null) {
            throw new UsernameNotFoundException("Email not found");
        }

        return user;
    }
}
