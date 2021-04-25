package com.bd.philharmonic.Backend.Service;

import com.bd.philharmonic.Backend.Entity.Organizer;
import com.bd.philharmonic.Backend.Repository.OrganizerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizerService {

    private OrganizerRepository organizerRepository;

    public OrganizerService(OrganizerRepository organizerRepository) {
        this.organizerRepository = organizerRepository;
    }

    public List<Organizer> findAll(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            return organizerRepository.findAll();
        } else {
            return organizerRepository.search(filterText);
        }
    }

    public void save(Organizer organizer) {
        if (organizer == null){
            return;
        }
        organizerRepository.save(organizer);
    }

    public void delete(Organizer organizer) {
        organizerRepository.delete(organizer);
    }

}



