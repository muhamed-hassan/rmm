package com.poc.level1;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.level1.dtos.OpenSlot1;
import com.poc.level1.dtos.OpenSlotList1;
import com.poc.level1.dtos.Slot1;

@RestController
@RequestMapping(
    value = "level1/doctors",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
public class Level1DoctorResource {

    @PostMapping("{doctorName}")
    public OpenSlotList1 getOpenSlots(@PathVariable String doctorName, @RequestBody OpenSlot1 openSlot) {
    	var slot1 = new Slot1().withId(1234).withStart(1400).withEnd(1450).withDoctor(doctorName);
    	var slot2 = new Slot1().withId(5678).withStart(1600).withEnd(1650).withDoctor(doctorName);
        var openSlotList = new OpenSlotList1();
        openSlotList.setSlots(List.of(slot1, slot2));
        return openSlotList;
    }

}
