package com.poc.level2;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.level2.dtos.OpenSlotList2;
import com.poc.level2.dtos.Slot2;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
@RequestMapping(
    value = "level2/doctors",
    produces = MediaType.APPLICATION_JSON_VALUE)
public class Level2DoctorResource {

    @ApiOperation("Get open slots")
    @ApiResponses(value = {
        @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Get open slots")
    })
    @GetMapping("{doctorName}/slots")
    public OpenSlotList2 getOpenSlots(@PathVariable String doctorName, @RequestParam @DateTimeFormat(pattern = "yyyyMMdd") Date date, @RequestParam String status) {
        OpenSlotList2 openSlotList = new OpenSlotList2(new ArrayList<Slot2>());
        openSlotList.getSlots().add(new Slot2(1234, 1400, 1450, "mjones"));
        openSlotList.getSlots().add(new Slot2(5678, 1600, 1650, "mjones"));
        return openSlotList;
    }

}
