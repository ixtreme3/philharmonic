package com.bd.philharmonic.CulturalBuilding.Cinema;

import com.bd.philharmonic.CulturalBuilding.CulturalBuilding;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cinema")
public class Cinema extends CulturalBuilding {

    @Column(name = "screen_size")
    private int screen_size;

    @Column(name = "screen_type", nullable = false)
    private String screen_type;

    public Cinema(String name, String type_of_building, String address, int capacity, int screen_size, String screen_type) {
        super(name, type_of_building, address, capacity);
        this.screen_size = screen_size;
        this.screen_type = screen_type;
    }

    public Cinema() {

    }

    public int getScreen_size() {
        return screen_size;
    }

    public void setScreen_size(int screen_size) {
        this.screen_size = screen_size;
    }

    public String getScreen_type() {
        return screen_type;
    }

    public void setScreen_type(String screen_type) {
        this.screen_type = screen_type;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "screen_size=" + screen_size +
                ", screen_type='" + screen_type + '\'' +
                '}';
    }
}
