package com.poc.level2;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.poc.BaseIT;

public class DoctorResourceIT extends BaseIT {

    @Test
    public void testGetOpenSlots_WhenInquiryAboutAvailableSlots_ThenReturnAvailableSlots() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("date", "20100104");
        params.add("status", "open");
        String expectedResponse = readJsonFrom(EXPECTED_MAPPINGS_DIR + "2_available_slots.json");

        ResultActions resultActions = mockMvc.perform(get("/level2/doctors/mjones/slots")
                                                            .params(params)
                                                            .accept(MediaType.APPLICATION_JSON_VALUE));

        resultActions.andExpect(status().isOk())
                        .andExpect(content().json(expectedResponse, true));
    }

}
