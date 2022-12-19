package com.poc.level3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.level3.models.OpenSlotList3;
import com.poc.level3.models.Slot3;

@RestController
@RequestMapping(
    value = "level3/doctors",
    produces = "application/hal+json")
public class Level3DoctorResource extends BaseResource {

    private static final String BASE_API_URI = "/level3/doctors";

    @RequestMapping(method = RequestMethod.GET, value = "{doctorName}/slots")
    public ResponseEntity<OpenSlotList3> getOpenSlots(@PathVariable String doctorName, @RequestParam @DateTimeFormat(pattern = "yyyyMMdd") Date date) {
    	Slot3 slot1 = new Slot3().withLink(constructUri(BASE_API_URI, "/1234"));
    	slot1.setId(1234);
        slot1.setStart(1400);
        slot1.setEnd(1450);
        slot1.setDoctor(doctorName);
        Slot3 slot2 = new Slot3().withLink(constructUri(BASE_API_URI, "/5678"));    	
    	slot2.setId(5678);
        slot2.setStart(1600);
        slot2.setEnd(1650);
        slot2.setDoctor(doctorName);
        OpenSlotList3 openSlotList = new OpenSlotList3();
        List<Slot3> slots = new ArrayList<Slot3>();
        slots.add(slot1);
        slots.add(slot2);
        openSlotList.setSlots(slots);        
        return new ResponseEntity<OpenSlotList3>(openSlotList, HttpStatus.OK);
    }

}
