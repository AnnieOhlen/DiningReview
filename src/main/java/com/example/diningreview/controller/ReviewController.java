package com.example.diningreview.controller;

import com.example.diningreview.dto.ReviewDto;
import com.example.diningreview.service.ReviewService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@Tag(name = "Review Controller", description = "Operations pertaining to reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    @Operation(summary = "Get all reviews", description = "Get all reviews submitted by users")
    public ResponseEntity<List<ReviewDto>> getAllReviews() {
        List<ReviewDto> reviews = reviewService.getAllReviews();
        return ResponseEntity.ok(reviews);
    }

    @PostMapping("/submit")
    @Operation(summary = "Submit a review", description = "Submit a review for a restaurant")
    public ResponseEntity<ReviewDto> saveReview(
            @RequestParam String username,
            @Valid @RequestBody ReviewDto reviewDto) {
        if (username == null || username.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        try {
            ReviewDto submittedReview = reviewService.saveReview(reviewDto);
            return ResponseEntity.ok(submittedReview);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/pending")
    @Operation(summary = "Get pending reviews", description = "Get all reviews pending admin approval")
    public ResponseEntity<List<ReviewDto>> getPendingReviews() {
        List<ReviewDto> reviews = reviewService.getPendingReviews();
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/{restaurantId}")
    @Operation(summary = "Get reviews by restaurant", description = "Get all reviews for a specific restaurant")
    public ResponseEntity<List<ReviewDto>> getReviewsByRestaurant(@PathVariable Long restaurantId) {
        List<ReviewDto> reviews = reviewService.getReviewsByRestaurant(restaurantId);
        return ResponseEntity.ok(reviews);
    }

}
