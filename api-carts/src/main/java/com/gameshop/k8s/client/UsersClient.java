package com.gameshop.k8s.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "api-users", fallback = UsersClientFallback.class)
public interface UsersClient {

    @GetMapping("/users/{userId}")
    String getUserDetail(@PathVariable("userId") String userId);

}

@Component
class UsersClientFallback implements UsersClient {

    @Override
    public String getUserDetail(String userId) {
        return "ID:" + userId + ", Name:" + "<NONE>";
    }

}


