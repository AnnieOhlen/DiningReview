package com.example.diningreview.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class RestaurantDto {

    private Long restaurantId;

    @NotBlank(message="Restaurant name is required.")
    private String restaurantName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "#.##")
    @Min(value = 1, message = "Score must be at least 1")
    @Max(value = 5, message = "Score must be at most 5")
    private Integer scorePeanut;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "#.##")
    @Min(value = 1, message = "Score must be at least 1")
    @Max(value = 5, message = "Score must be at most 5")
    private Integer scoreEgg;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "#.##")
    @Min(value = 1, message = "Score must be at least 1")
    @Max(value = 5, message = "Score must be at most 5")
    private Integer scoreDairy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "#.##")
    @Min(value = 1, message = "Score must be at least 1")
    @Max(value = 5, message = "Score must be at most 5")
    private Integer scoreAverage;

}
