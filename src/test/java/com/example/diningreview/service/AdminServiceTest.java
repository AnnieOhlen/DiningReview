package com.example.diningreview.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class AdminServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdminService adminService;

    /**
     * TODO: Yet to be implemented
     */
    @Disabled
    @Test
    void setAdminReviewStatusTest() {
        // implement this
    }

    /*
    TODO: Add more tests
    * When reviewId is valid and adminReview is valid, the method should return a RestaurantDto.
    * When reviewId is valid but adminReview is null, the method should return an Optional.empty().
    * When reviewId is null but adminReview is valid, the method should return an Optional.empty().
    * When both reviewId and adminReview are null, the method should return an Optional.empty().
    * When reviewId is valid but does not exist in the database, the method should return an Optional.empty().
    * When reviewId is valid and exists in the database, but adminReview is not approved, the method should return an Optional.empty().
    * When reviewId is valid, exists in the database, adminReview is approved, but the restaurant does not exist in the database, the method should return an Optional.empty().
    * When reviewId is valid, exists in the database, adminReview is approved, the restaurant exists in the database, the method should return a RestaurantDto with updated scores.
     */

}
