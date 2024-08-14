package com.jhow.user_example_service.domain.services;

import com.jhow.user_example_service.application.dto.UserRequestDTO;
import com.jhow.user_example_service.domain.exceptions.UserAlreadyExistsException;

public interface UserService {

    void create(UserRequestDTO userRequestDTO) throws UserAlreadyExistsException;
}
