package com.bd.philharmonic.backend.Repository;

import com.bd.philharmonic.backend.Entity.Theater;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TheaterRepository extends CrudRepository<Theater, Long> {

    @Query("select t from Theater t " +
            "where lower(t.name) like lower(concat('%', :searchTerm, '%'))")
    Collection<Theater> search(@Param("searchTerm") String searchTerm);

}
