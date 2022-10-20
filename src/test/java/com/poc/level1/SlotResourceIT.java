package com.poc.level1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.poc.BaseIT;
import com.poc.level1.dtos.Appointment1;
import com.poc.level1.dtos.Slot1;

class SlotResourceIT extends BaseIT {

    @Test
    void shouldReturnBookedAppointmentWhenRequestItAndSlotIsAvailable() 
    		throws Exception {
        var requestBody = readJsonFrom(SEED_MAPPINGS_DIR + "1_booking_details_request.json");        
        var expectedId = 1234;
        var expectedSlot = new Slot1().withId(expectedId).withStart(1400).withEnd(1450).withDoctor("mjones");
        var expectedAppointment = new Appointment1();
        expectedAppointment.setSlot(expectedSlot);
        expectedAppointment.setPatient("jsmith");
        expectedAppointment.setStatus("Slot booked successfully");        
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));        
        var httpEntity = new HttpEntity<>(requestBody, headers);

        var response = testRestTemplate.postForObject(urlFrom("/level1/slots/{slotId}/appointment"), 
        		httpEntity, Appointment1.class, expectedId);
        
        assertNotNull(response);
        assertEquals(expectedAppointment, response);
    }

    @Test
    void shouldReturnSlotNotAvailableWhenRequestAppointmentAndSlotIsNotAvailable() 
    		throws Exception {
        var requestBody = readJsonFrom(SEED_MAPPINGS_DIR + "1_booking_details_request.json");        
        var expectedId = 777;
        var expectedSlot = new Slot1().withId(expectedId).withStart(1500).withEnd(1550).withDoctor("mjones");
        var expectedAppointment = new Appointment1();
        expectedAppointment.setSlot(expectedSlot);
        expectedAppointment.setPatient("jsmith");
        expectedAppointment.setStatus("Slot not available");
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));        
        var httpEntity = new HttpEntity<>(requestBody, headers);

        var response = testRestTemplate.postForObject(urlFrom("/level1/slots/{slotId}/appointment"), 
        		httpEntity, Appointment1.class, expectedId);
        
        assertNotNull(response);
        assertEquals(expectedAppointment, response);
    }

}
