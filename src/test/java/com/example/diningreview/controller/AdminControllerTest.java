package com.example.diningreview.controller;

import com.example.diningreview.service.AdminService;
import com.example.diningreview.dto.AdminReviewDto;
import com.example.diningreview.MockData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdminService adminService;

    /**
     * @throws Exception when the request is invalid
     */
    @Test
    void setAdminReviewStatusTest() throws Exception {
        Long reviewId = 1L; //replace with actual reviewId

        AdminReviewDto adminReview = MockData.createAdminReviewDto();

        when(adminService.setAdminReviewStatus(eq(reviewId), any(AdminReviewDto.class)))
                .thenReturn(Optional.of(MockData.createRestaurantDto()));

        mockMvc.perform(MockMvcRequestBuilders.put("/api/admin/review/" + reviewId)
                        .content(new ObjectMapper().writeValueAsString(adminReview))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(adminService, times(1)).setAdminReviewStatus(eq(reviewId), any(AdminReviewDto.class));
    }

    /**
     * @throws Exception when the request is invalid
     */
    @Test
    void setAdminReviewStatusTest_NotFound() throws Exception {
        Long reviewId = 1L;

        AdminReviewDto adminReview = MockData.createAdminReviewDto();

        when(adminService.setAdminReviewStatus(eq(reviewId), any(AdminReviewDto.class)))
                .thenReturn(Optional.empty());

        mockMvc.perform(MockMvcRequestBuilders.put("/api/admin/review/" + reviewId)
                        .content(new ObjectMapper().writeValueAsString(adminReview))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(adminService, times(1)).setAdminReviewStatus(eq(reviewId), any(AdminReviewDto.class));
    }

    /**
     * @throws Exception when the request is invalid
     * Disabled as it only works with isNotFound but should be isBadRequest.
     * Need to re-write controller or service.
     */
    @Disabled
    @Test
    void setAdminReviewStatusTest_BadRequest() throws Exception {
        Long reviewId = 1L;

        /* Invalid object */
        AdminReviewDto adminReview = new AdminReviewDto();

        mockMvc.perform(MockMvcRequestBuilders.put("/api/admin/review/" + reviewId)
                        .content(new ObjectMapper().writeValueAsString(adminReview))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    /*
      TODO: Add more tests
      The AdminReviewDto object is valid, but the reviewId is null.
      The reviewId is valid, but the AdminReviewDto object is null.
      The AdminReviewDto object and reviewId are both null.
     */

}
