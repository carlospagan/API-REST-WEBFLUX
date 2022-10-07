package dev.carlos.citiesAPI.user.services.implementation;

import dev.carlos.citiesAPI.user.domain.User;
import dev.carlos.citiesAPI.user.domain.UserRepository;
import dev.carlos.citiesAPI.user.models.requests.register.UserRequestRegister;
import dev.carlos.citiesAPI.user.models.responses.UserResponse;
import dev.carlos.citiesAPI.user.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Mono<UserResponse> save(UserRequestRegister userRequestRegister) {

        ModelMapper modelMapper = new ModelMapper();

        User user = modelMapper.map(userRequestRegister, User.class);

        Mono<User> userSaved$ = userRepository.save(user);

        return userSaved$.flatMap(userSaved -> {
            UserResponse userResponse = modelMapper.map(userSaved, UserResponse.class);
            return Mono.just(userResponse);
        });

    }

}
