package com.example.diningreview.service;

import com.example.diningreview.mapping.RestaurantMapper;
import com.example.diningreview.model.Restaurant;
import com.example.diningreview.dto.RestaurantDto;
import com.example.diningreview.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository, RestaurantMapper restaurantMapper) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantMapper = restaurantMapper;
    }

    /**
     * Save a restaurant to the database
     * @param restaurantDto the restaurant to save
     * @return the saved restaurant
     */
    public RestaurantDto saveRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurant = restaurantMapper.dtoToModel(restaurantDto);
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        return restaurantMapper.modelToDto(savedRestaurant);
    }

    /**
     * Get all restaurants from the database
     * @return a list of all restaurants
     */
    public List<RestaurantDto> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants.stream()
                .map(restaurantMapper::modelToDto)
                .toList();
    }

    /**
     * Get all restaurants by zip code and allergy
     * @param zipCode the zip code to search for
     * @param allergy the allergy to filter restaurants by
     * @return a list of restaurants with zip code and allergy
     */
    public List<RestaurantDto> getRestaurantsByZipCodeAndAllergy(String zipCode, String allergy) {
        List<Restaurant> restaurants = restaurantRepository.findRestaurantsByZipCodeAndAllergyScore(zipCode, allergy);
        return restaurants.stream()
                .map(restaurantMapper::modelToDto)
                .toList();
    }

}
