package com.poc.level3;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import com.poc.BaseIT;

public class SlotResourceIT extends BaseIT {

    @Test
    public void testBookAppointment_WhenSlotIsAvailable_ThenReturnTheLocationOfBookedAppointment() throws Exception {
        String payload = readJsonFrom(SEED_MAPPINGS_DIR + "3_booking_details_request.json");

        ResultActions resultActions = mockMvc.perform(post("/level3/slots/1234")
                                                            .contentType(MediaType.APPLICATION_JSON_VALUE)
                                                            .content(payload));

        resultActions.andExpect(status().isCreated())
                        .andExpect(header().exists("Location"));
    }

    @Test
    public void testBookAppointment_WhenSlotIsNotAvailable_ThenReturnWithConflict() throws Exception {
        String payload = readJsonFrom(SEED_MAPPINGS_DIR + "3_booking_details_request.json");

        ResultActions resultActions = mockMvc.perform(post("/level3/slots/777")
                                                            .contentType(MediaType.APPLICATION_JSON_VALUE)
                                                            .content(payload));

        resultActions.andExpect(status().isConflict());
    }

   @Test
    public void testBookAppointment_WhenTheSlotIsAvailable_ThenReturnBookedAppointment() throws Exception {
        String expectedResponse = readJsonFrom(EXPECTED_MAPPINGS_DIR + "3_available_booked_appointment.json");

       ResultActions resultActions = mockMvc.perform(get("/level3/slots/1234/appointment")
                                                            .accept("application/hal+json"));

       resultActions.andExpect(status().isOk())
                        .andExpect(content().json(expectedResponse, true));
    }

}
