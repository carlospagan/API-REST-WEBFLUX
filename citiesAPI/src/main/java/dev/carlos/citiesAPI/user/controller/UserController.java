package dev.carlos.citiesAPI.user.controller;

import dev.carlos.citiesAPI.user.domain.User;
import dev.carlos.citiesAPI.user.models.requests.login.UserRequestLogin;
import dev.carlos.citiesAPI.user.models.requests.register.UserRequestRegister;
import dev.carlos.citiesAPI.user.models.responses.UserResponse;
import dev.carlos.citiesAPI.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUserById(){
        return "Hello World";
    }

    @PostMapping
    public Mono<UserResponse> createUser(@RequestBody UserRequestRegister userRequestRegister){
        return userService.save(userRequestRegister);
    }

    @PutMapping
    public String updateUser(){
        return "Updated";
    }
}
