package com.example.DiningReview.service;

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

//    public void updateReviewStatus(Long reviewId, Review.ReviewStatus newStatus, UserDetails userDetails) {
//        // Check if the user is an admin (you need to implement this logic)
//        if (userDetails != null && userDetails.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
//            Review existingReview = reviewRepository.findById(reviewId)
//                    .orElseThrow(() -> new NotFoundException("Review not found with id: " + reviewId));
//
//            existingReview.setStatus(newStatus);
//            reviewRepository.save(existingReview);
//        } else {
//            throw new AccessDeniedException("Only admin users can update review status.");
//        }
//    }

}