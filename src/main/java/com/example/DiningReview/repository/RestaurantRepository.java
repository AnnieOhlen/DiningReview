package com.example.DiningReview.repository;

import com.example.DiningReview.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query("SELECT r FROM Restaurant r JOIN Review rev ON r.restaurantId = rev.restaurantId JOIN User u ON rev.reviewerName = u.username WHERE u.zipCode = :zipCode AND (rev.scorePeanut > 0 OR rev.scoreEgg > 0 OR rev.scoreDairy > 0) ORDER BY (rev.scorePeanut + rev.scoreEgg + rev.scoreDairy) DESC")
    List<Restaurant> findRestaurantsByZipCodeAndAllergyScore(@Param("zipCode") String zipCode);

    boolean existsByNameAndZipCode(String name, String zipCode);

}
