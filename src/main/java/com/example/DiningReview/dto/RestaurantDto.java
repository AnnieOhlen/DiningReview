package com.example.DiningReview.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class RestaurantDto {

    private Long restaurantId;

    @NotBlank(message="Restaurant name is required.")
    private String restaurantName;

    @Min(value = 1, message = "Score must be at least 1")
    @Max(value = 5, message = "Score must be at most 5")
    private Integer scorePeanut;

    @Min(value = 1, message = "Score must be at least 1")
    @Max(value = 5, message = "Score must be at most 5")
    private Integer scoreEgg;

    @Min(value = 1, message = "Score must be at least 1")
    @Max(value = 5, message = "Score must be at most 5")
    private Integer scoreDairy;

    @Min(value = 1, message = "Score must be at least 1")
    @Max(value = 5, message = "Score must be at most 5")
    private Integer scoreAverage;

}
