package com.bd.philharmonic.backend.Service;

import com.bd.philharmonic.backend.Entity.Theater;
import com.bd.philharmonic.backend.Repository.TheaterRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TheaterService {

    private final TheaterRepository theaterRepository;

    public TheaterService(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    public Collection<Theater> findAll() {
        return (Collection<Theater>) theaterRepository.findAll();
    }

    public Collection<Theater> findAll(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            return (Collection<Theater>) theaterRepository.findAll();
        } else {
            return theaterRepository.search(filterText);
        }
    }

    public void save(Theater theater) {
        if (theater == null){
            return;
        }
        theaterRepository.save(theater);
    }

    public void delete(Theater theater) {
        theaterRepository.delete(theater);
    }


}
