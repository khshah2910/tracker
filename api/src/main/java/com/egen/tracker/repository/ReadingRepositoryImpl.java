package com.egen.tracker.repository;

import com.egen.tracker.entity.Readings;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class ReadingRepositoryImpl implements ReadingRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Readings> getAllReradings() {
        TypedQuery<Readings> query = entityManager.createNamedQuery("readings.getAllReadings", Readings.class);
        return query.getResultList();
    }

    public List<Readings> searchByVin(String vin) {
        TypedQuery<Readings> query = entityManager.createNamedQuery("readings.searchByVin", Readings.class);
        query.setParameter("paramVin", vin);
        List<Readings> list = query.getResultList();
        if(list != null){
            return list;
        }
        else {
            return null;
        }
    }

    @Transactional
    public Readings create(Readings readings) {
        entityManager.persist(readings);
        return readings;
    }

}
