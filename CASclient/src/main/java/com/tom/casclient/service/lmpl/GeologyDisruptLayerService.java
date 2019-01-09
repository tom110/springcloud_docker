package com.tom.casclient.service.lmpl;

import com.tom.casclient.domain.GeologyDisruptLayer;
import com.tom.casclient.domain.GeologyModel;
import com.tom.casclient.repository.GeologyDisruptLayerRepository;
import com.tom.casclient.service.GeoModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeologyDisruptLayerService implements GeoModelService {

    @Autowired
    private GeologyDisruptLayerRepository geologyDisruptLayerRepository;

    @Override
    public GeologyModel getGeologyModel(Integer objid) {
        return geologyDisruptLayerRepository.findByObjid(objid);
    }

    @Override
    public List<?> listAll() {
        return geologyDisruptLayerRepository.findAll();
    }

    @Override
    public GeologyModel getById(Integer id) {
        return geologyDisruptLayerRepository.findOne(id);
    }

    @Override
    public GeologyModel saveOrUpdate(GeologyModel domainObject) {
        return geologyDisruptLayerRepository.save((GeologyDisruptLayer)domainObject);
    }

    @Override
    public void delete(Integer id) {
        geologyDisruptLayerRepository.delete(id);
    }
}
