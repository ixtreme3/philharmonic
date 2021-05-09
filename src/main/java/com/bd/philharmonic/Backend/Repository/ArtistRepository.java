package com.bd.philharmonic.Backend.Repository;

import com.bd.philharmonic.Backend.Entity.Artist;
import com.bd.philharmonic.Backend.Entity.Genre;
import com.bd.philharmonic.Backend.Entity.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

    @Query("select t from Artist t " +
            "where lower(t.full_name) like lower(concat('%', :searchTerm, '%'))")
    List<Artist> search(@Param("searchTerm") String searchTerm);

    // Запрос 2 : Получить список импресарио указанного артиста.
    @Query(value = """
            select a.id_artist, a.full_name, a.age, a.gender
            from artist a
            join artist_genre ag on a.id_artist = ag.id_artist
            join genre g on g.id_genre = ag.id_genre
            where g.genre_name = :param""", nativeQuery = true)
    List<Artist> getArtistsByGenre(@Param("param") String param);

    // Запрос 3 : Получить список артистов, работающих с некоторым импресарио.
    @Query(value = """
            select a.id_artist, a.full_name, a.age, a.gender
            from artist a
            join artist_impresario ai on a.id_artist = ai.id_artist
            join impresario i on i.id_impresario = ai.id_impresario
            where i.full_name = :param""", nativeQuery = true)
    List<Artist> getArtistsByImpresario(@Param("param") String param);

    // Запрос 4 : Получить список артистов, выступающих более чем в одном жанре с их указанием.
    @Query(value = """
            select * from artist a
            where a.id_artist in 
            (
               select a.id_artist
               from artist as a
               join artist_genre ag on ag.id_artist = a.id_artist
               join genre g on ag.id_genre = g.id_genre
               group by a.id_artist
               having COUNT(g.id_genre) > 1 
            ) """, nativeQuery = true)
    List<Artist> getArtistWithMoreThanOneGenre();

    @Query(value = """
            select a.id_artist, a.full_name, a.age, a.gender from artist a
            join event_artist ea on a.id_artist = ea.id_artist
            join event e on e.id_event = ea.id_event
            where e.name = :param""", nativeQuery = true)
    List<Artist> getArtistsByContest(@Param("param") String param);

    @Query(value = """
            select a.id_artist, a.full_name, a.age, a.gender from artist a
            join prizewinner p on a.id_artist = p.id_artist
            join contest c on c.id_event = p.id_event
            join event e on e.id_event = c.id_event
            where e.name = :param""", nativeQuery = true)
    List<Artist> getArtistsPrizewinnersByContestName(@Param("param") String param);

}
