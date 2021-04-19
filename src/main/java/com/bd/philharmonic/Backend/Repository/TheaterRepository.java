package com.bd.philharmonic.Backend.Repository;

import com.bd.philharmonic.Backend.Entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {

    @Query("select t from Theater t " +
            "where lower(t.name) like lower(concat('%', :searchTerm, '%'))")
    List<Theater> search(@Param("searchTerm") String searchTerm);

    @Query
    List<Theater> getTheaterByCapacityGreaterThanEqual(int param);

}
