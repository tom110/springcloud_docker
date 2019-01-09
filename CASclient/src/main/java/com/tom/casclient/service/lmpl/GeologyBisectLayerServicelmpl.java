package com.tom.casclient.service.lmpl;

import com.tom.casclient.domain.GeologyBisectLayer;
import com.tom.casclient.repository.GeologyBisectLayerRepository;
import com.tom.casclient.service.GeologyBisectLayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeologyBisectLayerServicelmpl implements GeologyBisectLayerService {

    @Autowired
    private GeologyBisectLayerRepository geologyBisectLayerRepository;

    @Override
    public GeologyBisectLayer getGeologyModel(Integer objid) {
        return geologyBisectLayerRepository.findByObjid(objid);
    }

    @Override
    public List<?> listAll() {
        return geologyBisectLayerRepository.findAll();
    }

    @Override
    public GeologyBisectLayer getById(Integer id) {
        return geologyBisectLayerRepository.getOne(id);
    }

    @Override
    public GeologyBisectLayer saveOrUpdate(GeologyBisectLayer domainObject) {
        return geologyBisectLayerRepository.save(domainObject);
    }

    @Override
    public void delete(Integer id) {
        geologyBisectLayerRepository.delete(id);
    }
}
