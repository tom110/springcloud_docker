package com.tom.casclient.repository;

import com.tom.casclient.domain.GeologyMarineranching;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeologyMarineranchingRepository extends JpaRepository<GeologyMarineranching,Integer> {
    GeologyMarineranching findByObjid(Integer objid);
}
