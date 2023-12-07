package com.example.DiningReview.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name="RESTAURANTS")
public class Restaurant {

    @Id
    @GeneratedValue
    private Long restaurantId;

    @Column(name="RESTAURANT_NAME")
    @NotBlank
    private String restaurantName;

    @Column(name="SCORE_PEANUT")
    @Min (value = 1)
    @Max (value = 5)
    private Integer scorePeanut;

    @Column(name="SCORE_EGG")
    @Min (value = 1)
    @Max (value = 5)
    private Integer scoreEgg;

    @Column(name="SCORE_DAIRY")
    @Min (value = 1)
    @Max (value = 5)
    private Integer scoreDairy;

    @Column(name="SCORE_AVERAGE")
    @Min (value = 1)
    @Max (value = 5)
    private Integer scoreAverage;
}
