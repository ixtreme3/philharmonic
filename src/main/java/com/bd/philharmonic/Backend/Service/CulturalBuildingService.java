package com.bd.philharmonic.Backend.Service;

import com.bd.philharmonic.Backend.Repository.CulturalBuildingRepository;
import org.springframework.stereotype.Service;

@Service
public class CulturalBuildingService {

    private final CulturalBuildingRepository culturalBuildingRepository;

    public CulturalBuildingService(CulturalBuildingRepository culturalBuildingRepository) {
        this.culturalBuildingRepository = culturalBuildingRepository;
    }

    public Integer getIdByName(String param) {
        return culturalBuildingRepository.getIdByName(param);
    };

}
