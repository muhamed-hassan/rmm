package com.poc.level1;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.level1.dtos.Appointment1;
import com.poc.level1.dtos.BookingDetails1;
import com.poc.level1.dtos.Slot1;

@RestController
@RequestMapping(
    value = "level1/slots",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
public class Level1SlotResource {

    @PostMapping("{slotId}/appointment")
    public Appointment1 bookAppointment(@PathVariable int slotId, @RequestBody BookingDetails1 bookingDetails) {    	
    	var slot = new Slot1().withId(slotId).withDoctor("mjones");
        var appointment = new Appointment1().withSlot(slot).withPatient(bookingDetails.getPatient());
        if (slotId == 1234) {
            slot.withStart(1400).withEnd(1450);
            appointment.withStatus("Slot booked successfully");
        } else {
            slot.withStart(1500).withEnd(1550);
            appointment.withStatus("Slot not available");
        }
        return appointment;
    }

}
