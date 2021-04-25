package com.bd.philharmonic.Backend.Repository;

import com.bd.philharmonic.Backend.Entity.Artist;
import com.bd.philharmonic.Backend.Entity.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

    @Query("select t from Artist t " +
            "where lower(t.full_name) like lower(concat('%', :searchTerm, '%'))")
    List<Artist> search(@Param("searchTerm") String searchTerm);

}
