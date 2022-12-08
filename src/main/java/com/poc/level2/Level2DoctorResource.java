package com.poc.level2;

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
    	var slot1 = new Slot2().withId(1234).withStart(1400).withEnd(1450).withDoctor(doctorName);
    	var slot2 = new Slot2().withId(5678).withStart(1600).withEnd(1650).withDoctor(doctorName);
        var openSlotList = new OpenSlotList2();
        openSlotList.setSlots(List.of(slot1, slot2));
        return ResponseEntity.ok(openSlotList);
    }

}
