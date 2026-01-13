package com.poc.level1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poc.level1.models.OpenSlot1;
import com.poc.level1.models.OpenSlotList1;
import com.poc.level1.models.Slot1;

@RestController
@RequestMapping(
    value = "level1/doctors",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
public class Level1DoctorResource {

    @RequestMapping(method = RequestMethod.POST, value = "{doctorName}")
    public OpenSlotList1 getOpenSlots(@PathVariable String doctorName, @RequestBody OpenSlot1 openSlot) {
    	
    	Slot1 slot1 = new Slot1();
        slot1.setId(1234);
        slot1.setStart(1400);
        slot1.setEnd(1450);
        slot1.setDoctor(doctorName);
        Slot1 slot2 = new Slot1();
        slot2.setId(5678);
        slot2.setStart(1600);
        slot2.setEnd(1650);
        slot2.setDoctor(doctorName); 
        
        List<Slot1> slots = new ArrayList<Slot1>();
        slots.add(slot1);
        slots.add(slot2);
        
        OpenSlotList1 openSlotList = new OpenSlotList1();                
        openSlotList.setSlots(slots);
        
        return openSlotList;
    }

}
