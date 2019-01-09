package com.tom.casclient.service.lmpl;

import com.tom.casclient.domain.GeologyBisectLayer;
import com.tom.casclient.domain.GeologyModel;
import com.tom.casclient.repository.GeologyBisectLayerRepository;
import com.tom.casclient.service.GeoModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeologyBisectLayerService implements GeoModelService{


    @Autowired
    private GeologyBisectLayerRepository geologyBisectLayerRepository;

    @Override
    public GeologyModel getGeologyModel(Integer objid) {
        return geologyBisectLayerRepository.findByObjid(objid);
    }

    @Override
    public List<?> listAll() {
        return geologyBisectLayerRepository.findAll();
    }

    @Override
    public GeologyModel getById(Integer id) {
        return geologyBisectLayerRepository.findOne(id);
    }

    @Override
    public GeologyModel saveOrUpdate(GeologyModel domainObject) {
        return geologyBisectLayerRepository.save((GeologyBisectLayer) domainObject);
    }

    @Override
    public void delete(Integer id) {
        geologyBisectLayerRepository.delete(id);
    }
}
