package com.example.DiningReview.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name="REVIEWS")
public class Review {

    @Id
    @GeneratedValue
    private Long reviewId;

    @Column(name="REVIEWER_NAME")
    private String name;

    @Column(name="RESTAURANT_ID")
    @NotNull
    @NotBlank
    private Long restaurantId;

    @Column(name="SCORE_PEANUT")
    @Min(value = 1)
    @Max(value = 5)
    private Integer scorePeanut;

    @Column(name="SCORE_EGG")
    @Min (value = 1)
    @Max (value = 5)
    private Integer scoreEgg;

    @Column(name="SCORE_DAIRY")
    @Min (value = 1)
    @Max (value = 5)
    private Integer scoreDairy;

    @Column(name="REVIEW_COMMENTARY")
    @Null
    private String reviewCommentary;

    @Enumerated(EnumType.STRING)
    @Column(name="REVIEW_STATUS")
    private ReviewStatus status;

    public enum ReviewStatus {
        PENDING,
        APPROVED,
        REJECTED
    }
}
