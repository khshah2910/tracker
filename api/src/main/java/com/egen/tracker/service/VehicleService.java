package com.egen.tracker.service;

import com.egen.tracker.entity.Vehicles;

import java.util.List;

public interface VehicleService {

    List<Vehicles> findAll();
    Vehicles create(Vehicles vehicles);
    Vehicles findByVin(String vin);
    List<Vehicles> update (List<Vehicles> vehicles);
    void delete(String vehicles);
}
