package com.poc.level2;

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

import com.poc.level2.models.Appointment2;
import com.poc.level2.models.BookingDetails2;
import com.poc.level2.models.Slot2;

@RestController
@RequestMapping(
    value = "level2/slots",
    produces = MediaType.APPLICATION_JSON_VALUE)
public class Level2SlotResource {

    @RequestMapping(method = RequestMethod.POST, value = "{slotId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> bookAppointment(@PathVariable int slotId, @RequestBody BookingDetails2 bookingDetails) {
    	ResponseEntity<Void> responseEntity = null;
        if (slotId == 1234) {        	
        	MultiValueMap<String, String> httpHeaders = new HttpHeaders();
        	httpHeaders.add("Location", ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/appointment").build().toUri().toString());
        	responseEntity = new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);
        } else {            
            responseEntity = new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @RequestMapping(method = RequestMethod.GET, value = "{slotId}/appointment")
    public ResponseEntity<Appointment2> getAppointment(@PathVariable int slotId) {
    	Slot2 slot = new Slot2();
        slot.setId(slotId);
        slot.setStart(1400);
        slot.setEnd(1450);
        slot.setDoctor("mjones");
        Appointment2 appointment = new Appointment2();    	
        appointment.setSlot(slot);
        appointment.setPatient("jsmith");
        return new ResponseEntity<Appointment2>(appointment, HttpStatus.OK);
    }

}
