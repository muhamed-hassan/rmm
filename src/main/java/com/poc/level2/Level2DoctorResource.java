package com.poc.level2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.level2.models.OpenSlotList2;
import com.poc.level2.models.Slot2;

@RestController
@RequestMapping(
    value = "level2/doctors",
    produces = MediaType.APPLICATION_JSON_VALUE)
public class Level2DoctorResource {

    @RequestMapping(method = RequestMethod.GET, value = "{doctorName}/slots")
    public ResponseEntity<OpenSlotList2> getOpenSlots(@PathVariable String doctorName, @RequestParam String date) {
    	
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
        
        List<Slot2> slots = new ArrayList<Slot2>();
        slots.add(slot1);
        slots.add(slot2);
        
        OpenSlotList2 openSlotList = new OpenSlotList2();        
        openSlotList.setSlots(slots);
        
        return new ResponseEntity<OpenSlotList2>(openSlotList, HttpStatus.OK);
    }

}
