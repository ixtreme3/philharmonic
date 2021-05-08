package com.bd.philharmonic.Backend.Repository;

import com.bd.philharmonic.Backend.Entity.Contest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContestRepository extends JpaRepository<Contest, Long> {

    @Query("select c from Contest c " +
            "where lower(c.name) like lower(concat('%', :searchTerm, '%'))")
    List<Contest> search(@Param("searchTerm") String searchTerm);

    @Query(value = """
            select a.full_name, p.place from artist a
            join prizewinner p on a.id_artist = p.id_artist
            join contest c on c.id_event = p.id_event
            join event e on c.id_event = e.id_event
            where e.name = :param""", nativeQuery = true)
    List<String> getContestPrizewinners(@Param("param") String param);

}
