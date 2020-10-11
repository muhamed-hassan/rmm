package com.poc.level1;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import com.poc.BaseIT;

public class DoctorResourceIT extends BaseIT {

    @Test
    public void testGetOpenSlots_WhenInquiryAboutAvailableSlots_ThenReturnAvailableSlots() throws Exception {
        String payload = readJsonFrom(SEED_MAPPINGS_DIR + "1_open_slot_request.json");
        String expectedResponse = readJsonFrom(EXPECTED_MAPPINGS_DIR + "1_available_slots.json");

        ResultActions resultActions = mockMvc.perform(post("/level1/doctors/mjones")
                                                            .contentType(MediaType.APPLICATION_JSON_VALUE)
                                                            .content(payload));

        resultActions.andExpect(status().isOk())
            .andExpect(content().json(expectedResponse, true));
    }

}
