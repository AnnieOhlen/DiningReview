package com.example.DiningReview.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
@Entity
@Table(name="RESTAURANTS")
public class Restaurant {

    @Id
    @GeneratedValue
    private Long restaurantId;

    @Column(name="RESTAURANT_NAME")
    private String name;

    @Column(name="SCORE_PEANUT")
    @Min (value = 1)
    @Max (value = 5)
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

    @Column(name="SCORE_AVERAGE")
    @Min (value = 1)
    @Max (value = 5)
    @Null
    private Integer scoreAverage;

    //Setters.
    public void setId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScorePeanut(Integer scorePeanut) {
        this.scorePeanut = scorePeanut;
    }

    public void setScoreEgg(Integer scoreEgg) {
        this.scoreEgg = scoreEgg;
    }

    public void setScoreDairy(Integer scoreDairy) {
        this.scoreDairy = scoreDairy;
    }

    public void setScoreAverage(Integer scoreAverage) {
        this.scoreAverage = scoreAverage;
    }
}
