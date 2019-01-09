package com.tom.casclient.repository;

import com.tom.casclient.domain.GeologySectionLayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeologySectionLayerRepository extends JpaRepository<GeologySectionLayer,Integer>{
    GeologySectionLayer findByObjid(Integer objid);
}
