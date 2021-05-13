package com.bd.philharmonic.Backend.Repository;

import com.bd.philharmonic.Backend.Entity.CulturalBuilding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CulturalBuildingRepository extends JpaRepository<CulturalBuilding, Long> {

    @Query(value = "select id_place from cultural_building where name = :param", nativeQuery = true)
    Integer getIdByName(@Param("param") String param);

    // Запрос 12: Получить перечень культурных сооружений, а также даты проведения на них культурных мероприятий в течение определенного периода времени.
    @Query(value = """
            select cb.name as buildingName, e.name as eventName, e.start_date, e.end_date from cultural_building cb
            join event e on cb.id_place = e.id_place
            where e.end_date > :startDate and e.end_date < :endDate""", nativeQuery = true)
    List<Object[]> getCulturalBuildingsAndRelatedEventsWithinGivenTimePeriod(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}
