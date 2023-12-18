package com.example.DiningReview.mapping;

import com.example.DiningReview.dto.AdminReviewDto;
import com.example.DiningReview.model.AdminReview;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface AdminReviewMapper {

    AdminReviewMapper INSTANCE = Mappers.getMapper(AdminReviewMapper.class);

    AdminReviewDto modelToDto(AdminReview adminReview);

    AdminReview dtoToModel(AdminReviewDto adminReviewDto);

    List<AdminReviewDto> modelToDtoList(List<AdminReview> adminReviews);

    List<AdminReview> dtoToModelList(List<AdminReviewDto> adminReviewDtos);
}
