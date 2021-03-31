package com.bd.philharmonic.CulturalBuilding.Theater;

import com.bd.philharmonic.CulturalBuilding.CulturalBuilding;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "theater")
public class Theater extends CulturalBuilding {

    @Column(name = "screen_size", nullable = false)
    private int screen_size;

    @Column(name = "screen_type", nullable = false)
    private String screen_type;


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
        return "Theater{" +
                "screen_size=" + screen_size +
                ", screen_type='" + screen_type + '\'' +
                '}';
    }
}
