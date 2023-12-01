package com.example.DiningReview.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="USERS", uniqueConstraints = @UniqueConstraint(columnNames = {"USER_NAME"}))
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="USER_NAME")
    @Size(min=3, max=20, message="Username must be between 3 and 20 characters long.")
    private String username;

    @Column(name="CITY")
    @NotBlank(message="City is required.")
    private String city;

    @Column(name="STATE")
    @NotBlank(message="State is required.")
    private String state;

    @Column(name="ZIP_CODE")
    @NotNull(message="Zip code must not be null.")
    @NotBlank(message="Zip code is required.")
    private Integer zipCode;

    @Column(name="ALLERGY_PEANUT")
    private boolean allergyPeanut = false;

    @Column(name="ALLERGY_EGG")
    private boolean allergyEgg = false;

    @Column(name="ALLERGY_DAIRY")
    private boolean allergyDairy = false;
}
