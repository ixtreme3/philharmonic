package com.bd.philharmonic.Backend.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
@Table(name = "artist")
public class Artist {

    @Id
    @SequenceGenerator(name = "artist_sequence", sequenceName = "artist_sequence", initialValue = 7)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "artist_sequence")
    private Long id_artist;

    private String full_name;

    private int age;

    private String gender;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "artist_impresario",
            joinColumns = { @JoinColumn(name = "id_artist") },
            inverseJoinColumns = { @JoinColumn(name = "id_impresario") }
    )
    Set<Impresario> impresarios = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "artist_genre",
            joinColumns = { @JoinColumn(name = "id_artist") },
            inverseJoinColumns = { @JoinColumn(name = "id_genre") }
    )
    Set<Genre> genres = new HashSet<>();

    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "artists")
    private final Set<Event> events = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "artist")
    private Set<Prizewinner> prizewinners = new HashSet<>();

    public Long getId_artist() {
        return id_artist;
    }

    public void setId_artist(Long id_artist) {
        this.id_artist = id_artist;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Set<Impresario> getImpresarios() {
        return impresarios;
    }

    public void setImpresarios(Set<Impresario> impresarios) {
        this.impresarios = impresarios;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public Set<Prizewinner> getPrizewinners() {
        return prizewinners;
    }

    public void setPrizewinners(Set<Prizewinner> prizewinners) {
        this.prizewinners = prizewinners;
    }

    public String getGenres_String() {
        StringBuilder str = new StringBuilder();
        Iterator<Genre> genreIterator = genres.iterator();
        while (genreIterator.hasNext()) {
            str.append(genreIterator.next().getGenre_name());
            if (genreIterator.hasNext()){
                str.append(", ");
            }
        }
        return str.toString();
    }

    public String getImpresarios_String() {
        StringBuilder str = new StringBuilder();
        Iterator<Impresario > impresarioIterator = impresarios.iterator();
        while (impresarioIterator.hasNext()) {
            str.append(impresarioIterator.next().getFull_name());
            if (impresarioIterator.hasNext()){
                str.append(", ");
            }
        }
        return str.toString();
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id_artist=" + id_artist +
                ", full_name='" + full_name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", impresarios=" + impresarios +
                ", genres=" + genres +
                ", events=" + events +
                '}';
    }
}
