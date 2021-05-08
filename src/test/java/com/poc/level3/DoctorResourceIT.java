package com.poc.level3;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.util.LinkedMultiValueMap;

import com.poc.BaseIT;

class DoctorResourceIT extends BaseIT {

    @Test
    void shouldReturnAvailableSlotsWhenInquiryThem() throws Exception {
        var expectedResponse = readJsonFrom(EXPECTED_MAPPINGS_DIR + "3_available_slots.json");

        var resultActions = mockMvc.perform(get("/level3/doctors/mjones/slots")
                                                            .params(prepareRequestParameters())
                                                            .accept("application/hal+json"));

        resultActions.andExpect(status().isOk())
                        .andExpect(content().json(expectedResponse, true));
    }

    private LinkedMultiValueMap<String, String> prepareRequestParameters() {
        var params = new LinkedMultiValueMap<String, String>();
        params.add("date", "20100104");
        params.add("status", "open");
        return params;
    }

}
