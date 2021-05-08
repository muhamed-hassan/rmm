package com.poc.level0;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import com.poc.BaseIT;

class AppointmentServiceIT extends BaseIT {

    @Test
    void shouldReturnAvailableSlotsWhenInquiryThem() throws Exception {
        var requestBody = readJsonFrom(SEED_MAPPINGS_DIR + "0_open_slot_request.json");
        var expectedResponse = readJsonFrom(EXPECTED_MAPPINGS_DIR + "0_available_slots.json");

        var resultActions
             = mockMvc.perform(post("/level0/appointmentService/getOpenSlots")
                                                            .contentType(MediaType.APPLICATION_JSON_VALUE)
                                                            .content(requestBody));

        resultActions.andExpect(status().isOk())
                        .andExpect(content().json(expectedResponse, true));
    }

    @Test
    void shouldReturnBookedAppointmentWhenRequestItAndSlotIsAvailable() throws Exception {
        var requestBody = readJsonFrom(SEED_MAPPINGS_DIR + "0_available_booking_details_request.json");
        var expectedResponse = readJsonFrom(EXPECTED_MAPPINGS_DIR + "0_available_booked_appointment.json");

        var resultActions = mockMvc.perform(post("/level0/appointmentService/bookAppointment")
                                                            .contentType(MediaType.APPLICATION_JSON_VALUE)
                                                            .content(requestBody));

        resultActions.andExpect(status().isOk())
                        .andExpect(content().json(expectedResponse, true));
    }

    @Test
    void shouldReturnSlotNotAvailableWhenRequestAppointmentAndSlotIsNotAvailable() throws Exception {
        var requestBody = readJsonFrom(SEED_MAPPINGS_DIR + "0_unavailable_booking_details_request.json");
        var expectedResponse = readJsonFrom(EXPECTED_MAPPINGS_DIR + "0_unavailable_booked_appointment.json");

        var resultActions = mockMvc.perform(post("/level0/appointmentService/bookAppointment")
                                                            .contentType(MediaType.APPLICATION_JSON_VALUE)
                                                            .content(requestBody));

        resultActions.andExpect(status().isOk())
                        .andExpect(content().json(expectedResponse, true));
    }

}
