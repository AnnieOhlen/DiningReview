package com.example.diningreview.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;

/**
 * Represents a review of a restaurant in the application.
 */

@Data
@Entity
@Table(name="REVIEWS")
public class Review {

    @Id
    @GeneratedValue
    private Long reviewId;

    @Column(name="REVIEWER_NAME")
    @NotBlank
    private String reviewerName;

    @Column(name="RESTAURANT_ID")
    @NotNull
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
    private String reviewCommentary;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(name="REVIEW_STATUS")
    private ReviewStatus status;

    protected Review() {
        // Default constructor for JPA
    }

    public Review(String reviewerName, Long restaurantId, Integer scorePeanut, Integer scoreEgg, Integer scoreDairy,
                  String reviewCommentary) {
        this.reviewerName = reviewerName;
        this.restaurantId = restaurantId;
        this.scorePeanut = scorePeanut;
        this.scoreEgg = scoreEgg;
        this.scoreDairy = scoreDairy;
        this.reviewCommentary = reviewCommentary;

        //Set default for new reviews
        this.status = ReviewStatus.PENDING;
    }

    @PrePersist
    public void prePersist() {
        if (status == null) {
            status = ReviewStatus.PENDING;
        }
    }

    public enum ReviewStatus {
        PENDING,
        APPROVED,
        REJECTED
    }
}
