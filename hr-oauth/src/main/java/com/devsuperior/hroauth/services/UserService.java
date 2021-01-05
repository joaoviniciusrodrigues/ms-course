package com.devsuperior.hroauth.services;

import com.devsuperior.hroauth.entities.User;
import com.devsuperior.hroauth.feignclients.UserFeingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserFeingClient userFeingClient;

    public User findByEmail(String email) {
        User user = userFeingClient.findByEmail(email).getBody();

        if (user == null) {
            throw new IllegalArgumentException("Email not found");
        }

        return user;
    }
}
