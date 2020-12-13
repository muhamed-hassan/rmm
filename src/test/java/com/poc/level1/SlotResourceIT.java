package com.poc.level1;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import com.poc.BaseIT;

public class SlotResourceIT extends BaseIT {

    @Test
    void testBookAppointment_WhenSlotIsAvailable_ThenReturnBookedAppointment() throws Exception {
        var payload = readJsonFrom(SEED_MAPPINGS_DIR + "1_booking_details_request.json");
        var expectedResponse = readJsonFrom(EXPECTED_MAPPINGS_DIR + "1_available_booked_appointment.json");

        var resultActions = mockMvc.perform(post("/level1/slots/1234/appointment")
                                                            .contentType(MediaType.APPLICATION_JSON_VALUE)
                                                            .content(payload));

        resultActions.andExpect(status().isOk())
                        .andExpect(content().json(expectedResponse, true));
    }

    @Test
    void testBookAppointment_WhenSlotIsNotAvailable_ThenReturnSlotNotAvailable() throws Exception {
        var payload = readJsonFrom(SEED_MAPPINGS_DIR + "1_booking_details_request.json");
        var expectedResponse = readJsonFrom(EXPECTED_MAPPINGS_DIR + "1_unavailable_booked_appointment.json");

        var resultActions = mockMvc.perform(post("/level1/slots/777/appointment")
                                                            .contentType(MediaType.APPLICATION_JSON_VALUE)
                                                            .content(payload));

        resultActions.andExpect(status().isOk())
                        .andExpect(content().json(expectedResponse, true));
    }

}
