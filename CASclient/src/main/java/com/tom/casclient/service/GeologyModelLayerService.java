package com.tom.casclient.service;

import com.tom.casclient.domain.GeologyModel;
import com.tom.casclient.domain.GeologyModelLayer;

public interface GeologyModelLayerService extends CRUDService<GeologyModelLayer>{
    GeologyModelLayer getGeologyModel(Integer objid);
}
