package com.example.DiningReview.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Null;
import lombok.Getter;

@Entity
@Table(name="REVIEWS")
public class Review {

    @Id
    @GeneratedValue
    @Getter
    private Long reviewId;

    @Column(name="REVIEWER_NAME")
    @Getter
    private String name;

    @Column(name="RESTAURANT_ID")
    @Getter
    private Long restaurantId;

    @Column(name="SCORE_PEANUT")
    @Min(value = 1)
    @Max(value = 5)
    @Null
    @Getter
    private Integer scorePeanut;

    @Column(name="SCORE_EGG")
    @Min (value = 1)
    @Max (value = 5)
    @Null
    @Getter
    private Integer scoreEgg;

    @Column(name="SCORE_DAIRY")
    @Min (value = 1)
    @Max (value = 5)
    @Null
    @Getter
    private Integer scoreDairy;

    @Column(name="SCORE_AVERAGE")
    @Min (value = 1)
    @Max (value = 5)
    @Null
    @Getter
    private Integer scoreAverage;

    //Setters.
    public void setId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public void setName(String name) {
        this.name = name;
    }

}
