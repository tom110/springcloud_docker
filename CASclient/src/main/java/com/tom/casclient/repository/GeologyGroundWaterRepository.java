package com.tom.casclient.repository;

import com.tom.casclient.domain.GeologyGroundwater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeologyGroundWaterRepository extends JpaRepository<GeologyGroundwater,Integer> {
    GeologyGroundwater findByObjid(Integer objid);
}
