package com.tom.casclient.domain;

import com.tom.casclient.domain.enums.GeoEnum;

import javax.persistence.*;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class GeologyModel {
    @Column(nullable = false,unique = true)
    private Integer objid;

    public Integer getObjid() {
        return objid;
    }

    public void setObjid(Integer objid) {
        this.objid = objid;
    }

    public enum Cp{
        ;
        public static String getName(String index){
           return "";
        }

        public static String getCpByOrder(Integer order){
          return "";
        }
    }
}
