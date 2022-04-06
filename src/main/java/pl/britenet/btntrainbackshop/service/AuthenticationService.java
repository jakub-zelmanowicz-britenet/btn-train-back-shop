package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jakub.adminpanel.obj.User;
import pl.jakub.adminpanel.service.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthenticationService {

    private final Map<String, User> activeTokens;
    private final UserService userService;

    @Autowired
    public AuthenticationService(UserService userService) {
        this.activeTokens = new HashMap<>();
        this.userService = userService;
    }

    public Map<String, Object> authenticate(String username, String password) {
        Optional<User> oUser = this.userService.findUser(username, password);
        User user = oUser.orElseThrow();
        String token = UUID.randomUUID().toString();

        this.activeTokens.put(token, user);

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("user", user);
        return response;
    }

    public Optional<User> retrieveUserByToken(String token) {
        return Optional.of(this.activeTokens.get(token));
    }

    public boolean isAuthenticated(String token) {
        return this.activeTokens.containsKey(token);
    }
}
