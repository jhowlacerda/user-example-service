package com.jhow.user_example_service.domain.services.impl;

import com.jhow.user_example_service.application.dto.UserRequestDTO;
import com.jhow.user_example_service.domain.entities.User;
import com.jhow.user_example_service.domain.exceptions.UserAlreadyExistsException;
import com.jhow.user_example_service.domain.services.UserService;
import com.jhow.user_example_service.resources.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(UserRequestDTO userRequestDTO) throws UserAlreadyExistsException {
        if(userRepository.findByEmail(userRequestDTO.email()).isPresent()) {
            throw new UserAlreadyExistsException("User alread exists with email: "+ userRequestDTO.email());
        }

        var user = new User.Builder()
                .setName(userRequestDTO.nome())
                .setEmail(userRequestDTO.email())
                .setPhone(userRequestDTO.phone())
                .build();

        userRepository.save(user);
    }
}
