package com.poc.level3;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import com.poc.BaseIT;

class SlotResourceIT extends BaseIT {

    @Test
    void shouldReturnStatus201AndLocationOfBookedAppointmentWhenRequestAppointmentAndSlotIsAvailable() throws Exception {
        var requestBody = readJsonFrom(SEED_MAPPINGS_DIR + "3_booking_details_request.json");

        var resultActions = mockMvc.perform(post("/level3/slots/1234")
                                                            .contentType(MediaType.APPLICATION_JSON_VALUE).content(requestBody));

        resultActions.andExpect(status().isCreated())
                        .andExpect(header().exists("Location"));
    }

    @Test
    void shouldReturnStatus409WhenRequestAppointmentAndSlotIsNotAvailable() throws Exception {
        var requestBody = readJsonFrom(SEED_MAPPINGS_DIR + "3_booking_details_request.json");

        var resultActions = mockMvc.perform(post("/level3/slots/777")
                                                            .contentType(MediaType.APPLICATION_JSON_VALUE).content(requestBody));

        resultActions.andExpect(status().isConflict());
    }

    @Test
    void shouldReturnStatus200AndBookedAppointmentWhenSlotHaveBookedAppointment() throws Exception {
        var expectedResponse = readJsonFrom(EXPECTED_MAPPINGS_DIR + "3_available_booked_appointment.json");

        var resultActions = mockMvc.perform(get("/level3/slots/1234/appointment")
                                                            .accept("application/hal+json"));

        resultActions.andExpect(status().isOk())
                        .andExpect(content().json(expectedResponse, true));
    }

}
