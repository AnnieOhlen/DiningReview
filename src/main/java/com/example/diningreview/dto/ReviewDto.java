package com.example.diningreview.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ReviewDto {

    private Long reviewId;

    private String reviewerName;

    @NotNull(message="Restaurant ID must not be null.")
    private Long restaurantId;

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

    private String reviewCommentary;

    @Enumerated(EnumType.STRING)
    private ReviewStatus status;

    public enum ReviewStatus {
        PENDING,
        APPROVED,
        REJECTED
    }

}
