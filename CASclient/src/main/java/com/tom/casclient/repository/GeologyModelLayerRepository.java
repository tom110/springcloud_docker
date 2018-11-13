package com.tom.casclient.repository;

import com.tom.casclient.domain.GeologyModelLayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeologyModelLayerRepository extends JpaRepository<GeologyModelLayer,Integer> {
    GeologyModelLayer findByObjid(Integer objid);
}
