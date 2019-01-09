package com.tom.casclient.domain;

import javax.persistence.*;

@Entity
@Table(name="geologyModellayer")
public class GeologyModelLayer extends GeologyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column
    private String mp_area;
    @Column
    private String mp_perimeter;
    @Column
    private String regcolor;
    @Column
    private String cengxu;
    @Column
    private String yancengleixing;
    @Column
    private String daihao;
    @Column
    private String dai;
    @Column
    private String ji;
    @Column
    private String shi;
    @Column
    private String qi;
    @Column
    private String jieduan;
    @Column
    private String xulie;
    @Column
    private String yachaodanyuan;
    @Column
    private String danyuan;
    @Column
    private String xi;
    @Column
    private String tong;
    @Column
    private String qun;
    @Column
    private String zu;
    @Column
    private String duan;
    @Column
    private String dicengmiaoshu;
    @Column
    private String mplayer;
    @Column
    private String tianchongyanse;
    @Column
    private String tianchongtuan;
    @Column
    private String tuanyanse;
    @Column
    private String tuandaxiao;
    @Column
    private String tuanjiaodu;

    //描述类的字段
//    public static enum Cp{
//        id("序号","id"),
//        mp_area("mp_area","mp_area"),
//        mp_perimeter("mp_perimeter","mp_perimeter"),
//        objid("模型id","objid"),
//        regcolor("REG填充颜色","regcolor"),
//        cengxu("层序","cengxu"),
//        yancengleixing("岩层类型","yancengleixing"),
//        daihao("代号","daihao"),
//        dai("代","dai"),
//        ji("纪","ji"),
//        shi("世","shi"),
//        qi("期","qi"),
//        jiduan("阶段","jieduan"),
//        xulie("序列","xulie"),
//        yachaodanyuan("亚超单元","yachaodanyuan"),
//        danyuan("单元","danyuan"),
//        xi("系","xi"),
//        tong("统","tong"),
//        qun("群","qun"),
//        zu("组","zu"),
//        duan("段","duan"),
//        dicengmiaoshu("地层描述","dicengmiaoshu"),
//        mplayer("mplayer","mplayer"),
//        tianchongyanse("填充颜色","tianchongyanse"),
//        tianchongtuan("填充图案","tianchongtuan"),
//        tuanyanse("图案颜色","tuanyanse"),
//        tuandaxiao("图案大小","tuandaxiao"),
//        tuanjiaodu("图案角度","tuanjiaodu");
//        private String name;
//        private String index;
//        private Cp(String name,String index){
//            this.name=name;
//            this.index=index;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getIndex() {
//            return index;
//        }
//
//        public void setIndex(String index) {
//            this.index = index;
//        }
//
//        public static String getName(String index){
//            for(Cp cp:Cp.values()){
//                if(cp.getIndex().equals(index)){
//                    return cp.getName();
//                }
//            }
//            return null;
//        }
//
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMpArea() {
        return mp_area;
    }

    public void setMpArea(String mp_area) {
        this.mp_area = mp_area;
    }

    public String getMpPerimeter() {
        return mp_perimeter;
    }

    public void setMpPerimeter(String mp_perimeter) {
        this.mp_perimeter = mp_perimeter;
    }

    public String getRegColor() {
        return regcolor;
    }

    public void setRegColor(String regcolor) {
        this.regcolor = regcolor;
    }

    public String getCengxu() {
        return cengxu;
    }

    public void setCengxu(String cengxu) {
        this.cengxu = cengxu;
    }

    public String getYancengleixing() {
        return yancengleixing;
    }

    public void setYancengleixing(String yancengleixing) {
        this.yancengleixing = yancengleixing;
    }

    public String getDaihao() {
        return daihao;
    }

    public void setDaihao(String daihao) {
        this.daihao = daihao;
    }

    public String getDai() {
        return dai;
    }

    public void setDai(String dai) {
        this.dai = dai;
    }

    public String getJi() {
        return ji;
    }

    public void setJi(String ji) {
        this.ji = ji;
    }

    public String getShi() {
        return shi;
    }

    public void setShi(String shi) {
        this.shi = shi;
    }

    public String getQi() {
        return qi;
    }

    public void setQi(String qi) {
        this.qi = qi;
    }

    public String getJieduan() {
        return jieduan;
    }

    public void setJieduan(String jieduan) {
        this.jieduan = jieduan;
    }

    public String getXulie() {
        return xulie;
    }

    public void setXulie(String xulie) {
        this.xulie = xulie;
    }

    public String getYachaodanyuan() {
        return yachaodanyuan;
    }

    public void setYachaodanyuan(String yachaodanyuan) {
        this.yachaodanyuan = yachaodanyuan;
    }

    public String getDanyuan() {
        return danyuan;
    }

    public void setDanyuan(String danyuan) {
        this.danyuan = danyuan;
    }

    public String getXi() {
        return xi;
    }

    public void setXi(String xi) {
        this.xi = xi;
    }

    public String getTong() {
        return tong;
    }

    public void setTong(String tong) {
        this.tong = tong;
    }

    public String getQun() {
        return qun;
    }

    public void setQun(String qun) {
        this.qun = qun;
    }

    public String getZu() {
        return zu;
    }

    public void setZu(String zu) {
        this.zu = zu;
    }

    public String getDuan() {
        return duan;
    }

    public void setDuan(String duan) {
        this.duan = duan;
    }

    public String getDicengmiaoshu() {
        return dicengmiaoshu;
    }

    public void setDicengmiaoshu(String dicengmiaoshu) {
        this.dicengmiaoshu = dicengmiaoshu;
    }

    public String getMplayer() {
        return mplayer;
    }

    public void setMplayer(String mplayer) {
        this.mplayer = mplayer;
    }

    public String getTianchongyanse() {
        return tianchongyanse;
    }

    public void setTianchongyanse(String tianchongyanse) {
        this.tianchongyanse = tianchongyanse;
    }

    public String getTianchongtuan() {
        return tianchongtuan;
    }

    public void setTianchongtuan(String tianchongtuan) {
        this.tianchongtuan = tianchongtuan;
    }

    public String getTuanyanse() {
        return tuanyanse;
    }

    public void setTuanyanse(String tuanyanse) {
        this.tuanyanse = tuanyanse;
    }

    public String getTuandaxiao() {
        return tuandaxiao;
    }

    public void setTuandaxiao(String tuandaxiao) {
        this.tuandaxiao = tuandaxiao;
    }

    public String getTuanjiaodu() {
        return tuanjiaodu;
    }

    public void setTuanjiaodu(String tuanjiaodu) {
        this.tuanjiaodu = tuanjiaodu;
    }
}
