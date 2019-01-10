package com.tom.casclient.repository;

import com.tom.casclient.domain.GeologyMineral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeologyMineralRepository extends JpaRepository<GeologyMineral,Integer> {
    GeologyMineral findByObjid(Integer objid);
}
