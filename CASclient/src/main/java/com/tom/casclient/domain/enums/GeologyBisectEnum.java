package com.tom.casclient.domain.enums;

import com.tom.casclient.domain.GeologyBisectLayer;

public enum GeologyBisectEnum implements GeoEnum{

    //描述类的字段
    id("序号","id",1),
    oldid("原id","oldid",2),
    mparea("mparea","mparea",3),
    mpperimeter("mpperimeter","mpperimeter",4),
    yancengleixing("岩层类型","yancengleixing",5),
    yanxingdaima("岩性代码","yanxingdaima",6),
    dai("代","dai",7),
    yanxingmiaoshu("岩性描述","yanxingmiaoshu",8),
    ji("纪","ji",9),
    qun("群","qun",10),
    tong("统","tong",11),
    duan("段","duan",12),
    zu("组","zu",13),
    jieduan("阶段","jieduan",14),
    qi("期","qi",15),
    danyuan("单元","danyuan",16),
    xulie("序列","xulie",17),
    rggtianchongyanse("REG填充颜色","regtianchongyanse",18),
    regtianchongtuan("REG填充图案","regtianchongtuan",19),
    regtuangaodu("REG图案高度","regtuangaodu",20),
    regtuankuandu("REG图案宽度","regtuankuandu",21),
    regtuanyanse("REG图案颜色","regtuanyanse",22),
    regtuceng("REG图层","regtuceng",23),
    mplayer("mplayer","maplayer",24),
    tianchongyanse("填充颜色","yanchongyanse",25),
    tianchongtuan("填充图案","tianchongtuan",26),
    tuanyanse("图案颜色","tuanyanse",27),
    tuandaxiao("图案大小","tuandaxiao",28),
    tuanjiaodu("图案角度","tuanjiaodu",29);
    private String name;
    private String index;
    private Integer order;

    private GeologyBisectEnum(){

    }

    private GeologyBisectEnum(String name, String index, Integer order) {
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
        for (GeologyBisectEnum cp : GeologyBisectEnum.values()) {
            if (cp.getIndex().equals(index)) {
                return cp.getName();
            }
        }
        return null;
    }

    public String getCpByOrder(Integer order) {
        for (GeologyBisectEnum cp : GeologyBisectEnum.values()) {
            if (cp.getOrder() == order) {
                return cp.getName();
            }
        }
        return null;
    }

    public Object getValues() {
        return GeologyBisectEnum.values();
    }

    public Integer getValuesLength() {
        return GeologyDisruptEnum.values().length;
    }
}

