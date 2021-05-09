package com.bd.philharmonic.Backend.Service;

import com.bd.philharmonic.Backend.Entity.Prizewinner;
import com.bd.philharmonic.Backend.Repository.PrizewinnerRepository;
import org.springframework.stereotype.Service;

@Service
public class PrizewinnerService {

    private final PrizewinnerRepository prizewinnerRepository;

    public PrizewinnerService(PrizewinnerRepository prizewinnerRepository) {
        this.prizewinnerRepository = prizewinnerRepository;
    }

    public void save(Prizewinner prizewinner) {
        if (prizewinner == null){
            return;
        }
        prizewinnerRepository.save(prizewinner);
    }

    public void delete(Prizewinner prizewinner) {
        prizewinnerRepository.delete(prizewinner);
    }
}
