package com.jhow.user_example_service.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequestDTO(@NotNull @NotBlank String nome,
                             @Email String email,
                             @NotNull @NotBlank String phone) {
}
