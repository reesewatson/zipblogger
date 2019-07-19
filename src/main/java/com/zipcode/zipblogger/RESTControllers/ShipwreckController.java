package com.zipcode.zipblogger.RESTControllers;

import com.zipcode.zipblogger.Models.Shipwreck;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//Always begin by annotating controller
@RestController
//Base URL all endpoints will contain for this class
@RequestMapping("api/v1/")
public class ShipwreckController {

    //Accepting a GET request to the api/v1/shipwrecks endpoint for list of shipwrecks
    @RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
    public List<Shipwreck> list(){
        return ShipwreckStub.list();
    }

    //Add a shipwreck
    @RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
    public Shipwreck create(@RequestBody Shipwreck shipwreck) {
        return ShipwreckStub.create(shipwreck);
    }

    //View a shipwreck
    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
    public Shipwreck get(@PathVariable Long id){
        return ShipwreckStub.get(id);
    }

    //Update a shipwreck
    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
    public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck){
        return ShipwreckStub.update(id, shipwreck);
    }

    //Delete a shipwreck
    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
    public Shipwreck delete(@PathVariable Long id){
        return ShipwreckStub.delete(id);
    }
}
