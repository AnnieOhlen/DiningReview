package com.example.diningreview;

import com.example.diningreview.dto.AdminReviewDto;
import com.example.diningreview.dto.RestaurantDto;
import com.example.diningreview.dto.ReviewDto;
import com.example.diningreview.dto.UserDto;

public class MockData {

    public static AdminReviewDto createAdminReviewDto() {
        AdminReviewDto adminReview = new AdminReviewDto();
        adminReview.setApproved(true);
        return adminReview;
    }

    public static RestaurantDto createRestaurantDto() {
        RestaurantDto restaurant = new RestaurantDto();
        restaurant.setRestaurantId(1L);
        restaurant.setRestaurantName("Test Restaurant");
        restaurant.setScorePeanut(5);
        restaurant.setScoreEgg(4);
        restaurant.setScoreDairy(3);
        restaurant.setScoreAverage((restaurant.getScorePeanut() + restaurant.getScoreEgg() + restaurant.getScoreDairy()) / 3);
        return restaurant;
    }

    // Add more methods for creating other data objects as needed
    public static UserDto createUserDto() {
        UserDto user = new UserDto();
        user.setUserId(1L);
        user.setUsername("Test User");
        user.setCity("Test City");
        user.setState("Test State");
        user.setZipCode(12345);
        user.setAllergyPeanut(true);
        user.setAllergyEgg(false);
        user.setAllergyDairy(false);
        return user;
    }

    public static ReviewDto createReviewDto() {
        ReviewDto review = new ReviewDto();
        review.setReviewId(1L);
        review.setReviewerName("Test User");
        review.setRestaurantId(1L);
        review.setScorePeanut(5);
        review.setScoreEgg(4);
        review.setScoreDairy(0);
        review.setReviewCommentary("Test Review");
        review.setStatus(ReviewDto.ReviewStatus.PENDING);
        return review;
    }
}