package com.egen.tracker.repository;

import com.egen.tracker.entity.Vehicles;

import java.util.List;

public interface VehicleRepository {

    List<Vehicles> findAll();
    Vehicles create(Vehicles vehicles);
    Vehicles findByVin(String vin);
    Vehicles update (Vehicles vehicles);
    void delete(Vehicles vehicles);
}
