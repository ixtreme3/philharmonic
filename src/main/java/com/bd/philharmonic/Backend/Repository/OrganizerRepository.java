package com.bd.philharmonic.Backend.Repository;

import com.bd.philharmonic.Backend.Entity.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, Long> {

    @Query("select t from Organizer t " +
            "where lower(t.full_name) like lower(concat('%', :searchTerm, '%'))")
    List<Organizer> search(@Param("searchTerm") String searchTerm);

    // Запрос 11: Получить список организаторов культурных мероприятий и число проведенных ими концертов в течение определенного периода времени.
    @Query(value = """
            select o.full_name, count(o.full_name) from organizer o
            join event_organizer eo on o.id_organizer = eo.id_organizer
            join event e on e.id_event = eo.id_event
            where e.start_date > :startDate and e.end_date < :endDate
            group by o.full_name;
            """, nativeQuery = true)
    List<Object[]> getEventOrganizersAndTheirEventCount(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}
