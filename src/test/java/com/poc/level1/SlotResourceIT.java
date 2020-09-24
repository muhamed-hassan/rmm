package com.poc.level1;

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
    public void testBookAppointment_WhenSlotIsAvailable_ThenReturnBookedAppointment() throws Exception {
        String payload = readJsonFrom(SEED_MAPPINGS_DIR + "1_booking_details_request.json");
        String expectedResponse = readJsonFrom(EXPECTED_MAPPINGS_DIR + "1_available_booked_appointment.json");

        MockHttpServletResponse response = mockMvc.perform(post("/level1/slots/1234/appointment")
                                                            .contentType(MediaType.APPLICATION_JSON_VALUE)
                                                            .content(payload))
                                                    .andReturn()
                                                    .getResponse();

        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatus());
        JSONAssert.assertEquals(expectedResponse, response.getContentAsString(), true);
    }

    @Test
    public void testBookAppointment_WhenSlotIsNotAvailable_ThenReturnSlotNotAvailable() throws Exception {
        String payload = readJsonFrom(SEED_MAPPINGS_DIR + "1_booking_details_request.json");
        String expectedResponse = readJsonFrom(EXPECTED_MAPPINGS_DIR + "1_unavailable_booked_appointment.json");

        MockHttpServletResponse response = mockMvc.perform(post("/level1/slots/777/appointment")
                                                            .contentType(MediaType.APPLICATION_JSON_VALUE)
                                                            .content(payload))
                                                    .andReturn()
                                                    .getResponse();

        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatus());
        JSONAssert.assertEquals(expectedResponse, response.getContentAsString(), true);
    }

}
