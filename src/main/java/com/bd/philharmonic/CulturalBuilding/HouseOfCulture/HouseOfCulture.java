package com.bd.philharmonic.CulturalBuilding.HouseOfCulture;

import com.bd.philharmonic.CulturalBuilding.CulturalBuilding;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "house_of_culture")
public class HouseOfCulture extends CulturalBuilding {

    private String type;

    public HouseOfCulture(String name, String type_of_building, String address, int capacity, String type) {
        super(name, type_of_building, address, capacity);
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
