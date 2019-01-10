package com.tom.casclient.service.lmpl;

import com.tom.casclient.domain.GeologyMarineranching;
import com.tom.casclient.domain.GeologyModel;
import com.tom.casclient.repository.GeologyMarineranchingRepository;
import com.tom.casclient.service.GeoModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeologyMarineRanchingService implements GeoModelService {

    @Autowired
    private GeologyMarineranchingRepository geologyMarineranchingRepository;

    @Override
    public GeologyModel getGeologyModel(Integer objid) {
        return geologyMarineranchingRepository.findByObjid(objid);
    }

    @Override
    public List<?> listAll() {
        return geologyMarineranchingRepository.findAll();
    }

    @Override
    public GeologyModel getById(Integer id) {
        return geologyMarineranchingRepository.findOne(id);
    }

    @Override
    public GeologyModel saveOrUpdate(GeologyModel domainObject) {
        return geologyMarineranchingRepository.save((GeologyMarineranching) domainObject);
    }

    @Override
    public void delete(Integer id) {
        geologyMarineranchingRepository.delete(id);
    }
}
