package com.gameshop.k8s.controller;

import com.gameshop.k8s.client.UsersClient;
import com.gameshop.k8s.config.UtilsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    @Autowired
    private UtilsConfig utils;

    @Autowired
    private UsersClient usersClient;

    @GetMapping("/carts")
    String getCarts() {
        return utils.getMessage();
    }

    @GetMapping("/carts/user/{userId}")
    String getCartForUser(@PathVariable("userId") String userId) {
        String userDetail = usersClient.getUserDetail(userId);

        return "Cart for " + userDetail + " is empty!";
    }

}
