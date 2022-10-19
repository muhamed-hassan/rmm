package com.poc.level3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.poc.BaseIT;
import com.poc.level2.dtos.OpenSlotList2;
import com.poc.level2.dtos.Slot2;
import com.poc.level3.dtos.OpenSlotList3;
import com.poc.level3.dtos.Slot3;

class DoctorResourceIT extends BaseIT {


	
    @Test
    void shouldReturnAvailableSlotsWhenInquiryThem() throws Exception {
        var expectedResponse = readJsonFrom(EXPECTED_MAPPINGS_DIR + "3_available_slots.json");

//        var resultActions = mockMvc.perform(get("/level3/doctors/mjones/slots")
//                                                            .params(prepareRequestParameters())
//                                                            .accept("application/hal+json"));
//
//        resultActions.andExpect(status().isOk())
//                        .andExpect(content().json(expectedResponse, true));
        
        var expectedDoctor = "mjones";
        var expectedSlot1 = new Slot3().withId(1234).withStart(1400).withEnd(1450).withDoctor(expectedDoctor)
        		.withLink(BASE_URI_WITHOUT_PORT + serverPort + "/level3/doctors/1234");
    	var expectedSlot2 = new Slot3().withId(5678).withStart(1600).withEnd(1650).withDoctor(expectedDoctor)
    			.withLink(BASE_URI_WITHOUT_PORT + serverPort + "/level3/doctors/5678");
        var expectedOpenSlotList = new OpenSlotList3();
        expectedOpenSlotList.setSlots(List.of(expectedSlot1, expectedSlot2));
        
        var headers = new HttpHeaders();
        //headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Accept", "application/hal+json");        
        var httpEntity = new HttpEntity<>(headers);

        var response = testRestTemplate.exchange(BASE_URI_WITHOUT_PORT + serverPort + "/level3/doctors/" + expectedDoctor + "/slots?date={date}", 
        		HttpMethod.GET, httpEntity, OpenSlotList3.class, "20100104");
        var body = response.getBody();
        
        
        assertNotNull(response);        
		assertNotNull(body);
		System.out.println("body: " + body);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedOpenSlotList.getSlots(), body.getSlots());
    }

    private LinkedMultiValueMap<String, String> prepareRequestParameters() {
        var params = new LinkedMultiValueMap<String, String>();
        params.add("date", "20100104");
        //params.add("status", "open");
        return params;
    }

}
