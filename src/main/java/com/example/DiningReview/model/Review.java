package com.example.DiningReview.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="REVIEWS")
public class Review {

    @Id
    @GeneratedValue
    private Long reviewId;

    @Column(name="REVIEWER_NAME")
    private String name;

    @Column(name="RESTAURANT_ID")
    private Long restaurantId;

    @Column(name="SCORE_PEANUT")
    @Min(value = 1)
    @Max(value = 5)
    @Null
    private Integer scorePeanut;

    @Column(name="SCORE_EGG")
    @Min (value = 1)
    @Max (value = 5)
    @Null
    private Integer scoreEgg;

    @Column(name="SCORE_DAIRY")
    @Min (value = 1)
    @Max (value = 5)
    @Null
    private Integer scoreDairy;

    @Column(name="REVIEW_COMMENTARY")
    @Null
    private String reviewCommentary;
}
