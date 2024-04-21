package com.example.diningreview.repository;

import com.example.diningreview.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query("SELECT r FROM Restaurant r JOIN Review rev ON r.restaurantId = rev.restaurantId JOIN User u ON rev.reviewerName = u.username WHERE u.zipCode = :zipCode AND (CASE WHEN :allergy = 'peanut' THEN rev.scorePeanut WHEN :allergy = 'egg' THEN rev.scoreEgg WHEN :allergy = 'dairy' THEN rev.scoreDairy END) > 0 ORDER BY (rev.scorePeanut + rev.scoreEgg + rev.scoreDairy) DESC")
    List<Restaurant> findRestaurantsByZipCodeAndAllergyScore(@Param("zipCode") String zipCode, @Param("allergy") String allergy);
}
