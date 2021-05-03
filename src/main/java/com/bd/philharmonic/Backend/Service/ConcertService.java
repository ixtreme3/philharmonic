package com.bd.philharmonic.Backend.Service;

import com.bd.philharmonic.Backend.Entity.Concert;
import com.bd.philharmonic.Backend.Repository.ConcertRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcertService {

    private final ConcertRepository concertRepository;

    public ConcertService(ConcertRepository concertRepository) {
        this.concertRepository = concertRepository;
    }

    public List<Concert> findAll(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            return concertRepository.findAll();
        } else {
            return concertRepository.search(filterText);
        }
    }

    public void save(Concert concert) {
        if (concert == null){
            return;
        }
        concertRepository.save(concert);
    }

    public void delete(Concert concert) {
        concertRepository.delete(concert);
    }

}
