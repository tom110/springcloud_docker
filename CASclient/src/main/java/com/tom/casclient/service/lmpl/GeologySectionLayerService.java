package com.tom.casclient.service.lmpl;

import com.tom.casclient.domain.GeologyModel;
import com.tom.casclient.domain.GeologySectionLayer;
import com.tom.casclient.repository.GeologySectionLayerRepository;
import com.tom.casclient.service.GeoModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeologySectionLayerService implements GeoModelService{

    @Autowired
    private GeologySectionLayerRepository geologySectionLayerRepository;

    @Override
    public GeologyModel getGeologyModel(Integer objid) {
        return geologySectionLayerRepository.findByObjid(objid);
    }

    @Override
    public List<?> listAll() {
        return geologySectionLayerRepository.findAll();
    }

    @Override
    public GeologyModel getById(Integer id) {
        return geologySectionLayerRepository.findOne(id);
    }

    @Override
    public GeologyModel saveOrUpdate(GeologyModel domainObject) {
        return geologySectionLayerRepository.save((GeologySectionLayer) domainObject);
    }

    @Override
    public void delete(Integer id) {
        geologySectionLayerRepository.delete(id);
    }
}
