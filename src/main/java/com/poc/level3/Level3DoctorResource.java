package com.poc.level3;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public OpenSlotList3 getOpenSlots(@PathVariable String doctorName, @RequestParam @DateTimeFormat(pattern = "yyyyMMdd") Date date, @RequestParam String status) {
        OpenSlotList3 openSlotList = new OpenSlotList3(new ArrayList<Slot3>());

        Slot3 slot1 = new Slot3(1234, 1400, 1450, "mjones")
                            .withLink(constructUri(BASE_API_URI, "/1234"));

        Slot3 slot2 = new Slot3(5678, 1600, 1650, "mjones")
                            .withLink(constructUri(BASE_API_URI, "/5678"));

        openSlotList.getSlots().add(slot1);
        openSlotList.getSlots().add(slot2);

        return openSlotList;
    }

}
