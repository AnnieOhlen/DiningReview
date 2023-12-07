package com.example.DiningReview.service;

import com.example.DiningReview.model.Review;
import com.example.DiningReview.repository.ReviewRepository;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        throw new NotImplementedException("Method not implemented");
        //TODO Convert entities to DTOs or perform additional business logic
        //return convertToDTOs(reviews);
    }
    
}
