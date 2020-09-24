package com.poc.level3;

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

import com.poc.level3.dtos.Appointment3;
import com.poc.level3.dtos.BookingDetails3;
import com.poc.level3.dtos.Slot3;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
@RequestMapping("level3/slots")
public class Level3SlotResource extends BaseResource {

    private static final String BASE_API_URI = "/level3/slots";

    @ApiOperation("Book appointment")
    @ApiResponses(value = {
        @ApiResponse(code = HttpURLConnection.HTTP_CREATED, message = "Book appointment"),
        @ApiResponse(code = HttpURLConnection.HTTP_CONFLICT, message = "Failed to book appointment")
    })
    @PostMapping(value = "{slotId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> bookAppointment(@PathVariable int slotId, @RequestBody BookingDetails3 bookingDetails) {
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
    @GetMapping(value = "{slotId}/appointment", produces = "application/hal+json")
    public Appointment3 getAppointment(@PathVariable int slotId) {
        Appointment3 appointment = new Appointment3(new Slot3(slotId, 1400, 1450, "mjones")
                                                        .withLink(constructUri(BASE_API_URI, "/" + slotId)),
                                            "jsmith")
                            .withSelfLink(constructUri(BASE_API_URI, "/" + slotId + "/appointment"))
                            .withCancelLink(constructUri(BASE_API_URI, "/" + slotId + "/appointment"))
                            .withAddTestLink(constructUri(BASE_API_URI, "/" + slotId + "/tests"))
                            .withReScheduleLink(constructUri(BASE_API_URI, "/" + slotId))
                            .withHelpLink(constructUri(BASE_API_URI, "/" + slotId + "/help/appointment"));
        return appointment;
    }

}
