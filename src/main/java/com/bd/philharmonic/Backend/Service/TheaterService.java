package com.bd.philharmonic.Backend.Service;

import com.bd.philharmonic.Backend.Entity.Theater;
import com.bd.philharmonic.Backend.Repository.TheaterRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TheaterService {

    private final TheaterRepository theaterRepository;

    public TheaterService(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    public List<Theater> findAll() {
        return theaterRepository.findAll();
    }

    public List<Theater> getTheaterByCapacityGreaterThanEqual(int param) {
        return theaterRepository.getTheaterByCapacityGreaterThanEqual(param);
    }

    public List<Theater> findAll(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            return theaterRepository.findAll();
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
