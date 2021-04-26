package com.bd.philharmonic.Backend.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "cultural_building")
public class CulturalBuilding {

    @Id
    @SequenceGenerator(name = "cultural_building_sequence", sequenceName = "cultural_building_sequence", initialValue = 7)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cultural_building_sequence")
    private Long id_place;

    private String name;

    private String address;

    private int capacity;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "culturalBuildings")
    private final Set<Event> events = new HashSet<>();

    public CulturalBuilding(String name, String address, int capacity) {
        this.name = name;
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
                ", address='" + address + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
