package com.bd.philharmonic.Backend.Service;

import com.bd.philharmonic.Backend.Entity.CulturalBuilding;
import com.bd.philharmonic.Backend.Repository.CulturalBuildingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CulturalBuildingService {

    private final CulturalBuildingRepository culturalBuildingRepository;

    public CulturalBuildingService(CulturalBuildingRepository culturalBuildingRepository) {
        this.culturalBuildingRepository = culturalBuildingRepository;
    }

    public List<CulturalBuilding> findAll() {
        return culturalBuildingRepository.findAll();
    }

    public Integer getIdByName(String param) {
        return culturalBuildingRepository.getIdByName(param);
    };

}
