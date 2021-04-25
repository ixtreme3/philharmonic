package com.bd.philharmonic.Backend.Repository;

import com.bd.philharmonic.Backend.Entity.Organizer;
import com.bd.philharmonic.Backend.Entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, Long> {

    @Query("select t from Organizer t " +
            "where lower(t.full_name) like lower(concat('%', :searchTerm, '%'))")
    List<Organizer> search(@Param("searchTerm") String searchTerm);

}
