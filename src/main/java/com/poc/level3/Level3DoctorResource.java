package com.poc.level3;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.level2.dtos.Slot2;
import com.poc.level3.dtos.OpenSlotList3;
import com.poc.level3.dtos.Slot3;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
@RequestMapping(
    value = "level3/doctors",
    produces = "application/hal+json")
public class Level3DoctorResource extends BaseResource {

    private static final String BASE_API_URI = "/level3/doctors";

    @ApiOperation("Get open slots")
    @ApiResponses(value = {
        @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Get open slots")
    })
    @GetMapping("{doctorName}/slots")
    public ResponseEntity<OpenSlotList3> getOpenSlots(@PathVariable String doctorName, @RequestParam @DateTimeFormat(pattern = "yyyyMMdd") Date date) {
    	var slot1 = new Slot3().withId(1234).withStart(1400).withEnd(1450).withDoctor(doctorName).withLink(constructUri(BASE_API_URI, "/1234"));
    	var slot2 = new Slot3().withId(5678).withStart(1600).withEnd(1650).withDoctor(doctorName).withLink(constructUri(BASE_API_URI, "/5678"));    	
    	var openSlotList = new OpenSlotList3();
    	openSlotList.setSlots(List.of(slot1, slot2));
        return ResponseEntity.ok(openSlotList);
    }

}
