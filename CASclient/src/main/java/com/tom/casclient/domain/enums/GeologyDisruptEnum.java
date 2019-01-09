package com.tom.casclient.domain.enums;

import com.tom.casclient.domain.GeologyDisruptLayer;

public enum GeologyDisruptEnum implements GeoEnum{
    //描述类的字段
    id("序号","id",1),
    fsurfid("FSURFID", "fsurfid", 2),
    duanchengbianhao("断层编号", "duanchengbianhao", 3),
    duanchengmingcheng("断层名称", "duancengmingcheng", 4),
    duanchengchanzhuang("断层产状", "duancengchanzhuang", 5),
    duanchengmiaoshu("断层描述", "duancengmiaoshu", 6),
    jibenqingkuang("基本情况", "jibenqingkuang", 7);
    private String name;
    private String index;
    private Integer order;

    private GeologyDisruptEnum(){}

    private GeologyDisruptEnum(String name, String index, Integer order) {
        this.name = name;
        this.index = index;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getName(String index) {
        for (GeologyDisruptEnum cp : GeologyDisruptEnum.values()) {
            if (cp.getIndex().equals(index)) {
                return cp.getName();
            }
        }
        return null;
    }

    public String getCpByOrder(Integer order) {
        for (GeologyDisruptEnum cp : GeologyDisruptEnum.values()) {
            if (cp.getOrder() == order) {
                return cp.getName();
            }
        }
        return null;
    }

    @Override
    public Object getValues() {
        return GeologyDisruptEnum.values();
    }

    @Override
    public Integer getValuesLength() {
        return GeologyDisruptEnum.values().length;
    }
}
