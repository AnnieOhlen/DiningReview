package com.example.DiningReview.controller;

import com.example.DiningReview.dto.ReviewDto;
import com.example.DiningReview.model.Review;
import com.example.DiningReview.repository.ReviewRepository;
import com.example.DiningReview.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewRepository reviewRepository;

    public ReviewController(ReviewRepository reviewRepo) {
        this.reviewRepository = reviewRepo;
    }

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }

    @PostMapping
    public Review postReview(@RequestBody Review review) {
        return this.reviewRepository.save(review);
    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitDiningReview(
            @RequestParam Long userId,
            @RequestBody ReviewDto reviewDto) {
        Long reviewId = reviewService.submitReview(reviewDto);
        return ResponseEntity.ok("Review submitted successfully with ID: " + reviewId);
    }

    @GetMapping("/pending")
    public List<Review> getReviewsPending() {
        return reviewRepository.findByStatus(Review.ReviewStatus.PENDING);
    }

    @GetMapping("/{restaurantId}")
    public List<Review> getReviewsRestaurant(@PathVariable Long restaurantId) {
        return reviewRepository.findByRestaurant(restaurantId);
    }

    //TODO As an admin, I want to approve or reject a given dining review.
    
    //TODO As part of the backend process that updates a restaurant's set of scores,
    // I want to fetch the set of all approved dining reviews belonging to this restaurant.

}
