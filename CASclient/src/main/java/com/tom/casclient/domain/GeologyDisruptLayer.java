package com.tom.casclient.domain;

import com.tom.casclient.domain.enums.GeoEnum;
import com.tom.casclient.domain.enums.GeologyBisectEnum;
import com.tom.casclient.domain.enums.GeologyDisruptEnum;

import javax.persistence.*;

@Entity
@Table(name="geologyDisruptlayer")
public class GeologyDisruptLayer extends GeologyModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column
    private String fsurfid;
    @Column
    private String duanchengbianhao;
    @Column
    private String duancengmingcheng;
    @Column
    private String duancengchanzhuang;
    @Column
    private String duanchengmiaoshu;
    @Column
    private String jibenqingkuang;

    //描述类的字段
    public static enum Cp{
        id("序号","id",1,0),
        fsurfid("FSURFID","fsurfid",2,1),
        duanchengbianhao("断层编号","duanchengbianhao",3,1),
        duanchengmingcheng("断层名称","duancengmingcheng",4,1),
        duanchengchanzhuang("断层产状","duancengchanzhuang",5,1),
        duanchengmiaoshu("断层描述","duanchengmiaoshu",6,1),
        jibenqingkuang("基本情况","jibenqingkuang",7,1);

        private String name;
        private String index;
        private Integer order;
        private Integer status;
        private Cp(String name, String index, Integer order,Integer status){
            this.name=name;
            this.index=index;
            this.order=order;
            this.status=status;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
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

        public static String getName(String index){
            for(GeologyDisruptLayer.Cp cp: GeologyDisruptLayer.Cp.values()){
                if(cp.getIndex().equals(index)){
                    return cp.getName();
                }
            }
            return null;
        }

        public static String getCpByOrder(Integer order){
            for(GeologyDisruptLayer.Cp cp: GeologyDisruptLayer.Cp.values()){
                if(cp.getOrder()==order){
                    return cp.getName();
                }
            }
            return null;
        }

        public static Integer getStatusByOrder(Integer order){
            for(GeologyBisectLayer.Cp cp: GeologyBisectLayer.Cp.values()){
                if(cp.getOrder()==order){
                    return cp.getStatus();
                }
            }
            return null;
        }

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFsurfid() {
        return fsurfid;
    }

    public void setFsurfid(String fsurfid) {
        this.fsurfid = fsurfid;
    }

    public String getDuanchengbianhao() {
        return duanchengbianhao;
    }

    public void setDuanchengbianhao(String duanchengbianhao) {
        this.duanchengbianhao = duanchengbianhao;
    }

    public String getDuancengmingcheng() {
        return duancengmingcheng;
    }

    public void setDuancengmingcheng(String duancengmingcheng) {
        this.duancengmingcheng = duancengmingcheng;
    }

    public String getDuancengchanzhuang() {
        return duancengchanzhuang;
    }

    public void setDuancengchanzhuang(String duancengchanzhuang) {
        this.duancengchanzhuang = duancengchanzhuang;
    }

    public String getDuanchengmiaoshu() {
        return duanchengmiaoshu;
    }

    public void setDuanchengmiaoshu(String duanchengmiaoshu) {
        this.duanchengmiaoshu = duanchengmiaoshu;
    }

    public String getJibenqingkuang() {
        return jibenqingkuang;
    }

    public void setJibenqingkuang(String jibenqingkuang) {
        this.jibenqingkuang = jibenqingkuang;
    }
}
