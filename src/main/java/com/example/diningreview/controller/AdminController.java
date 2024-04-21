package com.example.diningreview.controller;

import com.example.diningreview.dto.AdminReviewDto;
import com.example.diningreview.dto.RestaurantDto;
import com.example.diningreview.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
@Tag(name = "Admin Controller", description = "Operations pertaining to admin management")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PutMapping("/review/{reviewId}")
    @Operation(summary = "Set admin review status", description = "Set review status by admin")
    public ResponseEntity<RestaurantDto> setAdminReviewStatus(@Parameter(description = "ID of the review to be updated", required = true) @PathVariable Long reviewId, @RequestBody AdminReviewDto adminReview) {
        Optional<RestaurantDto> updatedRestaurant = adminService.setAdminReviewStatus(reviewId, adminReview);
        if (updatedRestaurant.isPresent()) {
            return ResponseEntity.ok(updatedRestaurant.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
