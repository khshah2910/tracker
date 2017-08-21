package com.egen.tracker.service;

import com.egen.tracker.entity.Alerts;
import com.egen.tracker.entity.Readings;
import com.egen.tracker.entity.Vehicles;
import com.egen.tracker.exception.ResourceNotFoundException;
import com.egen.tracker.repository.VehicleRepository;
import com.egen.tracker.repository.AlertRepository;
import com.egen.tracker.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    ReadingRepository readingRepository;

    @Autowired
    AlertRepository alertRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    @Transactional(readOnly = true)
    public List<Readings> getAllReradings() {
        return readingRepository.getAllReradings();
    }

    public List<Readings> searchByVin(String vin) {
        List<Readings> exist = readingRepository.searchByVin(vin);
        if(exist==null){
            throw new ResourceNotFoundException("No Records Found");
        }
        return exist;
    }

    public Readings create(Readings readings) {

        Optional<Vehicles> vehicle = Optional.ofNullable(vehicleRepository.findByVin(readings.getVin()));
        vehicle.ifPresent(vehicles ->{
            createAlert(readings, vehicles);
        } );

        return readingRepository.create(readings);
    }

    public void createAlert(Readings readings, Vehicles vehicles){
        if(readings.getEngineRpm() > vehicles.getRedlineRpm()){
            Alerts alert = new Alerts(vehicles.getVin(),"engineRpm > readlineRpm", "HIGH");
            alertRepository.createAlert(alert);

        }
        if(readings.getFuelVolume() < ((0.1) * readings.getFuelVolume())){
            Alerts alert = new Alerts(vehicles.getVin(),"fuelVolume < 10% of maxFuelVolume", "MEDIUM");
            alertRepository.createAlert(alert);

        }
        if(readings.getTires().getFrontLeft() < 32 || readings.getTires().getFrontLeft() > 36 ||
                readings.getTires().getFrontRight() < 32 || readings.getTires().getFrontRight() > 36 ||
                readings.getTires().getRearLeft() < 32 || readings.getTires().getRearLeft() > 36 ||
                readings.getTires().getRearRight() < 32 || readings.getTires().getRearRight() > 36){

            Alerts alert = new Alerts(vehicles.getVin(),"Tire Pressure", "LOW");
            alertRepository.createAlert(alert);
        }
        if(readings.isEngineCoolantLow() == true || readings.isCheckEngineLightOn() == true) {
            Alerts alert = new Alerts(vehicles.getVin(), "Engine Coolant & Engine Light", "LOW");
            alertRepository.createAlert(alert);
        }
    }
}
