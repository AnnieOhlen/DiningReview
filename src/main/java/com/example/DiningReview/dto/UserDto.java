package com.example.DiningReview.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {

    private Long userId;

    @Size(min=3, max=20, message="Username must be between 3 and 20 characters long.")
    private String username;

    @NotBlank(message="City is required.")
    private String city;

    @NotBlank(message="State is required.")
    private String state;

    @NotNull(message="Zip code must not be null.")
    @NotBlank(message="Zip code is required.")
    private Integer zipCode;

    private boolean allergyPeanut;

    private boolean allergyEgg;

    private boolean allergyDairy;

}
