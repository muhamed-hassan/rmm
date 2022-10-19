package com.poc.level1;

import java.net.HttpURLConnection;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.level1.dtos.Appointment1;
import com.poc.level1.dtos.BookingDetails1;
import com.poc.level1.dtos.Slot1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
@RequestMapping(
    value = "level1/slots",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
public class Level1SlotResource {

    @ApiOperation("Book appointment")
    @ApiResponses(value = {
        @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Book appointment OR Failed to book appointment, depending on status")
    })
    @PostMapping("{slotId}/appointment")
    public Appointment1 bookAppointment(@PathVariable int slotId, @RequestBody BookingDetails1 bookingDetails) {
        // Loading slot by id
    	
    	var slot = new Slot1().withId(slotId).withDoctor("mjones");
    	
//        var slot = new Slot1();
//        slot.setId(slotId);
//        slot.setDoctor("mjones");
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
