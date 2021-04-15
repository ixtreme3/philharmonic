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
    private Long id_event;

    private String event_type;

    private String name;

    private int visit_prise; // keep or delete?

    private LocalDate start_date;

    private LocalDate end_date;

    @ManyToMany(cascade = { CascadeType.ALL }) // change CascadeType? add FetchType?
    @JoinTable(
            name = "event_building",
            joinColumns = { @JoinColumn(name = "id_event") },
            inverseJoinColumns = { @JoinColumn(name = "id_place") }
    )
    Set<CulturalBuilding> culturalBuildings = new HashSet<>();

    public Event() {

    }

    public Long getId_event() {
        return id_event;
    }

    public void setId_event(Long id_event) {
        this.id_event = id_event;
    }

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVisit_prise() {
        return visit_prise;
    }

    public void setVisit_prise(int visit_prise) {
        this.visit_prise = visit_prise;
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
                ", visit_prise=" + visit_prise +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                '}';
    }
}
