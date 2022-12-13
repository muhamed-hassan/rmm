package com.poc.level1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.poc.BaseIT;
import com.poc.level1.dtos.OpenSlotList1;
import com.poc.level1.dtos.Slot1;

class DoctorResourceIT extends BaseIT {

    @Test
    void shouldReturnAvailableSlotsWhenInquiryThem() 
    		throws Exception {
        var requestBody = readJsonFrom(SEED_MAPPINGS_DIR + "1_open_slot_request.json");        
        var expectedDoctor = "mjones";
        var expectedSlot1 = new Slot1();
        expectedSlot1.setId(1234);
        expectedSlot1.setStart(1400);
        expectedSlot1.setEnd(1450);
        expectedSlot1.setDoctor(expectedDoctor);
    	var expectedSlot2 = new Slot1(); 
        expectedSlot2.setId(5678);
        expectedSlot2.setStart(1600);
        expectedSlot2.setEnd(1650);
        expectedSlot2.setDoctor(expectedDoctor);
        var expectedOpenSlotList = new OpenSlotList1();
        expectedOpenSlotList.setSlots(List.of(expectedSlot1, expectedSlot2));        
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));        
        var httpEntity = new HttpEntity<>(requestBody, headers);

        var response = testRestTemplate.postForObject(urlFrom("/level1/doctors/{doctorName}"), 
        		httpEntity, OpenSlotList1.class, expectedDoctor);
                
        assertNotNull(response);
        assertEquals(expectedOpenSlotList.getSlots(), response.getSlots());
    }

}
