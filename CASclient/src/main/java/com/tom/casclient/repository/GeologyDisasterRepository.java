package com.tom.casclient.repository;

import com.tom.casclient.domain.GeologyDisaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeologyDisasterRepository  extends JpaRepository<GeologyDisaster,Integer> {
    GeologyDisaster findByObjid(Integer objid);
}
