package com.egen.tracker.repository;

import com.egen.tracker.entity.Alerts;
import com.egen.tracker.exception.ResourceNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AlertRepositoryImpl implements AlertRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Alerts> getAllAlerts() {
        TypedQuery<Alerts> query = entityManager.createNamedQuery("alerts.allAlerts",Alerts.class);
        List<Alerts> alerts = query.getResultList();
        if(alerts == null ){
            throw new ResourceNotFoundException("No Records Found");
        }
        return alerts;
    }

    public List<Alerts> getAlertForVin(String vin) {
        TypedQuery<Alerts> query = entityManager.createNamedQuery("alerts.findByVin", Alerts.class);
        query.setParameter("paramVin",vin);
        List<Alerts> alerts = query.getResultList();
        if(alerts == null) {
            throw new ResourceNotFoundException("No Records Found");
        }
        return alerts;
    }

    @Override
    public List<Alerts> getAlertsByPriority(String priority) {
        TypedQuery<Alerts> query = entityManager.createNamedQuery("alerts.searchByPriority", Alerts.class);
        query.setParameter("paramPriority",priority);
        List<Alerts> alerts = query.getResultList();
        if(alerts == null) {
            throw new ResourceNotFoundException("No Records Found");
        }
        return alerts;
    }

    @Transactional
    public Alerts createAlert(Alerts alert) {
            entityManager.persist(alert);
        return alert;
    }

}