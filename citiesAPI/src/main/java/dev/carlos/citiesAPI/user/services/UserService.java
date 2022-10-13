package dev.carlos.citiesAPI.user.services;

import dev.carlos.citiesAPI.user.domain.User;
import dev.carlos.citiesAPI.user.models.requests.login.UserRequestLogin;
import dev.carlos.citiesAPI.user.models.requests.register.UserRequestRegister;
import dev.carlos.citiesAPI.user.models.requests.update.UserUpdate;
import dev.carlos.citiesAPI.user.models.responses.UserResponse;
import dev.carlos.citiesAPI.user.models.responses.UserResponseLogin;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<UserResponse> save(UserRequestRegister userRequestRegister);
    Mono<UserResponse> findByEmail(String userEmail);
    Flux<User> getAllUsers();
    Mono<UserResponse> updateUser(UserUpdate userUpdate);
    Mono<UserResponseLogin> userLogin(UserRequestLogin userRequestLogin);

}
