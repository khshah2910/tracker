package com.egen.tracker.controller;

import com.egen.tracker.entity.Alerts;
import com.egen.tracker.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@RequestMapping(value = "/alerts")
public class AlertController {

    @Autowired
    AlertService alertService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Alerts> getAllAlerts(){
        return alertService.getAllAlerts();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/vin/{vin}")
    public List<Alerts> getAlertforVin(@PathVariable String vin){

        return alertService.getAlertForVin(vin);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/Priority/{priority}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Alerts> getAlertByPriority(@PathVariable String priority){
        return alertService.getAlertsByPriority(priority);
    }

}