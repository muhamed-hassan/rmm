package com.poc.level1;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import com.poc.BaseIT;

public class SlotResourceIT extends BaseIT {

    @Test
    public void testBookAppointment_WhenSlotIsAvailable_ThenReturnBookedAppointment() throws Exception {
        String payload = readJsonFrom(SEED_MAPPINGS_DIR + "1_booking_details_request.json");
        String expectedResponse = readJsonFrom(EXPECTED_MAPPINGS_DIR + "1_available_booked_appointment.json");

        ResultActions resultActions = mockMvc.perform(post("/level1/slots/1234/appointment")
                                                            .contentType(MediaType.APPLICATION_JSON_VALUE)
                                                            .content(payload));

        resultActions.andExpect(status().isOk())
                        .andExpect(content().json(expectedResponse, true));
    }

    @Test
    public void testBookAppointment_WhenSlotIsNotAvailable_ThenReturnSlotNotAvailable() throws Exception {
        String payload = readJsonFrom(SEED_MAPPINGS_DIR + "1_booking_details_request.json");
        String expectedResponse = readJsonFrom(EXPECTED_MAPPINGS_DIR + "1_unavailable_booked_appointment.json");

        ResultActions resultActions = mockMvc.perform(post("/level1/slots/777/appointment")
                                                            .contentType(MediaType.APPLICATION_JSON_VALUE)
                                                            .content(payload));

        resultActions.andExpect(status().isOk())
                        .andExpect(content().json(expectedResponse, true));
    }

}
