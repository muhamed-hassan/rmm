package com.poc.level2;

import java.net.HttpURLConnection;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.poc.level2.dtos.Appointment2;
import com.poc.level2.dtos.BookingDetails2;
import com.poc.level2.dtos.Slot2;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
@RequestMapping(
    value = "level2/slots",
    produces = MediaType.APPLICATION_JSON_VALUE)
public class Level2SlotResource {

    @ApiOperation("Book appointment")
    @ApiResponses(value = {
        @ApiResponse(code = HttpURLConnection.HTTP_CREATED, message = "Book appointment"),
        @ApiResponse(code = HttpURLConnection.HTTP_CONFLICT, message = "Failed to book appointment")
    })
    @PostMapping(value = "{slotId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> bookAppointment(@PathVariable int slotId, @RequestBody BookingDetails2 bookingDetails) {
        ResponseEntity.BodyBuilder bodyBuilder = null;
        if (slotId == 1234) {
            bodyBuilder = ResponseEntity
                                .status(HttpStatus.CREATED)
                                .location(ServletUriComponentsBuilder
                                    .fromCurrentRequest()
                                    .path("/appointment")
                                    .build()
                                    .toUri());
        } else {
            bodyBuilder = ResponseEntity.status(HttpStatus.CONFLICT);
        }
        return bodyBuilder.build();
    }

    @ApiOperation("Get appointment")
    @ApiResponses(value = {
        @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Get appointment")
    })
    @GetMapping("{slotId}/appointment")
    public ResponseEntity<Appointment2> getAppointment(@PathVariable int slotId) {
    	var slot = new Slot2().withId(slotId).withStart(1400).withEnd(1450).withDoctor("mjones");
    	var appointment = new Appointment2().withSlot(slot).withPatient("jsmith");    	
        return ResponseEntity.ok(appointment);
    }

}
