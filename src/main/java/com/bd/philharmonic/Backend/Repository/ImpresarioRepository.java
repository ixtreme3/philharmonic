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

}
