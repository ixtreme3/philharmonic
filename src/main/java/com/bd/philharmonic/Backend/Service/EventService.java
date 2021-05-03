package com.bd.philharmonic.Backend.Service;

import com.bd.philharmonic.Backend.Entity.Artist;
import com.bd.philharmonic.Backend.Entity.Event;
import com.bd.philharmonic.Backend.Repository.EventRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> findAll(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            return eventRepository.findAll();
        } else {
            return eventRepository.search(filterText);
        }
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public List<Event> getEventsByCulturalBuildingName(String param) {
        return eventRepository.getEventsByCulturalBuildingName(param);
    }

    public List<Event> getEventsBetweenDates(LocalDate startDate, LocalDate endDate) {
        return eventRepository.getEventsBetweenDates(startDate, endDate);
    }

    public List<Event> getEventsByOrganizerName(String param) {
        return eventRepository.getEventsByOrganizerName(param);
    }

    public void save(Event event) {
        if (event == null){
            return;
        }
        eventRepository.save(event);
    }

    public void delete(Event event) {
        eventRepository.delete(event);
    }



}
