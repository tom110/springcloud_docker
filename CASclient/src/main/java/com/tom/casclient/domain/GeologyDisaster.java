package com.tom.casclient.domain;

import javax.persistence.*;

@Entity
@Table(name="geologyDisaster")
public class GeologyDisaster extends GeologyModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column
    private String yewaibianhao;
    @Column
    private String jingdu;
    @Column
    private String weidu;
    @Column
    private String x;
    @Column
    private String y;
    @Column
    private String mingcheng;
    @Column
    private String zaihaileixing;
    @Column
    private String guimo;
    @Column
    private String wendingxing;


    //描述类的字段
    public static enum Cp{
        id("序号","id",1,0),
        yewaibianhao("野外编号","yewaibianhao",2,1),
        jingdu("经度","jingdu",3,1),
        weidu("纬度","weidu",4,1),
        x("X","x",5,1),
        y("Y","y",6,1),
        mingcheng("名称","mingcheng",7,1),
        zaihaileixing("灾害类型","zaihaileixing",8,1),
        guimo("规模","guimo",9,1),
        wendingxing("稳定性","wendingxing",10,1);

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
            for(GeologyDisaster.Cp cp: GeologyDisaster.Cp.values()){
                if(cp.getIndex().equals(index)){
                    return cp.getName();
                }
            }
            return null;
        }

        public static String getCpByOrder(Integer order){
            for(GeologyDisaster.Cp cp: GeologyDisaster.Cp.values()){
                if(cp.getOrder()==order){
                    return cp.getName();
                }
            }
            return null;
        }

        public static Integer getStatusByOrder(Integer order){
            for(GeologyDisaster.Cp cp: GeologyDisaster.Cp.values()){
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

    public String getYewaibianhao() {
        return yewaibianhao;
    }

    public void setYewaibianhao(String yewaibianhao) {
        this.yewaibianhao = yewaibianhao;
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

    public String getMingcheng() {
        return mingcheng;
    }

    public void setMingcheng(String mingcheng) {
        this.mingcheng = mingcheng;
    }

    public String getZaihaileixing() {
        return zaihaileixing;
    }

    public void setZaihaileixing(String zaihaileixing) {
        this.zaihaileixing = zaihaileixing;
    }

    public String getGuimo() {
        return guimo;
    }

    public void setGuimo(String guimo) {
        this.guimo = guimo;
    }

    public String getWendingxing() {
        return wendingxing;
    }

    public void setWendingxing(String wendingxing) {
        this.wendingxing = wendingxing;
    }
}
