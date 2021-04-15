package com.bd.philharmonic.Backend.Repository;

import com.bd.philharmonic.Backend.Entity.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

}
