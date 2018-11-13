package com.tom.casclient.domain;

import javax.persistence.*;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract  public class GeologyModel {
    @Column(nullable = false)
    private Integer objid;

    public static enum Cp{
        ;
        private String name;
        private String index;
        private Cp(String name,String index){
            this.name=name;
            this.index=index;
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

        public static String getName(String index){
            return "";
        }

    }

    public Integer getObjid() {
        return objid;
    }

    public void setObjid(Integer objid) {
        this.objid = objid;
    }
}
