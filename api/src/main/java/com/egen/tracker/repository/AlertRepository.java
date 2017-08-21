package com.egen.tracker.repository;

import com.egen.tracker.entity.Alerts;

import java.util.List;

public interface AlertRepository {

    List<Alerts> getAllAlerts();
    List<Alerts> getAlertForVin(String vin);
    List<Alerts> getAlertsByPriority(String priority);
    Alerts createAlert(Alerts alert);


}
