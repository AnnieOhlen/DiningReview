package com.example.DiningReview.service;

import com.example.DiningReview.model.Review;
import com.example.DiningReview.dto.ReviewDto;
import com.example.DiningReview.repository.ReviewRepository;
import mapper.ReviewMapper;
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
        Review review = reviewMapper.toEntity(reviewDto);
        Review savedReview = reviewRepository.save(review);
        return reviewMapper.toDto(savedReview);
    }

//    public List<ReviewDto> getAllReviews() {
//        List<Review> reviews = reviewRepository.findAll();
//        return reviews.stream()
//                .map(reviewMapper::toDto)
//                .toList();
//    }

}