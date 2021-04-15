package com.bd.philharmonic.Backend.Repository;

import com.bd.philharmonic.Backend.Entity.CulturalBuilding;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CulturalBuildingRepository extends CrudRepository<CulturalBuilding, Long> {

}
