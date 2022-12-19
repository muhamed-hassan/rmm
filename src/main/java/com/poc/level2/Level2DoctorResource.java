package com.poc.level2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.level2.dtos.OpenSlotList2;
import com.poc.level2.dtos.Slot2;

@RestController
@RequestMapping(
    value = "level2/doctors",
    produces = MediaType.APPLICATION_JSON_VALUE)
public class Level2DoctorResource {

    @GetMapping("{doctorName}/slots")
    public ResponseEntity<OpenSlotList2> getOpenSlots(@PathVariable String doctorName, @RequestParam @DateTimeFormat(pattern = "yyyyMMdd") Date date) {
    	Slot2 slot1 = new Slot2();
        slot1.setId(1234);
        slot1.setStart(1400);
        slot1.setEnd(1450);
        slot1.setDoctor(doctorName);
        Slot2 slot2 = new Slot2();
        slot2.setId(5678);
        slot2.setStart(1600);
        slot2.setEnd(1650);
        slot2.setDoctor(doctorName); 
        OpenSlotList2 openSlotList = new OpenSlotList2();
        List<Slot2> slots = new ArrayList<Slot2>();
        slots.add(slot1);
        slots.add(slot2);
        openSlotList.setSlots(slots);
        return ResponseEntity.ok(openSlotList);
    }

}
