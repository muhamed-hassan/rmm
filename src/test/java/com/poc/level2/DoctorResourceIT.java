package com.poc.level2;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;

import com.poc.BaseIT;

class DoctorResourceIT extends BaseIT {

    @Test
    void shouldReturnAvailableSlotsWhenInquiryThem() throws Exception {
        var expectedResponse = readJsonFrom(EXPECTED_MAPPINGS_DIR + "2_available_slots.json");

        var resultActions = mockMvc.perform(get("/level2/doctors/mjones/slots")
                                                            .params(prepareRequestParams())
                                                            .accept(MediaType.APPLICATION_JSON_VALUE));

        resultActions.andExpect(status().isOk())
                        .andExpect(content().json(expectedResponse, true));
    }

    private LinkedMultiValueMap<String, String> prepareRequestParams() {
        var requestParams = new LinkedMultiValueMap<String, String>();
        requestParams.add("date", "20100104");
        requestParams.add("status", "open");
        return requestParams;
    }

}
