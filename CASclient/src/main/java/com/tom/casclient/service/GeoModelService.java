package com.tom.casclient.service;

import com.tom.casclient.domain.GeologyModel;

public interface GeoModelService extends CRUDService<GeologyModel> {
    GeologyModel getGeologyModel(Integer objid);
}
