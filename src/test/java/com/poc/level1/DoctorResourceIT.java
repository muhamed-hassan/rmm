package com.poc.level1;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import com.poc.BaseIT;

class DoctorResourceIT extends BaseIT {

    @Test
    void shouldReturnAvailableSlotsWhenInquiryThem() throws Exception {
        var requestBody = readJsonFrom(SEED_MAPPINGS_DIR + "1_open_slot_request.json");
        var expectedResponse = readJsonFrom(EXPECTED_MAPPINGS_DIR + "1_available_slots.json");

        var resultActions = mockMvc.perform(post("/level1/doctors/mjones")
                                                            .contentType(MediaType.APPLICATION_JSON_VALUE)
                                                            .content(requestBody));

        resultActions.andExpect(status().isOk())
                        .andExpect(content().json(expectedResponse, true));
    }

}
