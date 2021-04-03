package com.bd.philharmonic.CulturalBuilding.Theater;

import com.bd.philharmonic.CulturalBuilding.CulturalBuilding;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "theater")
public class Theater extends CulturalBuilding {

    @Column(name = "scene", nullable = false)
    private String scene;

    @Column(name = "number_of_balconies", nullable = false)
    private int number_of_balconies;

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public int getNumber_of_balconies() {
        return number_of_balconies;
    }

    public void setNumber_of_balconies(int number_of_balconies) {
        this.number_of_balconies = number_of_balconies;
    }

    @Override
    public String toString() {
        return "Theater{" +
                "scene='" + scene + '\'' +
                ", number_of_balconies=" + number_of_balconies +
                '}';
    }
}
