package com.tom.casclient.service.lmpl;

import com.tom.casclient.domain.GeologyDisruptLayer;
import com.tom.casclient.domain.GeologyModelLayer;
import com.tom.casclient.repository.GeologyDisruptLayerRepository;
import com.tom.casclient.service.GeologyDisruptLayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.naming.Name;
import java.util.List;

@Service
public class GeologyDisruptLayerServiceImpl implements GeologyDisruptLayerService {

    @Autowired
    private GeologyDisruptLayerRepository geologyDisruptLayerRepository;

    @Override
    public GeologyDisruptLayer getGeologyModel(Integer objid) {
        return geologyDisruptLayerRepository.findByObjid(objid);
    }

    @Override
    public List<?> listAll() {
        return geologyDisruptLayerRepository.findAll();
    }

    @Override
    public GeologyDisruptLayer getById(Integer id) {
        return geologyDisruptLayerRepository.findOne(id);
    }

    @Override
    public GeologyDisruptLayer saveOrUpdate(GeologyDisruptLayer domainObject) {
        return geologyDisruptLayerRepository.save(domainObject);
    }


    @Override
    public void delete(Integer id) {
        geologyDisruptLayerRepository.delete(id);
    }
}
