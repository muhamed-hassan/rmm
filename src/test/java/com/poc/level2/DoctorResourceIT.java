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
import com.poc.level2.dtos.OpenSlotList2;
import com.poc.level2.dtos.Slot2;

class DoctorResourceIT extends BaseIT {

    @Test
    void shouldReturnAvailableSlotsWhenInquiryThem() 
    		throws Exception {
    	var expectedDoctor = "mjones";
        var expectedSlot1 = new Slot2().withId(1234).withStart(1400).withEnd(1450).withDoctor(expectedDoctor);
    	var expectedSlot2 = new Slot2().withId(5678).withStart(1600).withEnd(1650).withDoctor(expectedDoctor);
        var expectedOpenSlotList = new OpenSlotList2();
        expectedOpenSlotList.setSlots(List.of(expectedSlot1, expectedSlot2));        
        var headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));        
        var httpEntity = new HttpEntity<>(headers);

        var response = testRestTemplate.exchange(BASE_URI_WITHOUT_PORT + serverPort + "/level2/doctors/{doctorName}/slots?date={date}", 
        		HttpMethod.GET, httpEntity, OpenSlotList2.class, expectedDoctor, "20100104");
        
        assertNotNull(response);        
        var body = response.getBody();
        assertNotNull(body);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedOpenSlotList.getSlots(), body.getSlots());
    }

}
