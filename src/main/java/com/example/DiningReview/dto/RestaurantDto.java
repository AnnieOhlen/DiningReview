package com.example.DiningReview.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RestaurantDto {

    private Long restaurantId;

    @NotBlank(message="Restaurant name is required.")
    private String restaurantName;

    @Min(value = 1)
    @Max(value = 5)
    private Integer scorePeanut;

    @Min (value = 1)
    @Max (value = 5)
    private Integer scoreEgg;

    @Min (value = 1)
    @Max (value = 5)
    private Integer scoreDairy;

    @Min (value = 1)
    @Max (value = 5)
    private Integer scoreAverage;
}
