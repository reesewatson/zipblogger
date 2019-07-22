package com.zipcode.zipblogger.RESTControllers;

import com.zipcode.zipblogger.Models.Shipwreck;
import com.zipcode.zipblogger.Repositories.ShipwreckRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//Always begin by annotating controller
//"Base" URL -- all endpoints will contain for this class go into parentheses
@RestController
@RequestMapping("api/v1/")
public class ShipwreckController {

    //The autowiring annotation allows you to inject certain objs into another obj within your application
    //Consider this when injecting "users"
    //Replace all shipwreckStub instances with instance shipwreckRepository
    @Autowired
    private ShipwreckRepository shipwreckRepository;

    //Accepting a GET request to the api/v1/shipwrecks endpoint for list of shipwrecks
    //Change return ...list() to return ...findAll()
    //findAll() will now query the database for all shipwreck models
    @RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
    public List<Shipwreck> list(){
        return shipwreckRepository.findAll();
    }

    //Add a shipwreck
    //crete(sw) method now becomes saveAndFlush(sw)
    @RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
    public Shipwreck create(@RequestBody Shipwreck shipwreck) {
        return shipwreckRepository.saveAndFlush(shipwreck);
    }

    //View a shipwreck
    //get(id) method now becomes getOne(id)
    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
    public Shipwreck get(@PathVariable Long id){
        return shipwreckRepository.getOne(id);
    }

    //Update a shipwreck
    //Fetch shipwreck and update the attributes in it (copy properties from source to target) then persist shipwreck to database
    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
    public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck){
        Shipwreck existingShipwreck = shipwreckRepository.getOne(id);
        BeanUtils.copyProperties(shipwreck, existingShipwreck);
        return shipwreckRepository.saveAndFlush(shipwreck);
    }

    //Delete a shipwreck
    //Fetch existing shipwreck then delete and return
    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
    public Shipwreck delete(@PathVariable Long id){
        Shipwreck existingShipwreck = shipwreckRepository.getOne(id);
        shipwreckRepository.delete(existingShipwreck);
        return existingShipwreck;
    }
}
