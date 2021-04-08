package com.bd.philharmonic.backend.Repository;

import com.bd.philharmonic.backend.Entity.HouseOfCulture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseOfCultureRepository extends CrudRepository<HouseOfCulture, Long> {

}
