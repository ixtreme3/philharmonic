package com.bd.philharmonic.Backend.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @SequenceGenerator(name = "event_sequence", sequenceName = "event_sequence", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cultural_building_sequence")
    private Long id_event;

    private String name;

    private int visit_price;

    private LocalDate start_date;

    private LocalDate end_date;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "event_building",
            joinColumns = { @JoinColumn(name = "id_event") },
            inverseJoinColumns = { @JoinColumn(name = "id_place") }
    )
    Set<CulturalBuilding> culturalBuildings = new HashSet<>();

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "event_artist",
            joinColumns = { @JoinColumn(name = "id_event") },
            inverseJoinColumns = { @JoinColumn(name = "id_artist") }
    )
    Set<Artist> artists = new HashSet<>();

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "event_organizer",
            joinColumns = { @JoinColumn(name = "id_event") },
            inverseJoinColumns = { @JoinColumn(name = "id_organizer") }
    )
    Set<Organizer> organizers = new HashSet<>();

    public Event() {

    }

    public Long getId_event() {
        return id_event;
    }

    public void setId_event(Long id_event) {
        this.id_event = id_event;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVisit_price() {
        return visit_price;
    }

    public void setVisit_price(int visit_price) {
        this.visit_price = visit_price;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "Events{" +
                "id_event=" + id_event +
                ", name='" + name + '\'' +
                ", visit_prise=" + visit_price +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                '}';
    }
}
