package com.bd.philharmonic.Backend.Entity;

import javax.persistence.*;

@Entity
@Table(name = "prizewinner")
public class Prizewinner {

    @Id
    @SequenceGenerator(name = "prizewinner_sequence", sequenceName = "prizewinner_sequence", initialValue = 7)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prizewinner_sequence")
    private Long id_prizewinner;

    @ManyToOne
    @JoinColumn(name = "id_event", nullable = false)
    private Contest contest;

    @ManyToOne
    @JoinColumn(name = "id_artist", nullable = false)
    private Artist artist;

    private int place;

    public Prizewinner() {

    }

    public Long getId_prizewinner() {
        return id_prizewinner;
    }

    public void setId_prizewinner(Long id_prizewinner) {
        this.id_prizewinner = id_prizewinner;
    }

    public Contest getContest() {
        return contest;
    }

    public void setContest(Contest contest) {
        this.contest = contest;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Prizewinner{" +
                "id_prizewinner=" + id_prizewinner +
                ", contest=" + contest +
                ", artist=" + artist +
                ", place=" + place +
                '}';
    }
}
