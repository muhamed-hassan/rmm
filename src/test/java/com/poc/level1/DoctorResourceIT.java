package com.poc.level1;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;

import com.poc.BaseIT;

public class DoctorResourceIT extends BaseIT {

    @Test
    public void testGetOpenSlots_WhenInquiryAboutAvailableSlots_ThenReturnAvailableSlots() throws Exception {
        String payload = readJsonFrom(SEED_MAPPINGS_DIR + "1_open_slot_request.json");
        String expectedResponse = readJsonFrom(EXPECTED_MAPPINGS_DIR + "1_available_slots.json");

        MockHttpServletResponse response = mockMvc.perform(post("/level1/doctors/mjones")
                                                            .contentType(MediaType.APPLICATION_JSON_VALUE)
                                                            .content(payload))
                                                    .andReturn()
                                                    .getResponse();

        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatus());
        JSONAssert.assertEquals(expectedResponse, response.getContentAsString(), true);
    }

}
