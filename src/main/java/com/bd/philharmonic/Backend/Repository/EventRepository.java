package com.bd.philharmonic.Backend.Repository;

import com.bd.philharmonic.Backend.Entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    //  Запрос 8: Получить перечень концертных мероприятий, проведенных в указанном культурном сооружении.
    @Query(value = """
            select event.id_event, event.name, event.visit_price, event.start_date, event.end_date from event
            join event_building on event.id_event = event_building.id_event
            join cultural_building on event_building.id_place = cultural_building.id_place
            where cultural_building.id_place = :param AND event.end_date <= CURRENT_DATE""",
            nativeQuery = true)
    List<Event> getEventsByCulturalBuildingName(@Param("param") int param);

}
