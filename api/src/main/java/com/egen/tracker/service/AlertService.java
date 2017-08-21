package com.egen.tracker.service;

import com.egen.tracker.entity.Alerts;

import java.util.List;


public interface AlertService {

    List<Alerts> getAllAlerts();
    List<Alerts> getAlertForVin(String vin);
    List<Alerts> getAlertsByPriority(String priority);


    Alerts createAlert(Alerts alert);

}
