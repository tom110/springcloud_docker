package com.tom.casclient.service;

import com.tom.casclient.domain.GeologyDisruptLayer;
import com.tom.casclient.domain.GeologyModelLayer;

public interface GeologyDisruptLayerService extends CRUDService<GeologyDisruptLayer>{
    GeologyDisruptLayer getGeologyModel(Integer objid);
}
