package com.example.DiningReview.mapping;

import com.example.DiningReview.dto.RestaurantDto;
import com.example.DiningReview.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RestaurantMapper {

    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    RestaurantDto modelToDto(Restaurant restaurant);

    Restaurant dtoToModel(RestaurantDto restaurantDto);

    List<RestaurantDto> modelToDtoList(List<Restaurant> restaurants);

    List<Restaurant> dtoToModelList(List<RestaurantDto> restaurantDtos);
}
