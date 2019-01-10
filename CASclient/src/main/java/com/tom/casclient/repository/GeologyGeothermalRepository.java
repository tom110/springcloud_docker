package com.tom.casclient.repository;

import com.tom.casclient.domain.GeologyGeothermal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeologyGeothermalRepository extends JpaRepository<GeologyGeothermal,Integer> {
    GeologyGeothermal findByObjid(Integer objid);
}
