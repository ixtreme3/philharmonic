package com.bd.philharmonic.Backend.Service;

import com.bd.philharmonic.Backend.Entity.Genre;
import com.bd.philharmonic.Backend.Repository.GenreRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> findAll(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            return genreRepository.findAll();
        } else {
            return genreRepository.search(filterText);
        }
    }

    public void save(Genre genre) {
        if (genre == null){
            return;
        }
        genreRepository.save(genre);
    }

    public void delete(Genre genre) {
        genreRepository.delete(genre);
    }

}
