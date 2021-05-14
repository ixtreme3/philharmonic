package com.bd.philharmonic.Backend.Entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "organizer")
public class Organizer {

    @Id
    @SequenceGenerator(name = "organizer_sequence", sequenceName = "organizer_sequence", initialValue = 13)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organizer_sequence")
    private Long id_organizer;

    private String full_name;

    private String gender;

    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "organizers")
    private final Set<Event> events = new HashSet<>();

    public Long getId_organizer() {
        return id_organizer;
    }

    public void setId_organizer(Long id_organizer) {
        this.id_organizer = id_organizer;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Organizer{" +
                "id_organizer=" + id_organizer +
                ", full_name='" + full_name + '\'' +
                ", gender='" + gender + '\'' +
                ", events=" + events +
                '}';
    }
}
