package com.poc.level2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

class SlotResourceIT extends BaseIT {

    @Test
    void shouldReturnStatus201AndLocationOfBookedAppointmentWhenRequestAppointmentAndSlotIsAvailable() 
    		throws Exception {
        var requestBody = readJsonFrom(SEED_MAPPINGS_DIR + "2_booking_details_request.json");        
        var expectedId = 1234;        
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);        
        var httpEntity = new HttpEntity<>(requestBody, headers);
        
        var response = testRestTemplate.exchange(urlFrom("/level2/slots/{slotId}"), 
        		HttpMethod.POST, httpEntity, Void.class, expectedId);
              
        assertNotNull(response);        
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("/level2/slots/" + expectedId + "/appointment", response.getHeaders().getLocation().getPath());
    }

    @Test
    void shouldReturnStatus409WhenRequestAppointmentAndSlotIsNotAvailable() 
    		throws Exception {
        var requestBody = readJsonFrom(SEED_MAPPINGS_DIR + "2_booking_details_request.json");
        var expectedId = 777;        
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);        
        var httpEntity = new HttpEntity<>(requestBody, headers);
        
        var response = testRestTemplate.exchange(urlFrom("/level2/slots/{slotId}"), 
        		HttpMethod.POST, httpEntity, Void.class, expectedId);
        
        assertNotNull(response);        
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

    @Test
    void shouldReturnStatus200AndBookedAppointmentWhenSlotHaveBookedAppointment() 
    		throws Exception {
        var slotId = 1234;        
        var expectedSlot = new Slot2().withId(slotId).withStart(1400).withEnd(1450).withDoctor("mjones");
    	var expectedAppointment = new Appointment2().withSlot(expectedSlot).withPatient("jsmith");          
        var headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));        
        var httpEntity = new HttpEntity<>(headers);

        var response = testRestTemplate.exchange(urlFrom("/level2/slots/{slotId}/appointment"), 
        		HttpMethod.GET, httpEntity, Appointment2.class, slotId);     
                
        assertNotNull(response);  
        var body = response.getBody();
		assertNotNull(body);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedAppointment, body);
    }

}
