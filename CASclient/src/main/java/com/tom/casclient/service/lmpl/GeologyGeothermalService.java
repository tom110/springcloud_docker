package com.tom.casclient.service.lmpl;

import com.tom.casclient.domain.GeologyGeothermal;
import com.tom.casclient.domain.GeologyModel;
import com.tom.casclient.repository.GeologyGeothermalRepository;
import com.tom.casclient.service.GeoModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeologyGeothermalService implements GeoModelService {

    @Autowired
    private GeologyGeothermalRepository geologyGeothermalRepository;

    @Override
    public GeologyModel getGeologyModel(Integer objid) {
        return geologyGeothermalRepository.findByObjid(objid);
    }

    @Override
    public List<?> listAll() {
        return geologyGeothermalRepository.findAll();
    }

    @Override
    public GeologyModel getById(Integer id) {
        return geologyGeothermalRepository.findOne(id);
    }

    @Override
    public GeologyModel saveOrUpdate(GeologyModel domainObject) {
        return geologyGeothermalRepository.save((GeologyGeothermal) domainObject);
    }

    @Override
    public void delete(Integer id) {
        geologyGeothermalRepository.delete(id);
    }
}
