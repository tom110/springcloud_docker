package com.tom.casclient.domain;

import javax.persistence.*;

@Entity
@Table(name="geologyMarineranching")
public class GeologyMarineranching extends GeologyModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column
    private String quyu;
    @Column
    private String leixing;
    @Column
    private String jingdu;
    @Column
    private String weidu;
    @Column
    private String jingdudd;
    @Column
    private String weidudd;
    @Column
    private String x;
    @Column
    private String y;

    //描述类的字段
    public static enum Cp{
        id("序号","id",1,0),
        yewaibianhao("区域","yewaibianhao",2,1),
        leixing("类型","leixing",3,1),
        jingdu("经度","jingdu",4,1),
        weidu("纬度","weidu",5,1),
        jingdudd("经度（DDMMSS.SS）","jingdudd",6,1),
        getWeidudd("纬度（DDMMSS.SS）","getWeidudd",7,1),
        x("X","x",8,1),
        y("Y","y",9,1);

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
            for(GeologyMarineranching.Cp cp: GeologyMarineranching.Cp.values()){
                if(cp.getIndex().equals(index)){
                    return cp.getName();
                }
            }
            return null;
        }

        public static String getCpByOrder(Integer order){
            for(GeologyMarineranching.Cp cp: GeologyMarineranching.Cp.values()){
                if(cp.getOrder()==order){
                    return cp.getName();
                }
            }
            return null;
        }

        public static Integer getStatusByOrder(Integer order){
            for(GeologyMarineranching.Cp cp: GeologyMarineranching.Cp.values()){
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

    public String getQuyu() {
        return quyu;
    }

    public void setQuyu(String quyu) {
        this.quyu = quyu;
    }

    public String getLeixing() {
        return leixing;
    }

    public void setLeixing(String leixing) {
        this.leixing = leixing;
    }

    public String getJingdu() {
        return jingdu;
    }

    public void setJingdu(String jingdu) {
        this.jingdu = jingdu;
    }

    public String getWeidu() {
        return weidu;
    }

    public void setWeidu(String weidu) {
        this.weidu = weidu;
    }

    public String getJingdudd() {
        return jingdudd;
    }

    public void setJingdudd(String jingdudd) {
        this.jingdudd = jingdudd;
    }

    public String getWeidudd() {
        return weidudd;
    }

    public void setWeidudd(String weidudd) {
        this.weidudd = weidudd;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }
}
