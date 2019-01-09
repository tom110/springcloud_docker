package com.tom.casclient.repository;

import com.tom.casclient.domain.GeologyDisruptLayer;
import com.tom.casclient.domain.GeologyModelLayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeologyDisruptLayerRepository extends JpaRepository<GeologyDisruptLayer,Integer> {
    GeologyDisruptLayer findByObjid(Integer objid);
}
