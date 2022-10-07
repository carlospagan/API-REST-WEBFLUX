package dev.carlos.citiesAPI.user.services;

import dev.carlos.citiesAPI.user.models.requests.register.UserRequestRegister;
import dev.carlos.citiesAPI.user.models.responses.UserResponse;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<UserResponse> save(UserRequestRegister userRequestRegister);

}
