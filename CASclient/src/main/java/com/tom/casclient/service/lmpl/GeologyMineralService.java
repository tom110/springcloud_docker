package com.tom.casclient.service.lmpl;

import com.tom.casclient.domain.GeologyMineral;
import com.tom.casclient.domain.GeologyModel;
import com.tom.casclient.repository.GeologyMineralRepository;
import com.tom.casclient.service.GeoModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeologyMineralService implements GeoModelService {

    @Autowired
    private GeologyMineralRepository geologyMineralRepository;
    @Override
    public GeologyModel getGeologyModel(Integer objid) {
        return geologyMineralRepository.findByObjid(objid);
    }

    @Override
    public List<?> listAll() {
        return geologyMineralRepository.findAll();
    }

    @Override
    public GeologyModel getById(Integer id) {
        return geologyMineralRepository.findOne(id);
    }

    @Override
    public GeologyModel saveOrUpdate(GeologyModel domainObject) {
        return geologyMineralRepository.save((GeologyMineral) domainObject);
    }

    @Override
    public void delete(Integer id) {
        geologyMineralRepository.delete(id);
    }
}
