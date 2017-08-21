package com.egen.tracker.service;

import com.egen.tracker.entity.Vehicles;
import com.egen.tracker.exception.ResourceNotFoundException;
import com.egen.tracker.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImplementation implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Transactional(readOnly = true)
    public List<Vehicles> findAll() {
        return vehicleRepository.findAll();
    }

    @Transactional
    public Vehicles create(Vehicles vehicles){
        return vehicleRepository.create(vehicles);
    }

    @Transactional(readOnly = true)
    public Vehicles findByVin(String vin) {
        Vehicles exist = vehicleRepository.findByVin(vin);
        if(exist == null){
            throw new ResourceNotFoundException("No Records Found");
        }
        return exist;
    }


    public List<Vehicles> update(List<Vehicles> vehicles) {
        for(Vehicles vehicle : vehicles){
            Vehicles exists = vehicleRepository.findByVin(vehicle.getVin());
            if(exists == null){
                vehicleRepository.create(vehicle);
            }
            else {
                vehicleRepository.update(vehicle);
            }
        }
        return vehicles;
    }

    public void delete(String vin) {
        vehicleRepository.delete(vehicleRepository.findByVin(vin));
    }
}
