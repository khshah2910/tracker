package com.egen.tracker.service;

import com.egen.tracker.entity.Readings;
import com.egen.tracker.entity.Vehicles;

import java.util.List;

public interface ReadingService {

    List<Readings> getAllReradings();
    List<Readings> searchByVin(String vin);
    void createAlert(Readings readings, Vehicles vehicles);
    Readings create(Readings readings);
}
