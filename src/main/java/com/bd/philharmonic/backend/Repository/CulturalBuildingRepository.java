package com.bd.philharmonic.backend.Repository;

import com.bd.philharmonic.backend.Entity.CulturalBuilding;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CulturalBuildingRepository extends CrudRepository<CulturalBuilding, Long> {

}
