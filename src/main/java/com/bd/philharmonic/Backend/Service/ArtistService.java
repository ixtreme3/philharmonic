package com.bd.philharmonic.Backend.Service;

import com.bd.philharmonic.Backend.Entity.Artist;
import com.bd.philharmonic.Backend.Repository.ArtistRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<Artist> findAll(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            return artistRepository.findAll();
        } else {
            return artistRepository.search(filterText);
        }
    }

    public void save(Artist artist) {
        if (artist == null){
            return;
        }
        artistRepository.save(artist);
    }

    public void delete(Artist artist) {
        artistRepository.delete(artist);
    }

}