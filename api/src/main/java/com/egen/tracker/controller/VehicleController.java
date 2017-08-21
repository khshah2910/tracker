package com.egen.tracker.controller;

import com.egen.tracker.entity.Vehicles;
import com.egen.tracker.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin (origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

    @Autowired
    VehicleService service;

    @RequestMapping(method = RequestMethod.GET )
    public List<Vehicles> findAll() {

        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}")
    public Vehicles findByVin(@PathVariable String vin) {
        return service.findByVin(vin);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Vehicles create(@RequestBody Vehicles vehicles) {
        return service.create(vehicles);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public List<Vehicles> update(@RequestBody List<Vehicles> vehicles) {
        System.out.println(vehicles);
        return service.update(vehicles);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{vin}")
    public void delete(@PathVariable("vin") String vin) {
        service.delete(vin);
    }

}
