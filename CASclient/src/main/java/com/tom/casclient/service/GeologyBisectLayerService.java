package com.tom.casclient.service;

import com.tom.casclient.domain.GeologyBisectLayer;

public interface GeologyBisectLayerService extends CRUDService<GeologyBisectLayer> {
    GeologyBisectLayer getGeologyModel(Integer objid);
}
