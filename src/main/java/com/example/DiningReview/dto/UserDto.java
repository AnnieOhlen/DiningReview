package com.example.DiningReview.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {

    private Long userId;

    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters long.")
    private String username;

    private String city;

    private String state;

    private Integer zipCode;

    private boolean allergyPeanut;

    private boolean allergyEgg;

    private boolean allergyDairy;

}
