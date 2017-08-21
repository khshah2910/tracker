package com.egen.tracker.controller;

import com.egen.tracker.entity.Readings;
import com.egen.tracker.entity.Vehicles;
import com.egen.tracker.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@RequestMapping(value = "/readings")
public class ReadingController {

    @Autowired
    ReadingService readingService;

    //Insert All Readings in DB
    @RequestMapping(method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Readings create(@RequestBody Readings readings){
        readingService.create(readings);
        return readings;
    }

    //GET All the Readings
    @RequestMapping (method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Readings> getAllReradings(){
        return readingService.getAllReradings();
    }

    //GET Radings by Vin
    @RequestMapping(method = RequestMethod.GET , value = "/{vin}")
    public List<Readings> searchByVin(@PathVariable String vin){
        return readingService.searchByVin(vin);
    }






}
