package com.bd.philharmonic.Backend.Service;

import com.bd.philharmonic.Backend.Entity.HouseOfCulture;
import com.bd.philharmonic.Backend.Repository.HouseOfCultureRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class HouseOfCultureService {


    private final HouseOfCultureRepository houseOfCultureRepository;

    public HouseOfCultureService(HouseOfCultureRepository houseOfCultureRepository) {
        this.houseOfCultureRepository = houseOfCultureRepository;
    }

    public Collection<HouseOfCulture> findAll() {
        return (Collection<HouseOfCulture>) houseOfCultureRepository.findAll();
    }

    public Collection<HouseOfCulture> findAll(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            return (Collection<HouseOfCulture>) houseOfCultureRepository.findAll();
        } else {
            return houseOfCultureRepository.search(filterText);
        }
    }

    public void save(HouseOfCulture houseOfCulture) {
        if (houseOfCulture == null){
            return;
        }
        houseOfCultureRepository.save(houseOfCulture);
    }

    public void delete(HouseOfCulture houseOfCulture) {
        houseOfCultureRepository.delete(houseOfCulture);
    }

}
