package com.bd.philharmonic.backend.Entity;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "cultural_building")
public class CulturalBuilding {

    @Id
    @SequenceGenerator(name = "cultural_building_sequence", sequenceName = "cultural_building_sequence", initialValue = 7)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cultural_building_sequence")
    private Long id_place;

    private String name;

    private String type_of_building; // ?

    private String address;

    private int capacity;

    public CulturalBuilding(String name, String type_of_building, String address, int capacity) {
        this.name = name;
        this.type_of_building = type_of_building;
        this.address = address;
        this.capacity = capacity;
    }

    public CulturalBuilding() {

    }

    public Long getId_place() {
        return id_place;
    }

    public void setId_place(Long id_place) {
        this.id_place = id_place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType_of_building() {
        return type_of_building;
    }

    public void setType_of_building(String type_of_building) {
        this.type_of_building = type_of_building;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "CulturalBuilding{" +
                "id_place=" + id_place +
                ", name='" + name + '\'' +
                ", type_of_building='" + type_of_building + '\'' +
                ", address='" + address + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
