package com.example.diningreview.repository;

import com.example.diningreview.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByStatus(Review.ReviewStatus reviewStatus);

    @Query("SELECT r FROM Review r WHERE r.restaurantId = :restaurantId AND r.status = 'APPROVED'")
    List<Review> findApprovedReviewsByRestaurant(@Param("restaurantId") Long restaurantId);

}