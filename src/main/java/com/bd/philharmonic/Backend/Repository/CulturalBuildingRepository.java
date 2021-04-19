package com.bd.philharmonic.Backend.Repository;

import com.bd.philharmonic.Backend.Entity.CulturalBuilding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CulturalBuildingRepository extends CrudRepository<CulturalBuilding, Long> {

    @Query(value = "select id_place from cultural_building where name = :param", nativeQuery = true)
    Integer getIdByName(@Param("param") String param);

}
