package com.bd.philharmonic.Backend.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "house_of_culture")
public class HouseOfCulture extends CulturalBuilding {

    private String type;

    public HouseOfCulture(String name, String address, int capacity, String type) {
        super(name, address, capacity);
        this.type = type;
    }

    public HouseOfCulture() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "HouseOfCulture{" +
                "type=" + type +
                '}';
    }
}
