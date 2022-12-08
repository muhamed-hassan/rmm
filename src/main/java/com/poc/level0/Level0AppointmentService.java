package com.poc.level0;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.level0.dtos.Appointment0;
import com.poc.level0.dtos.BookingDetails0;
import com.poc.level0.dtos.OpenSlot0;
import com.poc.level0.dtos.OpenSlotList0;
import com.poc.level0.dtos.Slot0;

@RestController
@RequestMapping(
    value = "level0/appointmentService",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
public class Level0AppointmentService {

    @PostMapping("getOpenSlots")
    public OpenSlotList0 getOpenSlots(@RequestBody OpenSlot0 openSlot) {
    	var slot1 = new Slot0().withStart(1400).withEnd(1450).withDoctor(openSlot.getDoctor());
    	var slot2 = new Slot0().withStart(1600).withEnd(1650).withDoctor(openSlot.getDoctor());    	
        var openSlotList = new OpenSlotList0();
        openSlotList.setSlots(List.of(slot1, slot2));
        return openSlotList;
    }

    @PostMapping("bookAppointment")
    public Appointment0 bookAppointment(@RequestBody BookingDetails0 bookingDetails) {
        var appointment = new Appointment0();
        appointment.setSlot(bookingDetails.getSlot());
        appointment.setPatient(bookingDetails.getPatient());
        if (bookingDetails.getSlot().getStart() == 1400) {
            appointment.setStatus("Slot booked successfully");
        } else {
            appointment.setStatus("Slot not available");
        }
        return appointment;
    }

}
