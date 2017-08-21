package com.egen.tracker.service;

import com.egen.tracker.entity.Alerts;
import com.egen.tracker.exception.ResourceNotFoundException;
import com.egen.tracker.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlertServiceImpl implements AlertService {

    @Autowired
    AlertRepository alertRepository;

    @Transactional(readOnly = true)
    public List<Alerts> getAllAlerts() {
        return alertRepository.getAllAlerts();
    }

    public List<Alerts> getAlertForVin(String vin) {
        List<Alerts> exist = alertRepository.getAlertForVin(vin);
        if(exist == null){
            throw new ResourceNotFoundException("No Records Found");
        }
        return exist;
    }
    @Override
    public List<Alerts> getAlertsByPriority(String priority) {
        List<Alerts> exist = alertRepository.getAlertsByPriority(priority);
        if(exist == null){
            throw new ResourceNotFoundException("No Records Found");
        }
        return exist;
    }
    public Alerts createAlert(Alerts alert) {
        alertRepository.createAlert(alert);
        return alert;
    }
}