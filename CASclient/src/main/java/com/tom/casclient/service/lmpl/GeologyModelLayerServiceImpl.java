package com.tom.casclient.service.lmpl;

import com.tom.casclient.domain.GeologyModelLayer;
import com.tom.casclient.repository.GeologyModelLayerRepository;
import com.tom.casclient.service.GeologyModelLayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeologyModelLayerServiceImpl implements GeologyModelLayerService {

    @Autowired
    private GeologyModelLayerRepository geologyModelLayerRepository;

    @Override
    public List<?> listAll() {
        return geologyModelLayerRepository.findAll();
    }

    @Override
    public GeologyModelLayer getById(Integer id) {
        return geologyModelLayerRepository.findOne(id);
    }

    @Override
    public GeologyModelLayer saveOrUpdate(GeologyModelLayer domainObject) {
        return geologyModelLayerRepository.save(domainObject);
    }

    @Override
    public void delete(Integer id) {
        geologyModelLayerRepository.delete(id);
    }

    @Override
    public GeologyModelLayer getGeologyModelLayer(Integer objid) {
        return geologyModelLayerRepository.findByObjid(objid);
    }
}
