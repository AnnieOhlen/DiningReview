package com.example.diningreview.service;

import com.example.diningreview.mapping.ReviewMapper;
import com.example.diningreview.model.Review;
import com.example.diningreview.dto.ReviewDto;
import com.example.diningreview.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
    }

    /**
     * Save a review to the database
     * @param reviewDto the review to save
     * @return the saved review
     */
    public ReviewDto saveReview(ReviewDto reviewDto) {
        Review review = reviewMapper.dtoToModel(reviewDto);
        Review savedReview = reviewRepository.save(review);
        return reviewMapper.modelToDto(savedReview);
    }

    /**
     * Get all reviews from the database
     * @return a list of all reviews
     */
    public List<ReviewDto> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream()
                .map(reviewMapper::modelToDto)
                .toList();
    }

    /**
     * Get all pending reviews from the database
     * @return a list of all pending reviews
     */
    public List<ReviewDto> getPendingReviews() {
        List<Review> reviews = reviewRepository.findByStatus(Review.ReviewStatus.PENDING);
        return reviews.stream()
                .map(reviewMapper::modelToDto)
                .toList();
    }

    /**
     * Get all approved reviews from a specific restaurant from the database
     * @param restaurantId the id of the restaurant
     * @return a list of all approved reviews
     */
    public List<ReviewDto> getReviewsByRestaurant(Long restaurantId) {
        List<Review> reviews = reviewRepository.findApprovedReviewsByRestaurant(restaurantId);
        return reviews.stream()
                .map(reviewMapper::modelToDto)
                .toList();
    }

}
