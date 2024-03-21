package com.example.DiningReview.mapping;

import com.example.DiningReview.dto.ReviewDto;
import com.example.DiningReview.model.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ObjectFactory;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    @Mapping(target = "reviewId", source = "reviewId")
    ReviewDto modelToDto(Review review);

    @Mapping(target = "reviewId", ignore = true) // Ignore id during conversion (auto-generated).
    @Mapping(target = "reviewerName", source = "reviewerName")
    @Mapping(target = "restaurantId", source = "restaurantId")
    @Mapping(target = "scorePeanut", source = "scorePeanut")
    @Mapping(target = "scoreEgg", source = "scoreEgg")
    @Mapping(target = "scoreDairy", source = "scoreDairy")
    @Mapping(target = "reviewCommentary", source = "reviewCommentary")
    @Mapping(target = "status", source = "status")
    Review dtoToModel(ReviewDto reviewDto);

    List<ReviewDto> modelToDtoList(List<Review> reviews);

    List<Review> dtoToModelList(List<ReviewDto> reviewDtos);

    @ObjectFactory
    default Review createReview(ReviewDto reviewDto) {
        return new Review(
                reviewDto.getReviewerName(),
                reviewDto.getRestaurantId(),
                reviewDto.getScorePeanut(),
                reviewDto.getScoreEgg(),
                reviewDto.getScoreDairy(),
                reviewDto.getReviewCommentary()
        );
    }
}
