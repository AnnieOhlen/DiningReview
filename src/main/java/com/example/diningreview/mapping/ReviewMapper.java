package com.example.diningreview.mapping;

import com.example.diningreview.dto.ReviewDto;
import com.example.diningreview.model.Review;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",  nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
public interface ReviewMapper {

    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    ReviewDto modelToDto(Review review);

    Review dtoToModel(ReviewDto reviewDto);

    List<ReviewDto> modelToDtoList(List<Review> reviews);

    List<Review> dtoToModelList(List<ReviewDto> reviewDtos);

}
