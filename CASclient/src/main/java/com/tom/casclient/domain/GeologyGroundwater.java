package com.tom.casclient.domain;

import javax.persistence.*;

@Entity
@Table(name="geologyGroundwater")
public class GeologyGroundwater extends GeologyModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column
    private String tongyibianhao;
    @Column
    private String jingdu;
    @Column
    private String weidu;
    @Column
    private String x;
    @Column
    private String y;
    @Column
    private String weizhi;
    @Column
    private String jiancejibie;
    @Column
    private String dixiashuileixing;
    @Column
    private String jianceneirong;
    @Column
    private String jianceleixing;

    //描述类的字段
    public static enum Cp{
        id("序号","id",1,0),
        tongyibianhao("统一编号","tongyibianhao",2,1),
        jingdu("经度","jingdu",3,1),
        weidu("纬度","weidu",4,1),
        x("X","x",5,1),
        y("Y","y",6,1),
        weizhi("位置","weizhi",7,1),
        jiancejibie("检测级别","jiancejibie",8,1),
        guimo("地下水类型","guimo",9,1),
        jianceneirong("检测内容","wendingxing",10,1),
        jianceleixing("检测类型","jianceleixing",10,1);


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
            for(GeologyGroundwater.Cp cp: GeologyGroundwater.Cp.values()){
                if(cp.getIndex().equals(index)){
                    return cp.getName();
                }
            }
            return null;
        }

        public static String getCpByOrder(Integer order){
            for(GeologyGroundwater.Cp cp: GeologyGroundwater.Cp.values()){
                if(cp.getOrder()==order){
                    return cp.getName();
                }
            }
            return null;
        }

        public static Integer getStatusByOrder(Integer order){
            for(GeologyGroundwater.Cp cp: GeologyGroundwater.Cp.values()){
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

    public String getTongyibianhao() {
        return tongyibianhao;
    }

    public void setTongyibianhao(String tongyibianhao) {
        this.tongyibianhao = tongyibianhao;
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

    public String getWeizhi() {
        return weizhi;
    }

    public void setWeizhi(String weizhi) {
        this.weizhi = weizhi;
    }

    public String getJiancejibie() {
        return jiancejibie;
    }

    public void setJiancejibie(String jiancejibie) {
        this.jiancejibie = jiancejibie;
    }

    public String getDixiashuileixing() {
        return dixiashuileixing;
    }

    public void setDixiashuileixing(String dixiashuileixing) {
        this.dixiashuileixing = dixiashuileixing;
    }

    public String getJianceneirong() {
        return jianceneirong;
    }

    public void setJianceneirong(String jianceneirong) {
        this.jianceneirong = jianceneirong;
    }

    public String getJianceleixing() {
        return jianceleixing;
    }

    public void setJianceleixing(String jianceleixing) {
        this.jianceleixing = jianceleixing;
    }
}
