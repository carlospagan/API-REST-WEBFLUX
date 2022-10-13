package dev.carlos.citiesAPI.user.services.implementation;

import dev.carlos.citiesAPI.user.domain.User;
import dev.carlos.citiesAPI.user.domain.UserRepository;
import dev.carlos.citiesAPI.user.models.requests.login.UserRequestLogin;
import dev.carlos.citiesAPI.user.models.requests.register.UserRequestRegister;
import dev.carlos.citiesAPI.user.models.requests.update.UserUpdate;
import dev.carlos.citiesAPI.user.models.responses.UserResponse;
import dev.carlos.citiesAPI.user.models.responses.UserResponseLogin;
import dev.carlos.citiesAPI.user.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Mono<UserResponse> findByEmail(String userEmail) {
        ModelMapper modelMapper = new ModelMapper();
        Mono<User> user$ = userRepository.findByuserEmail(userEmail);
        return user$.flatMap(user -> {
            UserResponse userFound = modelMapper.map(user, UserResponse.class);
            return Mono.just(userFound);
        });
    }

    @Override
    public Mono<UserResponse> save(UserRequestRegister userRequestRegister) {
        ModelMapper modelMapper = new ModelMapper();
        return userRepository.findByuserEmail(userRequestRegister.getUserEmail())
                .flatMap(user -> {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
                })
                .switchIfEmpty(Mono.defer(() -> {
                    User userToSave = modelMapper.map(userRequestRegister, User.class);
                    return userRepository.save(userToSave);
                }))
                .map(user -> modelMapper.map(user, UserResponse.class));
    }

    public Flux<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Mono<UserResponse> updateUser(UserUpdate userUpdate) {
        ModelMapper modelMapper = new ModelMapper();
        return userRepository.findByuserToken(userUpdate.getUserToken())
                .switchIfEmpty(Mono.defer(() -> {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
                }))
                .map(user -> {
                    user.setUserName(userUpdate.getUserName());
                    userRepository.save(user).subscribe();
                    return modelMapper.map(user, UserResponse.class);
                });
    }

    public Mono<UserResponseLogin> userLogin(UserRequestLogin userRequestLogin) {
        ModelMapper modelMapper = new ModelMapper();
        return userRepository.findByuserEmail(userRequestLogin.getUserEmail())
                .switchIfEmpty(Mono.defer(() -> {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
                }))
                .flatMap(user -> {
                    if (user.getUserPassword().equals(userRequestLogin.getUserPassword())) {
                        user.setUserToken(UUID.randomUUID().toString());
                        user.setOnline(true);
                        return userRepository.save(user).flatMap(userSaved -> {
                            UserResponseLogin userResponseLogin = modelMapper.map(userSaved, UserResponseLogin.class);
                            return Mono.just(userResponseLogin);
                        });
                    } else {
                        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
                    }
                });
    }
}
