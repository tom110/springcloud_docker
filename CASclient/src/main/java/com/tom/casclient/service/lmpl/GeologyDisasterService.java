package com.tom.casclient.service.lmpl;

import com.tom.casclient.domain.GeologyDisaster;
import com.tom.casclient.domain.GeologyModel;
import com.tom.casclient.repository.GeologyDisasterRepository;
import com.tom.casclient.service.GeoModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeologyDisasterService  implements GeoModelService {

    @Autowired
    private GeologyDisasterRepository geologyDisasterRepository;

    @Override
    public GeologyModel getGeologyModel(Integer objid) {
        return geologyDisasterRepository.findByObjid(objid);
    }

    @Override
    public List<?> listAll() {
        return geologyDisasterRepository.findAll();
    }

    @Override
    public GeologyModel getById(Integer id) {
        return geologyDisasterRepository.findOne(id);
    }

    @Override
    public GeologyModel saveOrUpdate(GeologyModel domainObject) {
        return geologyDisasterRepository.save((GeologyDisaster) domainObject);
    }

    @Override
    public void delete(Integer id) {
        geologyDisasterRepository.delete(id);
    }
}
