package com.poc.level3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import com.poc.BaseIT;
import com.poc.level3.dtos.OpenSlotList3;
import com.poc.level3.dtos.Slot3;

class DoctorResourceIT extends BaseIT {
	
    @Test
    void shouldReturnAvailableSlotsWhenInquiryThem() 
    		throws Exception {        
        var expectedDoctor = "mjones";
        var expectedSlotId1 = 1234;
        var expectedSlot1 = new Slot3().withLink(urlFrom("/level3/doctors/" + expectedSlotId1));
        expectedSlot1.setId(expectedSlotId1);
        expectedSlot1.setStart(1400);
        expectedSlot1.setEnd(1450);
        expectedSlot1.setDoctor(expectedDoctor);
        var expectedSlotId2 = 5678;
    	var expectedSlot2 = new Slot3().withLink(urlFrom("/level3/doctors/" + expectedSlotId2));
        expectedSlot2.setId(expectedSlotId2);
        expectedSlot2.setStart(1600);
        expectedSlot2.setEnd(1650);
        expectedSlot2.setDoctor(expectedDoctor);        
        var expectedOpenSlotList = new OpenSlotList3();
        expectedOpenSlotList.setSlots(List.of(expectedSlot1, expectedSlot2));        
        var headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCEPT, "application/hal+json");        
        var httpEntity = new HttpEntity<>(headers);

        var response = testRestTemplate.exchange(urlFrom("/level3/doctors/{doctorName}/slots?date={date}"), 
        		HttpMethod.GET, httpEntity, OpenSlotList3.class, expectedDoctor, "20100104");
                        
        assertNotNull(response);     
        var body = response.getBody();
		assertNotNull(body);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedOpenSlotList.getSlots(), body.getSlots());
    }

}
