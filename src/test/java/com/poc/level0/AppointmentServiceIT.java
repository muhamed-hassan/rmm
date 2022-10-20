package com.poc.level0;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.poc.BaseIT;
import com.poc.level0.dtos.Appointment0;
import com.poc.level0.dtos.OpenSlotList0;
import com.poc.level0.dtos.Slot0;

class AppointmentServiceIT extends BaseIT {

    @Test
    void shouldReturnAvailableSlotsWhenInquiryThem() 
    		throws Exception {
        var requestBody = readJsonFrom(SEED_MAPPINGS_DIR + "0_open_slot_request.json");        
        var expectedDoctor = "mjones";
        var expectedSlot1 = new Slot0().withStart(1400).withEnd(1450).withDoctor(expectedDoctor);
    	var expectedSlot2 = new Slot0().withStart(1600).withEnd(1650).withDoctor(expectedDoctor);    	
        var expectedOpenSlotList = new OpenSlotList0();
        expectedOpenSlotList.setSlots(List.of(expectedSlot1, expectedSlot2));        
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));        
        var httpEntity = new HttpEntity<>(requestBody, headers);

        var response = testRestTemplate.postForObject(urlFrom("/level0/appointmentService/getOpenSlots"), 
        		httpEntity, OpenSlotList0.class);
        
        assertNotNull(response);
        assertEquals(expectedOpenSlotList.getSlots(), response.getSlots());
    }

    @Test
    void shouldReturnBookedAppointmentWhenRequestItAndSlotIsAvailable() 
    		throws Exception {
        var requestBody = readJsonFrom(SEED_MAPPINGS_DIR + "0_available_booking_details_request.json");        
        var expectedSlot = new Slot0().withStart(1400).withEnd(1450).withDoctor("mjones");
        var expectedAppointment = new Appointment0();
        expectedAppointment.setSlot(expectedSlot);
        expectedAppointment.setPatient("jsmith");
        expectedAppointment.setStatus("Slot booked successfully");        
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));        
        var httpEntity = new HttpEntity<>(requestBody, headers);

        var response = testRestTemplate.postForObject(urlFrom("/level0/appointmentService/bookAppointment"), 
        		httpEntity, Appointment0.class);
        
        assertNotNull(response);
        assertEquals(expectedAppointment, response);
    }

    @Test
    void shouldReturnSlotNotAvailableWhenRequestAppointmentAndSlotIsNotAvailable() 
    		throws Exception {
        var requestBody = readJsonFrom(SEED_MAPPINGS_DIR + "0_unavailable_booking_details_request.json");
        var expectedSlot = new Slot0().withStart(1500).withEnd(1550).withDoctor("mjones");
        var expectedAppointment = new Appointment0();
        expectedAppointment.setSlot(expectedSlot);
        expectedAppointment.setPatient("jsmith");
        expectedAppointment.setStatus("Slot not available");        
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));        
        var httpEntity = new HttpEntity<>(requestBody, headers);

        var response = testRestTemplate.postForObject(urlFrom("/level0/appointmentService/bookAppointment"), 
        		httpEntity, Appointment0.class);
        
        assertNotNull(response);
        assertEquals(expectedAppointment, response);
    }

}
