package com.poc.level0;

import java.util.ArrayList;
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
    	Slot0 slot1 = new Slot0();
        slot1.setStart(1400);
        slot1.setEnd(1450);
        slot1.setDoctor(openSlot.getDoctor());
        Slot0 slot2 = new Slot0();
        slot2.setStart(1600);
        slot2.setEnd(1650);
        slot2.setDoctor(openSlot.getDoctor());   	
        OpenSlotList0 openSlotList = new OpenSlotList0();
        List<Slot0> slots = new ArrayList<Slot0>();
        slots.add(slot1);
        slots.add(slot2);
        openSlotList.setSlots(slots);
        return openSlotList;
    }

    @PostMapping("bookAppointment")
    public Appointment0 bookAppointment(@RequestBody BookingDetails0 bookingDetails) {
    	Appointment0 appointment = new Appointment0();
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
