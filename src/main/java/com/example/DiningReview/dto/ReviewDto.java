package com.example.DiningReview.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ReviewDto {

    private Long reviewId;

    private String reviewerName;

    @NotNull(message="Restaurant ID must not be null.")
    private Long restaurantId;

    @Min(value = 1, message = "Score must be at least 1")
    @Max(value = 5, message = "Score must be at most 5")
    private Integer scorePeanut;

    @Min(value = 1, message = "Score must be at least 1")
    @Max(value = 5, message = "Score must be at most 5")
    private Integer scoreEgg;

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
