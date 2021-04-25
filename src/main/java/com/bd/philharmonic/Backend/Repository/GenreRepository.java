package com.bd.philharmonic.Backend.Repository;

import com.bd.philharmonic.Backend.Entity.Genre;
import com.bd.philharmonic.Backend.Entity.Organizer;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    @Query("select g from Genre g " +
            "where lower(g.genre_name) like lower(concat('%', :searchTerm, '%'))")
    List<Genre> search(@Param("searchTerm") String searchTerm);

}
