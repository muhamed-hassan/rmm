package com.poc.level1;

import java.net.HttpURLConnection;
import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.level1.dtos.OpenSlot1;
import com.poc.level1.dtos.OpenSlotList1;
import com.poc.level1.dtos.Slot1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
@RequestMapping(
    value = "level1/doctors",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
public class Level1DoctorResource {

    @ApiOperation("Get open slots")
    @ApiResponses(value = {
        @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Get open slots")
    })
    @PostMapping("{doctorName}")
    public OpenSlotList1 getOpenSlots(@PathVariable String doctorName, @RequestBody OpenSlot1 openSlot) {
        OpenSlotList1 openSlotList = new OpenSlotList1(new ArrayList<Slot1>());
        openSlotList.getSlots().add(new Slot1(1234, 1400, 1450, "mjones"));
        openSlotList.getSlots().add(new Slot1(5678, 1600, 1650, "mjones"));
        return openSlotList;
    }

}
