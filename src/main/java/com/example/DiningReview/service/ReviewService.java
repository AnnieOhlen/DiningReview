package com.example.DiningReview.service;

import com.example.DiningReview.dto.AdminReviewDto;
import com.example.DiningReview.mapping.ReviewMapper;
import com.example.DiningReview.model.Review;
import com.example.DiningReview.dto.ReviewDto;
import com.example.DiningReview.repository.ReviewRepository;
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

    public ReviewDto submitReview(ReviewDto reviewDto) {
        Review review = reviewMapper.dtoToModel(reviewDto);
        Review savedReview = reviewRepository.save(review);
        return reviewMapper.modelToDto(savedReview);
    }

    public List<ReviewDto> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        return reviewMapper.modelToDtoList(reviews);
    }

    public void handleAdminReviewAction(Long reviewId, AdminReviewDto adminReview) {
        Review review = reviewRepository.findById(reviewId).orElse(null);
        if (review != null) {
            review.setStatus(adminReview.isApproved() ? Review.ReviewStatus.APPROVED : Review.ReviewStatus.REJECTED);
            reviewRepository.save(review);
        }
    }

}