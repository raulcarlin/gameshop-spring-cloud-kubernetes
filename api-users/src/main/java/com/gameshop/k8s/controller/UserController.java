package com.gameshop.k8s.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/users")
    String[] getUsers() {
        return new String[]{};
    }

    @GetMapping("/users/{userId}")
    String getUser(@PathVariable("userId") String userId) {
        return "ID:" + userId + ", Name:" + "TEST USER";
    }
}
