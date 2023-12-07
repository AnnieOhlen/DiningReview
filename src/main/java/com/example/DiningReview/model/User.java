package com.example.DiningReview.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name="USERS", uniqueConstraints = @UniqueConstraint(columnNames = {"USER_NAME"}))
public class User {

    @Id
    @GeneratedValue
    private Long userId;

    @Column(name="USER_NAME")
    @Size(min=3, max=20)
    private String username;

    @Column(name="CITY")
    private String city;

    @Column(name="STATE")
    private String state;

    @Column(name="ZIP_CODE")
    private Integer zipCode;

    @Column(name="ALLERGY_PEANUT")
    private boolean allergyPeanut = false;

    @Column(name="ALLERGY_EGG")
    private boolean allergyEgg = false;

    @Column(name="ALLERGY_DAIRY")
    private boolean allergyDairy = false;
}
