package com.bd.philharmonic.Backend.Service;

import com.bd.philharmonic.Backend.Repository.CulturalBuildingRepository;
import org.springframework.stereotype.Service;

@Service
public class CulturalBuildingService {

    private static CulturalBuildingRepository culturalBuildingRepository;

    int getIdByName(String param) {
        return culturalBuildingRepository.getIdByName(param);
    };

}
