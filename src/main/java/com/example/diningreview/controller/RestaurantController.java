package com.example.diningreview.controller;

import com.example.diningreview.dto.RestaurantDto;
import com.example.diningreview.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
@Tag(name = "Restaurant Controller", description = "Operations pertaining to restaurant management")
public class RestaurantController {
    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    @Operation(summary = "Get all restaurants", description = "Get all restaurants")
    public ResponseEntity<List<RestaurantDto>> getRestaurants() {
        List<RestaurantDto> restaurants = restaurantService.getAllRestaurants();
        return ResponseEntity.ok(restaurants);
    }

    @GetMapping("/search")
    @Operation(summary = "Get restaurants by zip code and allergy", description = "Get restaurants by zip code and allergy")
    public ResponseEntity<List<RestaurantDto>> getRestaurantsByZipCodeAndAllergy(@RequestParam String zipCode, @RequestParam String allergy) {
        List<RestaurantDto> restaurants = restaurantService.getRestaurantsByZipCodeAndAllergy(zipCode, allergy);
        return ResponseEntity.ok(restaurants);
    }

    @PostMapping("/register")
    @Operation(summary = "Register a restaurant", description = "Register a restaurant")
    public ResponseEntity<RestaurantDto> saveRestaurant(@Valid @RequestBody RestaurantDto restaurantDto) {
        RestaurantDto submittedRestaurant = restaurantService.saveRestaurant(restaurantDto);
        return ResponseEntity.ok(submittedRestaurant);
    }

}
