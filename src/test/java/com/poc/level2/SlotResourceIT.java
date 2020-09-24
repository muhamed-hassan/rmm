package com.poc.level2;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;

import com.poc.BaseIT;

public class SlotResourceIT extends BaseIT {

    @Test
    public void testBookAppointment_WhenSlotIsAvailable_ThenReturnTheLocationOfBookedAppointment() throws Exception {
        String payload = readJsonFrom(SEED_MAPPINGS_DIR + "2_booking_details_request.json");

        MockHttpServletResponse response = mockMvc.perform(post("/level2/slots/1234")
                                                            .contentType(MediaType.APPLICATION_JSON_VALUE)
                                                            .content(payload))
                                                    .andReturn()
                                                    .getResponse();

        Assertions.assertEquals(HttpStatus.CREATED.value(), response.getStatus());
        Assertions.assertTrue(response.getHeader("location").endsWith("/level2/slots/1234/appointment"));
    }

    @Test
    public void testBookAppointment_WhenSlotIsNotAvailable_ThenReturnWithConflict() throws Exception {
        String payload = readJsonFrom(SEED_MAPPINGS_DIR + "2_booking_details_request.json");

        MockHttpServletResponse response = mockMvc.perform(post("/level2/slots/777")
                                                            .contentType(MediaType.APPLICATION_JSON_VALUE)
                                                            .content(payload))
                                                    .andReturn()
                                                    .getResponse();

        Assertions.assertEquals(HttpStatus.CONFLICT.value(), response.getStatus());
    }

    @Test
    public void testGetAppointment_WhenTheSlotIsAvailable_ThenReturnBookedAppointment() throws Exception {
        String expectedResponse = readJsonFrom(EXPECTED_MAPPINGS_DIR + "2_available_booked_appointment.json");

        MockHttpServletResponse response = mockMvc.perform(get("/level2/slots/1234/appointment")
                                                            .accept(MediaType.APPLICATION_JSON_VALUE))
                                                    .andReturn()
                                                    .getResponse();

        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatus());
        JSONAssert.assertEquals(expectedResponse, response.getContentAsString(), true);
    }

}
