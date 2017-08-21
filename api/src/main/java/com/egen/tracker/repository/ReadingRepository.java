package com.egen.tracker.repository;

import com.egen.tracker.entity.Readings;

import java.util.List;

public interface ReadingRepository {

    List<Readings> getAllReradings();
    List<Readings> searchByVin(String vin);

    Readings create(Readings readings);
}
