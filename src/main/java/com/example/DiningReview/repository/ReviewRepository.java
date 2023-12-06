package com.example.DiningReview.repository;

import com.example.DiningReview.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByStatus(Review.ReviewStatus reviewStatus);

    //TODO currently causes error "restaurant", what should the implementation be?
    //public List<Review> findByRestaurant(String restaurant);

}
