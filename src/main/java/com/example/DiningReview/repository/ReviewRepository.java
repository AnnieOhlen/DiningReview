package com.example.DiningReview.repository;

import com.example.DiningReview.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {


    public List<Review> findByRestaurant(String restaurant);

}
