package com.poc.level3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.poc.BaseIT;
import com.poc.level3.dtos.Appointment3;
import com.poc.level3.dtos.Slot3;

class SlotResourceIT extends BaseIT {

    @Test
    void shouldReturnStatus201AndLocationOfBookedAppointmentWhenRequestAppointmentAndSlotIsAvailable() 
    		throws Exception {
        var requestBody = readJsonFrom(SEED_MAPPINGS_DIR + "3_booking_details_request.json");        
        var expectedId = 1234;        
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);        
        var httpEntity = new HttpEntity<>(requestBody, headers);
        
        var response = testRestTemplate.exchange(urlFrom("/level3/slots/{slotId}"), 
        		HttpMethod.POST, httpEntity, Void.class, expectedId);
        
        assertNotNull(response);        
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("/level3/slots/1234/appointment", response.getHeaders().getLocation().getPath());
    }

    @Test
    void shouldReturnStatus409WhenRequestAppointmentAndSlotIsNotAvailable() 
    		throws Exception {
        var requestBody = readJsonFrom(SEED_MAPPINGS_DIR + "3_booking_details_request.json");        
        var expectedId = 777;        
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON); 
        var httpEntity = new HttpEntity<>(requestBody, headers);
        
        var response = testRestTemplate.exchange(urlFrom("/level3/slots/{slotId}"), 
        		HttpMethod.POST, httpEntity, Void.class, expectedId);
        
        assertNotNull(response);        
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

    @Test
    void shouldReturnStatus200AndBookedAppointmentWhenSlotHaveBookedAppointment() 
    		throws Exception {        
        var slotId = 1234;        
        var expectedDoctor = "mjones";
        var expectedSlot = new Slot3().withLink(urlFrom("/level3/doctors/" + slotId));  
        expectedSlot.setId(slotId);  
        expectedSlot.setStart(1400);
        expectedSlot.setEnd(1450);
        expectedSlot.setDoctor(expectedDoctor);
    	var expectedAppointment = new Appointment3()
                .withSelfLink(urlFrom("/level3/slots/" + slotId + "/appointment"))
                .withCancelLink(urlFrom("/level3/slots/" + slotId + "/appointment"))
                .withAddTestLink(urlFrom("/level3/slots/" + slotId + "/tests"))
                .withReScheduleLink(urlFrom("/level3/slots/" + slotId))
                .withHelpLink(urlFrom("/level3/slots/" + slotId + "/help/appointment"));     
        expectedAppointment.setSlot(expectedSlot);
        expectedAppointment.setPatient("jsmith");           
        var headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCEPT, "application/hal+json");          
        var httpEntity = new HttpEntity<>(headers);

        var response = testRestTemplate.exchange(urlFrom("/level3/slots/{slotId}/appointment"), 
        		HttpMethod.GET, httpEntity, Appointment3.class, slotId);
        
        assertNotNull(response);  
        var body = response.getBody();
		assertNotNull(body);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedAppointment, body);
    }

}
