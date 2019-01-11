package com.tom.casclient.domain;

import javax.persistence.*;

@Entity
@Table(name="geologyMineral")
public class GeologyMineral extends GeologyPointModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column
    private String bianhao;
    @Column
    private String qukuaimingcheng;
    @Column
    private String kaicaizhukuangzhong;
    @Column
    private String shejikaicaizongliangkongzhikuangzhong;
    @Column
    private String qukuaifanwei;
    @Column
    private String qukuaimianji;
    @Column
    private String shezhileixing;
    @Column
    private String ziyuanchuliangdanwei;
    @Column
    private String chamingchuliang;
    @Column
    private String toufangshixu;
    @Column
    private String beizhu;


    //描述类的字段
    public static enum Cp{
        id("序号","id",1,0),
        bianhao("编号","bianhao",2,1),
        qukuaimingcheng("区块名称","qukuaimingcheng",3,1),
        kaicaizhukuangzhong("开采主矿种","kaicaizhukuangzhong",4,1),
        shejikaicaizongliangkongzhikuangzhong("涉及开采总量控制矿种","shejikaicaizongliangkongzhikuangzhong",5,1),
        qukuaifanwei("区块范围(拐点坐标)","qukuaifanwei",6,1),
        qukuaimianji("区块面积(平方千米)","qukuaimianji",7,1),
        shezhileixing("设置类型","shezhileixing",8,1),
        ziyuanchuliangdanwei("资源储量单位","ziyuanchuliangdanwei",9,1),
        chamingchuliang("查明(占用)储量","chamingchuliang",10,1),
        toufangshixu("投放时序","toufangshixu",11,1),
        beizhu("备注","beizhu",12,1),
        x("x","x",13,1),
        y("y","y",14,1);

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
            for(GeologyMineral.Cp cp: GeologyMineral.Cp.values()){
                if(cp.getIndex().equals(index)){
                    return cp.getName();
                }
            }
            return null;
        }

        public static String getCpByOrder(Integer order){
            for(GeologyMineral.Cp cp: GeologyMineral.Cp.values()){
                if(cp.getOrder()==order){
                    return cp.getName();
                }
            }
            return null;
        }

        public static Integer getStatusByOrder(Integer order){
            for(GeologyMineral.Cp cp: GeologyMineral.Cp.values()){
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

    public String getBianhao() {
        return bianhao;
    }

    public void setBianhao(String bianhao) {
        this.bianhao = bianhao;
    }

    public String getQukuaimingcheng() {
        return qukuaimingcheng;
    }

    public void setQukuaimingcheng(String qukuaimingcheng) {
        this.qukuaimingcheng = qukuaimingcheng;
    }

    public String getKaicaizhukuangzhong() {
        return kaicaizhukuangzhong;
    }

    public void setKaicaizhukuangzhong(String kaicaizhukuangzhong) {
        this.kaicaizhukuangzhong = kaicaizhukuangzhong;
    }

    public String getShejikaicaizongliangkongzhikuangzhong() {
        return shejikaicaizongliangkongzhikuangzhong;
    }

    public void setShejikaicaizongliangkongzhikuangzhong(String shejikaicaizongliangkongzhikuangzhong) {
        this.shejikaicaizongliangkongzhikuangzhong = shejikaicaizongliangkongzhikuangzhong;
    }

    public String getQukuaifanwei() {
        return qukuaifanwei;
    }

    public void setQukuaifanwei(String qukuaifanwei) {
        this.qukuaifanwei = qukuaifanwei;
    }

    public String getQukuaimianji() {
        return qukuaimianji;
    }

    public void setQukuaimianji(String qukuaimianji) {
        this.qukuaimianji = qukuaimianji;
    }

    public String getShezhileixing() {
        return shezhileixing;
    }

    public void setShezhileixing(String shezhileixing) {
        this.shezhileixing = shezhileixing;
    }

    public String getZiyuanchuliangdanwei() {
        return ziyuanchuliangdanwei;
    }

    public void setZiyuanchuliangdanwei(String ziyuanchuliangdanwei) {
        this.ziyuanchuliangdanwei = ziyuanchuliangdanwei;
    }

    public String getChamingchuliang() {
        return chamingchuliang;
    }

    public void setChamingchuliang(String chamingchuliang) {
        this.chamingchuliang = chamingchuliang;
    }

    public String getToufangshixu() {
        return toufangshixu;
    }

    public void setToufangshixu(String toufangshixu) {
        this.toufangshixu = toufangshixu;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }
}
