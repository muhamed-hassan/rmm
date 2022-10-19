package com.poc.level3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.poc.BaseIT;
import com.poc.level2.dtos.Appointment2;
import com.poc.level2.dtos.Slot2;
import com.poc.level3.dtos.Appointment3;
import com.poc.level3.dtos.Slot3;

class SlotResourceIT extends BaseIT {

    @Test
    void shouldReturnStatus201AndLocationOfBookedAppointmentWhenRequestAppointmentAndSlotIsAvailable() throws Exception {
        var requestBody = readJsonFrom(SEED_MAPPINGS_DIR + "3_booking_details_request.json");

//        var resultActions = mockMvc.perform(post("/level3/slots/1234")
//                                                            .contentType(MediaType.APPLICATION_JSON_VALUE).content(requestBody));
//
//        resultActions.andExpect(status().isCreated())
//                        .andExpect(header().exists("Location"));
        
        var expectedId = 1234;
        
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        var httpEntity = new HttpEntity<>(requestBody, headers);
        
        var response = testRestTemplate.exchange(BASE_URI_WITHOUT_PORT + serverPort + "/level3/slots/" + expectedId, 
        		HttpMethod.POST, httpEntity, Void.class);
        
        assertNotNull(response);        
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("/level3/slots/1234/appointment", response.getHeaders().getLocation().getPath());
    }

    @Test
    void shouldReturnStatus409WhenRequestAppointmentAndSlotIsNotAvailable() throws Exception {
        var requestBody = readJsonFrom(SEED_MAPPINGS_DIR + "3_booking_details_request.json");

//        var resultActions = mockMvc.perform(post("/level3/slots/777")
//                                                            .contentType(MediaType.APPLICATION_JSON_VALUE).content(requestBody));
//
//        resultActions.andExpect(status().isConflict());
        
        var expectedId = 777;
        
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON); 
        var httpEntity = new HttpEntity<>(requestBody, headers);
        
        var response = testRestTemplate.exchange(BASE_URI_WITHOUT_PORT + serverPort + "/level3/slots/" + expectedId, 
        		HttpMethod.POST, httpEntity, Void.class);
        
        assertNotNull(response);        
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

    @Test
    void shouldReturnStatus200AndBookedAppointmentWhenSlotHaveBookedAppointment() throws Exception {
        var expectedResponse = readJsonFrom(EXPECTED_MAPPINGS_DIR + "3_available_booked_appointment.json");

//        var resultActions = mockMvc.perform(get("/level3/slots/1234/appointment")
//                                                            .accept("application/hal+json"));
//
//        resultActions.andExpect(status().isOk())
//                        .andExpect(content().json(expectedResponse, true));
        
        var slotId = 1234;
        
        var expectedDoctor = "mjones";
        var expectedSlot = new Slot3().withId(slotId).withStart(1400).withEnd(1450).withDoctor(expectedDoctor)
        		.withLink(BASE_URI_WITHOUT_PORT + serverPort + "/level3/doctors/" + slotId);    	
    	var expectedAppointment = new Appointment3()
				.withSlot(expectedSlot)
				.withPatient("jsmith")
                .withSelfLink(BASE_URI_WITHOUT_PORT + serverPort + "/level3/slots/" + slotId + "/appointment")
                .withCancelLink(BASE_URI_WITHOUT_PORT + serverPort + "/level3/slots/" + slotId + "/appointment")
                .withAddTestLink(BASE_URI_WITHOUT_PORT + serverPort + "/level3/slots/" + slotId + "/tests")
                .withReScheduleLink(BASE_URI_WITHOUT_PORT + serverPort + "/level3/slots/" + slotId)
                .withHelpLink(BASE_URI_WITHOUT_PORT + serverPort + "/level3/slots/" + slotId + "/help/appointment");
        
        var headers = new HttpHeaders();
        //headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Accept", "application/hal+json");  
        
        var httpEntity = new HttpEntity<>(headers);

        var response = testRestTemplate.exchange(BASE_URI_WITHOUT_PORT + serverPort + "/level3/slots/{slotId}/appointment", 
        		HttpMethod.GET, httpEntity, Appointment3.class, slotId);
        
        
        
        assertNotNull(response);  
        var body = response.getBody();
		assertNotNull(body);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedAppointment, body);
    }

}
