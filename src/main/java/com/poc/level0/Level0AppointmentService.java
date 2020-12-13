package com.poc.level0;

import java.net.HttpURLConnection;
import java.util.ArrayList;

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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
@RequestMapping(
    value = "level0/appointmentService",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
public class Level0AppointmentService {

    @ApiOperation("Get open slots")
    @ApiResponses(value = {
        @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Get open slots")
    })
    @PostMapping("getOpenSlots")
    public OpenSlotList0 getOpenSlots(@RequestBody OpenSlot0 openSlot) {
        var openSlotList = new OpenSlotList0(new ArrayList<>());
        openSlotList.getSlots().add(new Slot0(1400, 1450, openSlot.getDoctor()));
        openSlotList.getSlots().add(new Slot0(1600, 1650, openSlot.getDoctor()));
        return openSlotList;
    }

    @ApiOperation("Book appointment")
    @ApiResponses(value = {
        @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Book appointment OR Failed to book appointment, depending on status")
    })
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
