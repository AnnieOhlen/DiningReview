package com.example.DiningReview.mapping;

import com.example.DiningReview.dto.ReviewDto;
import com.example.DiningReview.model.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    @Mapping(target = "reviewId", ignore = true) // Ignore reviewId during conversion (auto-generated).

    ReviewDto modelToDto(Review review);

    Review dtoToModel(ReviewDto reviewDto);

    List<ReviewDto> modelToDtoList(List<Review> reviews);

    List<Review> dtoToModelList(List<ReviewDto> reviewDtos);
}
