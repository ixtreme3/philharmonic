package com.bd.philharmonic.Backend.Repository;

import com.bd.philharmonic.Backend.Entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    //  Запрос 8: Получить перечень концертных мероприятий, проведенных в указанном культурном сооружении.
    @Query(value = """
            select *, 0 AS clazz_ from event e
            where id_place in (
                select cb.id_place from cultural_building cb
                where cb.name = :param
                ) and end_date <= CURRENT_DATE
            """, nativeQuery = true)
    List<Event> getEventsByCulturalBuildingName(@Param("param") String param);

    // Запрос 6: Получить перечень концертных мероприятий, проведенных течение заданного периода времени в целом либо указанным организатором.
    @Query(value = "select *, 0 AS clazz_ from event e where e.end_date > :startDate and e.end_date < :endDate", nativeQuery = true)
    List<Event> getEventsBetweenDates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query(value = """
            select e.id_event, e.id_place, e.name, e.visit_price, e.start_date, e.end_date, 0 AS clazz_ from event e
            join event_organizer eo on e.id_event = eo.id_event
            join organizer o on eo.id_organizer = o.id_organizer
            where o.full_name = :param""", nativeQuery = true)
    List<Event> getEventsByOrganizerName(@Param("param") String param);

}
