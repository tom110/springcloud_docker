package com.tom.casclient.domain.enums;

 public interface GeoEnum {
    String getName(String index);

    String getCpByOrder(Integer order);

    Object getValues();

    Integer getValuesLength();
}
