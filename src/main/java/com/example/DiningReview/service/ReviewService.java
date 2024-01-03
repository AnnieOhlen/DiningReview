package com.example.DiningReview.service;

import com.example.DiningReview.model.Review;
import com.example.DiningReview.dto.ReviewDto;
import com.example.DiningReview.repository.ReviewRepository;
import mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    private final ReviewMapper reviewMapper;

    public ReviewService(ReviewRepository reviewRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
    }

    public Long submitReview(ReviewDto reviewDto) {
        Review reviewEntity = reviewMapper.toEntity(reviewDto);
        Review savedReview = reviewRepository.save(reviewEntity);
        return savedReview.getReviewId();
    }

    public List<ReviewDto> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream()
                .map(reviewMapper::toDto)
                .collect(Collectors.toList());
    }

}