package com.poc.level3;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.poc.level3.models.Appointment3;
import com.poc.level3.models.BookingDetails3;
import com.poc.level3.models.Slot3;

@RestController
@RequestMapping("level3/slots")
public class Level3SlotResource {

    private static final String BASE_API_URI = "/level3/slots";

    @RequestMapping(method = RequestMethod.POST, value = "{slotId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> bookAppointment(@PathVariable int slotId, @RequestBody BookingDetails3 bookingDetails) {
    	ResponseEntity<Object> responseEntity = null;
        if (slotId == 1234) {        	
        	MultiValueMap<String, String> httpHeaders = new HttpHeaders();
        	httpHeaders.add("Location", ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/appointment").build().toUri().toString());
        	responseEntity = new ResponseEntity<Object>(httpHeaders, HttpStatus.CREATED);
        } else {            
            responseEntity = new ResponseEntity<Object>(HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @RequestMapping(method = RequestMethod.GET, value = "{slotId}/appointment", produces = "application/hal+json")
    public ResponseEntity<Appointment3> getAppointment(@PathVariable int slotId) {
    	Slot3 slot = new Slot3().withLink(BASE_API_URI + "/" + slotId);    	
        slot.setId(slotId);
        slot.setStart(1400);
        slot.setEnd(1450);
        slot.setDoctor("mjones");        
        Appointment3 appointment = new Appointment3()
                            .withSelfLink(BASE_API_URI + "/" + slotId + "/appointment")
                            .withCancelLink(BASE_API_URI + "/" + slotId + "/appointment")
                            .withAddTestLink(BASE_API_URI + "/" + slotId + "/tests")
                            .withReScheduleLink(BASE_API_URI + "/" + slotId)
                            .withHelpLink(BASE_API_URI + "/" + slotId + "/help/appointment");
        appointment.setSlot(slot);
        appointment.setPatient("jsmith");
        return new ResponseEntity<Appointment3>(appointment, HttpStatus.OK);
    }

}
