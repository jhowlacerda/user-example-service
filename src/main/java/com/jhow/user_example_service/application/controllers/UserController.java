package com.jhow.user_example_service.application.controllers;

import com.jhow.user_example_service.application.dto.UserRequestDTO;
import com.jhow.user_example_service.domain.exceptions.UserAlreadyExistsException;
import com.jhow.user_example_service.domain.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity create(@ResponseBody UserRequestDTO userRequestDTO) throws UserAlreadyExistsException {
        userService.create(userRequestDTO);
        return null;
    }
}
