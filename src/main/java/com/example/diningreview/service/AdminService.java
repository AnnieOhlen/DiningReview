package com.example.diningreview.service;

import com.example.diningreview.dto.AdminReviewDto;
import com.example.diningreview.dto.RestaurantDto;
import com.example.diningreview.mapping.RestaurantMapper;
import com.example.diningreview.model.Restaurant;
import com.example.diningreview.model.Review;
import com.example.diningreview.repository.RestaurantRepository;
import com.example.diningreview.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AdminService {

    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    private static final Logger logger = LoggerFactory.getLogger(AdminService.class);

    @Autowired
    public AdminService(ReviewRepository reviewRepository, RestaurantRepository restaurantRepository, RestaurantMapper restaurantMapper) {
        this.reviewRepository = reviewRepository;
        this.restaurantRepository = restaurantRepository;
        this.restaurantMapper = restaurantMapper;
    }

    /**
     * Set the status of a review to approved or rejected.
     * Update the average scores of the restaurant if the review is approved.
     * This method returns an Optional<RestaurantDto> because it might not always return a RestaurantDto.
     * For example, if the review is not approved or if the restaurant is not found, it will return an empty Optional.
     *
     * @param reviewId the ID of the review to update
     * @param adminReview the review status set by the admin
     * @return Optional<RestaurantDto> if the review is approved and the restaurant is found, otherwise empty
     */
    public Optional <RestaurantDto> setAdminReviewStatus(Long reviewId, AdminReviewDto adminReview) {
        logger.info("Admin Review: " + adminReview);
        Review review = reviewRepository.findById(reviewId).orElse(null);
        if (review != null) {
            review.setStatus(adminReview.isApproved() ? Review.ReviewStatus.APPROVED : Review.ReviewStatus.REJECTED);
            reviewRepository.save(review);

            if (adminReview.isApproved()) {
                List<Review> approvedReviews = reviewRepository.findApprovedReviewsByRestaurant(review.getRestaurantId());

                int newScorePeanut = (int) Math.round(approvedReviews.stream().mapToInt(Review::getScorePeanut).average().orElse(0));
                int newScoreEgg = (int) Math.round(approvedReviews.stream().mapToInt(Review::getScoreEgg).average().orElse(0));
                int newScoreDairy = (int) Math.round(approvedReviews.stream().mapToInt(Review::getScoreDairy).average().orElse(0));

                int averageScore = (newScorePeanut + newScoreEgg + newScoreDairy) / 3;

                Restaurant restaurant = restaurantRepository.findById(review.getRestaurantId()).orElse(null);
                if (restaurant != null) {
                    restaurant.setScorePeanut(newScorePeanut);
                    restaurant.setScoreEgg(newScoreEgg);
                    restaurant.setScoreDairy(newScoreDairy);

                    restaurant.setScoreAverage(averageScore);
                    restaurant = restaurantRepository.save(restaurant);
                    return Optional.of(restaurantMapper.modelToDto(restaurant));
                }

            }

        }
        return Optional.empty();
    }

}
