package com.bd.philharmonic.Backend.Repository;

import com.bd.philharmonic.Backend.Entity.Prizewinner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrizewinnerRepository extends JpaRepository<Prizewinner, Long> {


}
