package com.bd.philharmonic.Backend.Repository;

import com.bd.philharmonic.Backend.Entity.Concert;
import com.bd.philharmonic.Backend.Entity.Performance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PerformanceRepository extends JpaRepository<Performance, Long> {

    @Query("select p from Performance p " +
            "where lower(p.name) like lower(concat('%', :searchTerm, '%'))")
    List<Performance> search(@Param("searchTerm") String searchTerm);

}
