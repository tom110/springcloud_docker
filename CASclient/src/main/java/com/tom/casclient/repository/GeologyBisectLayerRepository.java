package com.tom.casclient.repository;

import com.tom.casclient.domain.GeologyBisectLayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeologyBisectLayerRepository extends JpaRepository<GeologyBisectLayer,Integer> {
    GeologyBisectLayer findByObjid(Integer objid);
}
