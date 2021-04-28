package com.bd.philharmonic.Backend.Repository;

import com.bd.philharmonic.Backend.Entity.Impresario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ImpresarioRepository extends JpaRepository<Impresario, Long> {

    @Query("select t from Impresario t " +
            "where lower(t.full_name) like lower(concat('%', :searchTerm, '%'))")
    List<Impresario> search(@Param("searchTerm") String searchTerm);

    // Запрос 5 : Получить список импресарио указанного артиста.
    @Query(value = """
            select i.id_impresario, i.full_name, i.age, i.gender from impresario i
            join artist_impresario ai on i.id_impresario = ai.id_impresario
            join artist a on a.id_artist = ai.id_artist
            where a.full_name = :param""", nativeQuery = true)
    List<Impresario> getImpresariosByArtist(@Param("param") String param);

    // Запрос 9 : Получить список импресарио определенного жанра.
    @Query(value = """
            select i.id_impresario, i.full_name, i.age, i.gender from impresario i
            join artist_impresario ai on i.id_impresario = ai.id_impresario
            join artist a on ai.id_artist = a.id_artist
            join artist_genre ag on a.id_artist = ag.id_artist
            join genre g on g.id_genre = ag.id_genre
            where g.genre_name = :param""", nativeQuery = true)
    List<Impresario> getImpresariosByGenre(@Param("param") String param);

}
