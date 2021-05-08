package com.poc.level1;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import com.poc.BaseIT;

class SlotResourceIT extends BaseIT {

    @Test
    void shouldReturnBookedAppointmentWhenRequestItAndSlotIsAvailable() throws Exception {
        var requestBody = readJsonFrom(SEED_MAPPINGS_DIR + "1_booking_details_request.json");
        var expectedResponse = readJsonFrom(EXPECTED_MAPPINGS_DIR + "1_available_booked_appointment.json");

        var resultActions = mockMvc.perform(post("/level1/slots/1234/appointment")
                                                            .contentType(MediaType.APPLICATION_JSON_VALUE)
                                                            .content(requestBody));

        resultActions.andExpect(status().isOk())
                        .andExpect(content().json(expectedResponse, true));
    }

    @Test
    void shouldReturnSlotNotAvailableWhenRequestAppointmentAndSlotIsNotAvailable() throws Exception {
        var requestBody = readJsonFrom(SEED_MAPPINGS_DIR + "1_booking_details_request.json");
        var expectedResponse = readJsonFrom(EXPECTED_MAPPINGS_DIR + "1_unavailable_booked_appointment.json");

        var resultActions = mockMvc.perform(post("/level1/slots/777/appointment")
                                                            .contentType(MediaType.APPLICATION_JSON_VALUE)
                                                            .content(requestBody));

        resultActions.andExpect(status().isOk())
                        .andExpect(content().json(expectedResponse, true));
    }

}
