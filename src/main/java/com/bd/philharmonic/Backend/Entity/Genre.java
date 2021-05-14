package com.bd.philharmonic.Backend.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @SequenceGenerator(name = "genre_sequence", sequenceName = "genre_sequence", initialValue = 8)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genre_sequence")
    private Long id_genre;

    private String genre_name;

    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "genres")
    private final Set<Artist> artists = new HashSet<>();

    public Long getId_genre() {
        return id_genre;
    }

    public void setId_genre(Long id_genre) {
        this.id_genre = id_genre;
    }

    public String getGenre_name() {
        return genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
    }

    public Set<Artist> getArtists() {
        return artists;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id_genre=" + id_genre +
                ", genre_name='" + genre_name + '\'' +
                '}';
    }
}
