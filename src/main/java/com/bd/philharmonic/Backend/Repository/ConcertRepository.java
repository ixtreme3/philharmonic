package com.bd.philharmonic.Backend.Repository;

import com.bd.philharmonic.Backend.Entity.Concert;
import com.bd.philharmonic.Backend.Entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConcertRepository extends JpaRepository<Concert, Long> {

    @Query("select c from Concert c " +
            "where lower(c.name) like lower(concat('%', :searchTerm, '%'))")
    List<Concert> search(@Param("searchTerm") String searchTerm);

}
