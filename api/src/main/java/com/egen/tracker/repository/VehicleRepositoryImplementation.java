package com.egen.tracker.repository;

import com.egen.tracker.entity.Vehicles;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class VehicleRepositoryImplementation implements VehicleRepository {


    @PersistenceContext
    private EntityManager entityManager;

    public List<Vehicles> findAll() {
        TypedQuery<Vehicles> query;
        query = entityManager.createNamedQuery("vehicle.findAll", Vehicles.class);
        return query.getResultList();
    }

    @Transactional
    public Vehicles create(Vehicles vehicles) {
        entityManager.persist(vehicles);
        return vehicles;
    }

    public Vehicles findByVin(String vin) {
//        TypedQuery <Vehicles> query = entityManager.createNamedQuery("vehicle.findByVin", Vehicles.class);
//        query.setParameter("paramVin", vin);
        Vehicles vehicles = entityManager.find(Vehicles.class,vin);
        System.out.println(vehicles);
        return vehicles;
    }

    public Vehicles update(Vehicles vehicles) {
        entityManager.merge(vehicles);
        return vehicles;
    }

    public void delete(Vehicles vehicles) {
        entityManager.remove(vehicles);
    }
}
