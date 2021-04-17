package com.bd.philharmonic.Backend.Service;

import com.bd.philharmonic.Backend.Entity.CulturalBuilding;
import com.bd.philharmonic.Backend.Entity.HouseOfCulture;
import com.bd.philharmonic.Backend.Entity.Theater;
import com.bd.philharmonic.Backend.Repository.HouseOfCultureRepository;
import com.bd.philharmonic.Backend.Repository.TheaterRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CulturalBuildingService {

    private final TheaterRepository theaterRepository;

    private final HouseOfCultureRepository houseOfCultureRepository;

    public CulturalBuildingService(TheaterRepository theaterRepository, HouseOfCultureRepository houseOfCultureRepository) {
        this.theaterRepository = theaterRepository;
        this.houseOfCultureRepository = houseOfCultureRepository;
    }

    // Запрос 1 : Получить перечень культурных сооружений указанного типа в целом
    public List<CulturalBuilding> getBuildingsOfType(String type) {
        if (type.equals("Театр") || type.equals("театр") || type.equals("Театры") || type.equals("театры")) {
            Iterable<Theater> iterable = theaterRepository.findAll();
            return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
        }
        if (type.equals("Дом культуры") || type.equals("дом культуры") || type.equals("Дома культуры") || type.equals("дома культуры")) {
            Iterable<HouseOfCulture> iterable = houseOfCultureRepository.findAll();
            return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
        }
        return null;
    }

}
