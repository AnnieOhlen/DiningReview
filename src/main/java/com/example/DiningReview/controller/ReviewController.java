package com.example.DiningReview.controller;

import com.example.DiningReview.model.Review;
import com.example.DiningReview.repository.ReviewRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewRepository reviewRepository;

    public ReviewController(ReviewRepository reviewRepo) {
        this.reviewRepository = reviewRepo;
    }

    //Registered user: submit a dining review.
    @PostMapping
    public Review postReview(@RequestBody Review review) {
        return this.reviewRepository.save(review);
    }

    //Admin: get the list of all dining reviews that are pending approval.
    @GetMapping("/pending")
    public List<Review> getReviewsPending() {
        return reviewRepository.findByStatus(Review.ReviewStatus.PENDING);
    }

    //TODO As an admin, I want to approve or reject a given dining review.

    //TODO As part of the backend process that updates a restaurant's set of scores, I want to fetch the set of all approved dining reviews belonging to this restaurant.

    //TODO As part of the backend process that updates a restaurant's set of scores,
    // I want to fetch the set of all approved dining reviews belonging to this restaurant.
}
