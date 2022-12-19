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
    	Slot1 slot = new Slot1();
        slot.setId(slotId);
        slot.setDoctor("mjones");
        Appointment1 appointment = new Appointment1();
        appointment.setSlot(slot);
        appointment.setPatient(bookingDetails.getPatient());
        if (slotId == 1234) {
            slot.setStart(1400);
            slot.setEnd(1450);
            appointment.setStatus("Slot booked successfully");
        } else {
            slot.setStart(1500);
            slot.setEnd(1550);
            appointment.setStatus("Slot not available");
        }
        return appointment;
    }

}
