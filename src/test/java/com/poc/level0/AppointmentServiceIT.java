package com.poc.level0;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import com.poc.BaseIT;

public class AppointmentServiceIT extends BaseIT {

    @Test
    void testGetOpenSlots_WhenInquiryAboutAvailableSlots_ThenReturnAvailableSlots() throws Exception {
        var payload = readJsonFrom(SEED_MAPPINGS_DIR + "0_open_slot_request.json");
        var expectedResponse = readJsonFrom(EXPECTED_MAPPINGS_DIR + "0_available_slots.json");

        var resultActions
             = mockMvc.perform(post("/level0/appointmentService/getOpenSlots")
                                                            .contentType(MediaType.APPLICATION_JSON_VALUE)
                                                            .content(payload));

        resultActions.andExpect(status().isOk())
                        .andExpect(content().json(expectedResponse, true));
    }

    @Test
    void testBookAppointment_WhenSlotIsAvailable_ThenReturnBookedAppointment() throws Exception {
        var payload = readJsonFrom(SEED_MAPPINGS_DIR + "0_available_booking_details_request.json");
        var expectedResponse = readJsonFrom(EXPECTED_MAPPINGS_DIR + "0_available_booked_appointment.json");

        var resultActions = mockMvc.perform(post("/level0/appointmentService/bookAppointment")
                                                            .contentType(MediaType.APPLICATION_JSON_VALUE)
                                                            .content(payload));

        resultActions.andExpect(status().isOk())
                        .andExpect(content().json(expectedResponse, true));
    }

    @Test
    void testBookAppointment_WhenSlotIsNotAvailable_ThenReturnSlotNotAvailable() throws Exception {
        var payload = readJsonFrom(SEED_MAPPINGS_DIR + "0_unavailable_booking_details_request.json");
        var expectedResponse = readJsonFrom(EXPECTED_MAPPINGS_DIR + "0_unavailable_booked_appointment.json");

        var resultActions = mockMvc.perform(post("/level0/appointmentService/bookAppointment")
                                                            .contentType(MediaType.APPLICATION_JSON_VALUE)
                                                            .content(payload));

        resultActions.andExpect(status().isOk())
                        .andExpect(content().json(expectedResponse, true));
    }

}
