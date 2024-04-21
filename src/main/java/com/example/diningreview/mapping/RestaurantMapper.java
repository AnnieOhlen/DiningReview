package com.example.diningreview.mapping;

import com.example.diningreview.dto.RestaurantDto;
import com.example.diningreview.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
public interface RestaurantMapper {

    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    RestaurantDto modelToDto(Restaurant restaurant);

    Restaurant dtoToModel(RestaurantDto restaurantDto);

    List<RestaurantDto> modelToDtoList(List<Restaurant> restaurants);

    List<Restaurant> dtoToModelList(List<RestaurantDto> restaurantDtos);
}
