package com.tom.casclient.service.lmpl;

import com.tom.casclient.domain.GeologyGroundwater;
import com.tom.casclient.domain.GeologyModel;
import com.tom.casclient.repository.GeologyGroundWaterRepository;
import com.tom.casclient.service.GeoModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeologyGroundWaterService implements GeoModelService {

    @Autowired
    private GeologyGroundWaterRepository geologyGroundWaterRepository;

    @Override
    public GeologyModel getGeologyModel(Integer objid) {
        return geologyGroundWaterRepository.findByObjid(objid);
    }

    @Override
    public List<?> listAll() {
        return geologyGroundWaterRepository.findAll();
    }

    @Override
    public GeologyModel getById(Integer id) {
        return geologyGroundWaterRepository.findOne(id);
    }

    @Override
    public GeologyModel saveOrUpdate(GeologyModel domainObject) {
        return geologyGroundWaterRepository.save((GeologyGroundwater) domainObject);
    }

    @Override
    public void delete(Integer id) {
        geologyGroundWaterRepository.delete(id);
    }
}
