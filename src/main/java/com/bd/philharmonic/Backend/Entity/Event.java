package com.bd.philharmonic.Backend.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "event")
public class Event {

    @Id
    @SequenceGenerator(name = "event_sequence", sequenceName = "event_sequence", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_sequence")
    private Long id_event;

    private String name;

    private int visit_price;

    private LocalDate start_date;

    private LocalDate end_date;

    public Event(String name, int visit_price, LocalDate start_date, LocalDate end_date) {
        this.name = name;
        this.visit_price = visit_price;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public Event() {

    }

    @ManyToOne
    @JoinColumn(name = "id_place", nullable = false)
    CulturalBuilding culturalBuilding;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "event_artist",
            joinColumns = { @JoinColumn(name = "id_event") },
            inverseJoinColumns = { @JoinColumn(name = "id_artist") }
    )
    Set<Artist> artists = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "event_organizer",
            joinColumns = { @JoinColumn(name = "id_event") },
            inverseJoinColumns = { @JoinColumn(name = "id_organizer") }
    )
    Set<Organizer> organizers = new HashSet<>();

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

    public CulturalBuilding getCulturalBuilding() {
        return culturalBuilding;
    }

    public void setCulturalBuilding(CulturalBuilding culturalBuilding) {
        this.culturalBuilding = culturalBuilding;
    }

    public Set<Artist> getArtists() {
        return artists;
    }

    public void setArtists(Set<Artist> artists) {
        this.artists = artists;
    }

    public Set<Organizer> getOrganizers() {
        return organizers;
    }

    public void setOrganizers(Set<Organizer> organizers) {
        this.organizers = organizers;
    }

    public String getCulturalBuildingName_String(){
        return culturalBuilding.getName();
    }

    @Override
    public String toString() {
        return "Event{" +
                "id_event=" + id_event +
                ", name='" + name + '\'' +
                ", visit_price=" + visit_price +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", culturalBuilding=" + culturalBuilding +
                ", artists=" + artists +
                ", organizers=" + organizers +
                '}';
    }

}
