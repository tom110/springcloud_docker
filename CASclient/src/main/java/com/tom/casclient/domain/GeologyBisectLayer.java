package com.tom.casclient.domain;

import com.tom.casclient.domain.enums.GeoEnum;
import com.tom.casclient.domain.enums.GeologyBisectEnum;

import javax.persistence.*;

@Entity
@Table(name="geologyBisectlayer")
public class GeologyBisectLayer extends GeologyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column
    private String oldid;
    @Column
    private String mparea;
    @Column
    private String mpperimeter;
    @Column
    private String yancengleixing;
    @Column
    private String yanxingdaima;
    @Column
    private String dai;
    @Column
    private String yanxingmiaoshu;
    @Column
    private String ji;
    @Column
    private String qun;
    @Column
    private String tong;
    @Column
    private String duan;
    @Column
    private String zu;
    @Column
    private String jieduan;
    @Column
    private String qi;
    @Column
    private String danyuan;
    @Column
    private String xulie;
    @Column
    private String regtianchongyanse;
    @Column
    private String regtianchongtuan;
    @Column
    private String regtuangaodu;
    @Column
    private String regtuankuandu;
    @Column
    private String regtuanyanse;
    @Column
    private String regtuceng;
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
    public enum Cp{
        id("序号","id",1,0),
        oldid("原id","oldid",2,0),
        mparea("mparea","mparea",3,0),
        mpperimeter("mpperimeter","mpperimeter",4,0),
        yancengleixing("岩层类型","yancengleixing",5,1),
        yanxingdaima("岩性代码","yanxingdaima",6,1),
        dai("代","dai",7,1),
        yanxingmiaoshu("岩性描述","yanxingmiaoshu",8,1),
        ji("纪","ji",9,1),
        qun("群","qun",10,1),
        tong("统","tong",11,1),
        duan("段","duan",12,1),
        zu("组","zu",13,1),
        jieduan("阶段","jieduan",14,1),
        qi("期","qi",15,1),
        danyuan("单元","danyuan",16,1),
        xulie("序列","xulie",17,1),
        rggtianchongyanse("REG填充颜色","regtianchongyanse",18,0),
        regtianchongtuan("REG填充图案","regtianchongtuan",19,0),
        regtuangaodu("REG图案高度","regtuangaodu",20,0),
        regtuankuandu("REG图案宽度","regtuankuandu",21,0),
        regtuanyanse("REG图案颜色","regtuanyanse",22,0),
        regtuceng("REG图层","regtuceng",23,0),
        mplayer("mplayer","maplayer",24,0),
        tianchongyanse("填充颜色","yanchongyanse",25,0),
        tianchongtuan("填充图案","tianchongtuan",26,0),
        tuanyanse("图案颜色","tuanyanse",27,0),
        tuandaxiao("图案大小","tuandaxiao",28,0),
        tuanjiaodu("图案角度","tuanjiaodu",29,0);
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
            for(GeologyBisectLayer.Cp cp: GeologyBisectLayer.Cp.values()){
                if(cp.getIndex().equals(index)){
                    return cp.getName();
                }
            }
            return null;
        }

        public static String getCpByOrder(Integer order){
            for(GeologyBisectLayer.Cp cp: GeologyBisectLayer.Cp.values()){
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

    public String getOldid() {
        return oldid;
    }

    public void setOldid(String oldid) {
        this.oldid = oldid;
    }

    public String getMparea() {
        return mparea;
    }

    public void setMparea(String mparea) {
        this.mparea = mparea;
    }

    public String getMpperimeter() {
        return mpperimeter;
    }

    public void setMpperimeter(String mpperimeter) {
        this.mpperimeter = mpperimeter;
    }

    public String getYancengleixing() {
        return yancengleixing;
    }

    public void setYancengleixing(String yancengleixing) {
        this.yancengleixing = yancengleixing;
    }

    public String getYanxingdaima() {
        return yanxingdaima;
    }

    public void setYanxingdaima(String yanxingdaima) {
        this.yanxingdaima = yanxingdaima;
    }

    public String getDai() {
        return dai;
    }

    public void setDai(String dai) {
        this.dai = dai;
    }

    public String getYanxingmiaoshu() {
        return yanxingmiaoshu;
    }

    public void setYanxingmiaoshu(String yanxingmiaoshu) {
        this.yanxingmiaoshu = yanxingmiaoshu;
    }

    public String getJi() {
        return ji;
    }

    public void setJi(String ji) {
        this.ji = ji;
    }

    public String getQun() {
        return qun;
    }

    public void setQun(String qun) {
        this.qun = qun;
    }

    public String getTong() {
        return tong;
    }

    public void setTong(String tong) {
        this.tong = tong;
    }

    public String getDuan() {
        return duan;
    }

    public void setDuan(String duan) {
        this.duan = duan;
    }

    public String getZu() {
        return zu;
    }

    public void setZu(String zu) {
        this.zu = zu;
    }

    public String getJieduan() {
        return jieduan;
    }

    public void setJieduan(String jieduan) {
        this.jieduan = jieduan;
    }

    public String getQi() {
        return qi;
    }

    public void setQi(String qi) {
        this.qi = qi;
    }

    public String getDanyuan() {
        return danyuan;
    }

    public void setDanyuan(String danyuan) {
        this.danyuan = danyuan;
    }

    public String getXulie() {
        return xulie;
    }

    public void setXulie(String xulie) {
        this.xulie = xulie;
    }

    public String getRegtianchongyanse() {
        return regtianchongyanse;
    }

    public void setRegtianchongyanse(String regtianchongyanse) {
        this.regtianchongyanse = regtianchongyanse;
    }

    public String getRegtianchongtuan() {
        return regtianchongtuan;
    }

    public void setRegtianchongtuan(String regtianchongtuan) {
        this.regtianchongtuan = regtianchongtuan;
    }

    public String getRegtuangaodu() {
        return regtuangaodu;
    }

    public void setRegtuangaodu(String regtuangaodu) {
        this.regtuangaodu = regtuangaodu;
    }

    public String getRegtuankuandu() {
        return regtuankuandu;
    }

    public void setRegtuankuandu(String regtuankuandu) {
        this.regtuankuandu = regtuankuandu;
    }

    public String getRegtuanyanse() {
        return regtuanyanse;
    }

    public void setRegtuanyanse(String regtuanyanse) {
        this.regtuanyanse = regtuanyanse;
    }

    public String getRegtuceng() {
        return regtuceng;
    }

    public void setRegtuceng(String regtuceng) {
        this.regtuceng = regtuceng;
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
