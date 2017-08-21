package com.egen.tracker.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

//Creating alerts Entity

import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name = "alerts.allAlerts", query = "SELECT alerts from Alerts alerts"),
        @NamedQuery(name = "alerts.findByVin", query = "SELECT alerts from Alerts alerts WHERE alerts.vin = :paramVin"),
        @NamedQuery(name = "alerts.searchByPriority", query = "SELECT alerts from Alerts alerts WHERE alerts.priority =:paramPriority"),
})

public class Alerts {

    @Id
    private String id;
    private String vin;
    private String rule;
    private String priority;

    public Alerts(){

    }

    public Alerts(String vin, String rule, String priority){
        this.id = UUID.randomUUID().toString();
        this.vin = vin;
        this.rule = rule;
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "alerts{" +
                "id='" + id + '\'' +
                ", vin='" + vin + '\'' +
                ", rule='" + rule + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
}
