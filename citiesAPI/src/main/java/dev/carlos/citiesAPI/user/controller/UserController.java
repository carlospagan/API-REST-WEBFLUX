package dev.carlos.citiesAPI.user.controller;

import dev.carlos.citiesAPI.user.domain.User;
import dev.carlos.citiesAPI.user.domain.UserRepository;
import dev.carlos.citiesAPI.user.models.requests.login.UserRequestLogin;
import dev.carlos.citiesAPI.user.models.requests.register.UserRequestRegister;
import dev.carlos.citiesAPI.user.models.requests.update.UserUpdate;
import dev.carlos.citiesAPI.user.models.responses.UserResponse;
import dev.carlos.citiesAPI.user.models.responses.UserResponseLogin;
import dev.carlos.citiesAPI.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public Flux<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userEmail}")
    public Mono<UserResponse> getUserByUserEmail(@PathVariable String userEmail) {
        return userService.findByEmail(userEmail);
    }

    @PostMapping
    public Mono<UserResponse> createUser(@RequestBody UserRequestRegister userRequestRegister){
        return userService.save(userRequestRegister);
    }

    @PostMapping("/login")
    public Mono<UserResponseLogin> login(@RequestBody UserRequestLogin userRequestLogin){
        return userService.userLogin(userRequestLogin);
    }

    @PutMapping("/updateUser")
    public Mono<UserResponse> updateUser(@RequestBody UserUpdate userUpdate) {
        return userService.updateUser(userUpdate);
    }
}
