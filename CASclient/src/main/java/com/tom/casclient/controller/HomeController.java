package com.tom.casclient.controller;

import com.tom.casclient.domain.*;
import com.tom.casclient.service.GeoModelService;
import com.tom.casclient.service.GeologyModelLayerService;
import com.tom.casclient.service.lmpl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private GeologyModelLayerService geologyModelLayerService;
    @Autowired
    @Qualifier("geologyBisectLayerService")
    private GeoModelService geologyBisectLayerService;
    @Autowired
    @Qualifier("geologyDisruptLayerService")
    private GeoModelService geologyDisruptLayerService;

    @Autowired
    @Qualifier("geologySectionLayerService")
    private GeoModelService GeologySectionLayerService;

    @Autowired
    private GeologyDisasterService geologyDisasterService;

    @Autowired
    private GeologyGroundWaterService geologyGroundWaterService;

    @Autowired
    private GeologyGeothermalService geologyGeothermalService;

    @Autowired
    private GeologyMarineRanchingService geologyMarineRanchingService;

    @Autowired
    private GeologyMineralService geologyMineralService;


    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(ModelMap modelMap, HttpSession session) {
        modelMap.addAttribute("msg", "welcome to spring-boot-cas-client!");
        modelMap.addAttribute("sessionId", session.getId());
        return "index";
    }

    @GetMapping(value = "/user")
    public String user(ModelMap modelMap) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        modelMap.addAttribute("user", user);
        return "user";
    }

    @GetMapping(value = "/main")
    public String main() {
        return "main";
    }

    @GetMapping(value = "/globleImages")
    public String globleImages() {
        return "globleImages";
    }

    @GetMapping(value = "/flood")
    public String flood() {
        return "flood";
    }

    @GetMapping(value = "/cutFill")
    public String cutFill() {
        return "cutFill";
    }

    @GetMapping(value = "/cutting")
    public String cutting() {
        return "cutting";
    }

    @GetMapping(value = "/showModel")
    public String showModel() {
        return "showModel";
    }

    @GetMapping(value = "/pipe")
    public String pipe() {
        return "pipe";
    }

    @GetMapping(value = "/attrs")
    public String attrs() {
        return "attrs";
    }

    @GetMapping(value = "/dem")
    public String dem() {
        return "dem";
    }

    @GetMapping(value = "/xyzCutting")
    public String xyzCutting() {
        return "xyzcutting";
    }

    @GetMapping(value = "/legend/{legend}")
    public String legend(@PathVariable("legend") String legend) {
        if(legend.equals("mpro"))
            return "mpro";
        else if(legend.equals("genv"))
            return "genv";
        else if(legend.equals("unspace"))
            return "unspace";
        else
            return "";
    }

    @GetMapping(value = "/showImage/{modelFlag}/number")
    public String attrInfo(@PathVariable("modelFlag") String modelFlag,@PathVariable("number") String number, Model model){

        return "ImageShow";
    }

    @GetMapping(value = "/attrInfo/{modelFlag}/{objid}")
    public String attrInfo(@PathVariable("objid") Integer objid,@PathVariable("modelFlag") String modelFlag, Model model){
        if(modelFlag.equalsIgnoreCase("kuai")){
            getRequestModel_Bisect(objid, model,geologyBisectLayerService,new GeologyBisectLayer());
        }else if(modelFlag.equalsIgnoreCase("duan")){
            getRequestModel_Disrupt(objid,model, geologyDisruptLayerService,new GeologyDisruptLayer());
        }else if(modelFlag.equalsIgnoreCase("po")){
            getRequestModel_Section(objid,model, GeologySectionLayerService,new GeologySectionLayer());
        }else if(modelFlag.equalsIgnoreCase("gdis")){
            getRequestModel_disaster(objid,model, geologyDisasterService,new GeologyDisaster());
        }else if(modelFlag.equalsIgnoreCase("marineranching")){
            getRequestModel_Marineranching(objid,model, geologyMarineRanchingService,new GeologyMarineranching());
        }else if(modelFlag.equalsIgnoreCase("groundwater")){
            getRequestModel_Groundwater(objid,model, geologyGroundWaterService,new GeologyGroundwater());
        }else if(modelFlag.equalsIgnoreCase("mineral")){
            getRequestModel_Mineral(objid,model, geologyMineralService,new GeologyMineral());
        }else if(modelFlag.equalsIgnoreCase("geothermal")){
            getRequestModel_Geothermal(objid,model, geologyGeothermalService,new GeologyGeothermal());
        }

        model.addAttribute("modelFlag",modelFlag);
        return "attrInfo";
    }


    //处理地块
    private void getRequestModel_Bisect(@PathVariable("objid") Integer objid, Model model, GeoModelService geoModelService, GeologyModel geoModel) {
        GeologyModel geologyModel = geoModelService.getGeologyModel(objid);
        //属性字段对应字典
        Map<String, Object> fieldWithValue = new HashMap<>();
        //属性和属性别名字典
        Map<String, String> fieds = new HashMap<String, String>();
        if (geologyModel == null) {
            Field[] fields = geoModel.getClass().getDeclaredFields();
            for (Field field : fields) {
                fieds.put(GeologyBisectLayer.Cp.getName(field.getName()), field.getName());
                fieldWithValue.put(field.getName(), null);
            }
        } else {
            Field[] fields = geologyModel.getClass().getDeclaredFields();
            for (Field field : fields) {
                fieds.put(GeologyBisectLayer.Cp.getName(field.getName()), field.getName());
                fieldWithValue.put(field.getName(), getFieldValueByFieldName(field.getName(), geologyModel));
            }
        }
        model.addAttribute("fields", fieds);
        model.addAttribute("cpCount",GeologyBisectLayer.Cp.values().length);

        Map<Integer,String> geologyBisectLayerIndex=new HashMap<Integer, String>();
        Map<Integer,Integer> geologyBisectLayerStatus=new HashMap<>();
        for(Integer i=1;i<= GeologyBisectLayer.Cp.values().length;i++){
            geologyBisectLayerIndex.put(i,GeologyBisectLayer.Cp.getCpByOrder(i));
            geologyBisectLayerStatus.put(i,GeologyBisectLayer.Cp.getStatusByOrder(i));
        }
        model.addAttribute("geologyBisectLayer",geologyBisectLayerIndex);
        model.addAttribute("geologyBisectLayerStatus",geologyBisectLayerStatus);

        model.addAttribute("modelFlag","saveGeologyBisect");
        model.addAttribute("objid", objid);
        model.addAttribute("fieldWithValue", fieldWithValue);
    }

    //处理断层
    private void getRequestModel_Disrupt(@PathVariable("objid") Integer objid, Model model, GeoModelService geoModelService, GeologyModel geoModel) {
        GeologyModel geologyModel = geoModelService.getGeologyModel(objid);
        //属性字段对应字典
        Map<String, Object> fieldWithValue = new HashMap<>();
        //属性和属性别名字典
        Map<String, String> fieds = new HashMap<String, String>();
        if (geologyModel == null) {
            Field[] fields = geoModel.getClass().getDeclaredFields();
            for (Field field : fields) {
                fieds.put(GeologyDisruptLayer.Cp.getName(field.getName()), field.getName());
                fieldWithValue.put(field.getName(), null);
            }
        } else {
            Field[] fields = geologyModel.getClass().getDeclaredFields();
            for (Field field : fields) {
                fieds.put(GeologyDisruptLayer.Cp.getName(field.getName()), field.getName());
                fieldWithValue.put(field.getName(), getFieldValueByFieldName(field.getName(), geologyModel));
            }
        }
        model.addAttribute("fields", fieds);
        model.addAttribute("cpCount",GeologyDisruptLayer.Cp.values().length);

        Map<Integer,String> geologyBisectLayerIndex=new HashMap<Integer, String>();
        Map<Integer,Integer> geologyBisectLayerStatus=new HashMap<>();
        for(Integer i=1;i<= GeologyDisruptLayer.Cp.values().length;i++){
            geologyBisectLayerIndex.put(i,GeologyDisruptLayer.Cp.getCpByOrder(i));
            geologyBisectLayerStatus.put(i,GeologyDisruptLayer.Cp.getStatusByOrder(i));
        }
        model.addAttribute("geologyBisectLayer",geologyBisectLayerIndex);
        model.addAttribute("geologyBisectLayerStatus",geologyBisectLayerStatus);

        model.addAttribute("modelFlag","saveGeologyBisect");
        model.addAttribute("objid", objid);
        model.addAttribute("fieldWithValue", fieldWithValue);
    }

    //处理剖面
    private void getRequestModel_Section(@PathVariable("objid") Integer objid, Model model, GeoModelService geoModelService, GeologyModel geoModel) {
        GeologyModel geologyModel = geoModelService.getGeologyModel(objid);
        //属性字段对应字典
        Map<String, Object> fieldWithValue = new HashMap<>();
        //属性和属性别名字典
        Map<String, String> fieds = new HashMap<String, String>();
        if (geologyModel == null) {
            Field[] fields = geoModel.getClass().getDeclaredFields();
            for (Field field : fields) {
                fieds.put(GeologySectionLayer.Cp.getName(field.getName()), field.getName());
                fieldWithValue.put(field.getName(), null);
            }
        } else {
            Field[] fields = geologyModel.getClass().getDeclaredFields();
            for (Field field : fields) {
                fieds.put(GeologySectionLayer.Cp.getName(field.getName()), field.getName());
                fieldWithValue.put(field.getName(), getFieldValueByFieldName(field.getName(), geologyModel));
            }
        }
        model.addAttribute("fields", fieds);
        model.addAttribute("cpCount",GeologySectionLayer.Cp.values().length);

        Map<Integer,String> geologyBisectLayerIndex=new HashMap<Integer, String>();
        Map<Integer,Integer> geologyBisectLayerStatus=new HashMap<>();
        for(Integer i=1;i<= GeologySectionLayer.Cp.values().length;i++){
            geologyBisectLayerIndex.put(i,GeologySectionLayer.Cp.getCpByOrder(i));
            geologyBisectLayerStatus.put(i,GeologySectionLayer.Cp.getStatusByOrder(i));
        }
        model.addAttribute("geologyBisectLayer",geologyBisectLayerIndex);
        model.addAttribute("geologyBisectLayerStatus",geologyBisectLayerStatus);

        model.addAttribute("modelFlag","saveGeologyBisect");
        model.addAttribute("objid", objid);
        model.addAttribute("fieldWithValue", fieldWithValue);
    }

    //处理地质灾害
    private void getRequestModel_disaster(@PathVariable("objid") Integer objid, Model model, GeoModelService geoModelService, GeologyModel geoModel) {
        GeologyModel geologyModel = geoModelService.getGeologyModel(objid);
        //属性字段对应字典
        Map<String, Object> fieldWithValue = new HashMap<>();
        //属性和属性别名字典
        Map<String, String> fieds = new HashMap<String, String>();
        if (geologyModel == null) {
            Field[] fields = geoModel.getClass().getDeclaredFields();
            for (Field field : fields) {
                fieds.put(GeologyDisaster.Cp.getName(field.getName()), field.getName());
                fieldWithValue.put(field.getName(), null);
            }
        } else {
            Field[] fields = geologyModel.getClass().getDeclaredFields();
            for (Field field : fields) {
                fieds.put(GeologyDisaster.Cp.getName(field.getName()), field.getName());
                fieldWithValue.put(field.getName(), getFieldValueByFieldName(field.getName(), geologyModel));
            }
        }
        model.addAttribute("fields", fieds);
        model.addAttribute("cpCount",GeologyDisaster.Cp.values().length);

        Map<Integer,String> geologyBisectLayerIndex=new HashMap<Integer, String>();
        Map<Integer,Integer> geologyBisectLayerStatus=new HashMap<>();
        for(Integer i=1;i<= GeologyDisaster.Cp.values().length;i++){
            geologyBisectLayerIndex.put(i,GeologyDisaster.Cp.getCpByOrder(i));
            geologyBisectLayerStatus.put(i,GeologyDisaster.Cp.getStatusByOrder(i));
        }
        model.addAttribute("geologyBisectLayer",geologyBisectLayerIndex);
        model.addAttribute("geologyBisectLayerStatus",geologyBisectLayerStatus);

        model.addAttribute("modelFlag","saveGeologyBisect");
        model.addAttribute("objid", objid);
        model.addAttribute("fieldWithValue", fieldWithValue);
    }

    //处理海洋牧场
    private void getRequestModel_Marineranching(@PathVariable("objid") Integer objid, Model model, GeoModelService geoModelService, GeologyModel geoModel) {
        GeologyModel geologyModel = geoModelService.getGeologyModel(objid);
        //属性字段对应字典
        Map<String, Object> fieldWithValue = new HashMap<>();
        //属性和属性别名字典
        Map<String, String> fieds = new HashMap<String, String>();
        if (geologyModel == null) {
            Field[] fields = geoModel.getClass().getDeclaredFields();
            for (Field field : fields) {
                fieds.put(GeologyMarineranching.Cp.getName(field.getName()), field.getName());
                fieldWithValue.put(field.getName(), null);
            }
        } else {
            Field[] fields = geologyModel.getClass().getDeclaredFields();
            for (Field field : fields) {
                fieds.put(GeologyMarineranching.Cp.getName(field.getName()), field.getName());
                fieldWithValue.put(field.getName(), getFieldValueByFieldName(field.getName(), geologyModel));
            }
        }
        model.addAttribute("fields", fieds);
        model.addAttribute("cpCount",GeologyMarineranching.Cp.values().length);

        Map<Integer,String> geologyBisectLayerIndex=new HashMap<Integer, String>();
        Map<Integer,Integer> geologyBisectLayerStatus=new HashMap<>();
        for(Integer i=1;i<= GeologyMarineranching.Cp.values().length;i++){
            geologyBisectLayerIndex.put(i,GeologyMarineranching.Cp.getCpByOrder(i));
            geologyBisectLayerStatus.put(i,GeologyMarineranching.Cp.getStatusByOrder(i));
        }
        model.addAttribute("geologyBisectLayer",geologyBisectLayerIndex);
        model.addAttribute("geologyBisectLayerStatus",geologyBisectLayerStatus);

        model.addAttribute("modelFlag","saveGeologyBisect");
        model.addAttribute("objid", objid);
        model.addAttribute("fieldWithValue", fieldWithValue);
    }

    //处理地下水监测
    private void getRequestModel_Groundwater(@PathVariable("objid") Integer objid, Model model, GeoModelService geoModelService, GeologyModel geoModel) {
        GeologyModel geologyModel = geoModelService.getGeologyModel(objid);
        //属性字段对应字典
        Map<String, Object> fieldWithValue = new HashMap<>();
        //属性和属性别名字典
        Map<String, String> fieds = new HashMap<String, String>();
        if (geologyModel == null) {
            Field[] fields = geoModel.getClass().getDeclaredFields();
            for (Field field : fields) {
                fieds.put(GeologyGroundwater.Cp.getName(field.getName()), field.getName());
                fieldWithValue.put(field.getName(), null);
            }
        } else {
            Field[] fields = geologyModel.getClass().getDeclaredFields();
            for (Field field : fields) {
                fieds.put(GeologyGroundwater.Cp.getName(field.getName()), field.getName());
                fieldWithValue.put(field.getName(), getFieldValueByFieldName(field.getName(), geologyModel));
            }
        }
        model.addAttribute("fields", fieds);
        model.addAttribute("cpCount",GeologyGroundwater.Cp.values().length);

        Map<Integer,String> geologyBisectLayerIndex=new HashMap<Integer, String>();
        Map<Integer,Integer> geologyBisectLayerStatus=new HashMap<>();
        for(Integer i=1;i<= GeologyGroundwater.Cp.values().length;i++){
            geologyBisectLayerIndex.put(i,GeologyGroundwater.Cp.getCpByOrder(i));
            geologyBisectLayerStatus.put(i,GeologyGroundwater.Cp.getStatusByOrder(i));
        }
        model.addAttribute("geologyBisectLayer",geologyBisectLayerIndex);
        model.addAttribute("geologyBisectLayerStatus",geologyBisectLayerStatus);

        model.addAttribute("modelFlag","saveGeologyBisect");
        model.addAttribute("objid", objid);
        model.addAttribute("fieldWithValue", fieldWithValue);
    }

    //处理地热监测
    private void getRequestModel_Geothermal(@PathVariable("objid") Integer objid, Model model, GeoModelService geoModelService, GeologyModel geoModel) {
        GeologyModel geologyModel = geoModelService.getGeologyModel(objid);
        //属性字段对应字典
        Map<String, Object> fieldWithValue = new HashMap<>();
        //属性和属性别名字典
        Map<String, String> fieds = new HashMap<String, String>();
        if (geologyModel == null) {
            Field[] fields = geoModel.getClass().getDeclaredFields();
            for (Field field : fields) {
                fieds.put(GeologyGeothermal.Cp.getName(field.getName()), field.getName());
                fieldWithValue.put(field.getName(), null);
            }
        } else {
            Field[] fields = geologyModel.getClass().getDeclaredFields();
            for (Field field : fields) {
                fieds.put(GeologyGeothermal.Cp.getName(field.getName()), field.getName());
                fieldWithValue.put(field.getName(), getFieldValueByFieldName(field.getName(), geologyModel));
            }
        }
        model.addAttribute("fields", fieds);
        model.addAttribute("cpCount",GeologyGeothermal.Cp.values().length);

        Map<Integer,String> geologyBisectLayerIndex=new HashMap<Integer, String>();
        Map<Integer,Integer> geologyBisectLayerStatus=new HashMap<>();
        for(Integer i=1;i<= GeologyGeothermal.Cp.values().length;i++){
            geologyBisectLayerIndex.put(i,GeologyGeothermal.Cp.getCpByOrder(i));
            geologyBisectLayerStatus.put(i,GeologyGeothermal.Cp.getStatusByOrder(i));
        }
        model.addAttribute("geologyBisectLayer",geologyBisectLayerIndex);
        model.addAttribute("geologyBisectLayerStatus",geologyBisectLayerStatus);

        model.addAttribute("modelFlag","saveGeologyBisect");
        model.addAttribute("objid", objid);
        model.addAttribute("fieldWithValue", fieldWithValue);
    }

    //处理矿产点
    private void getRequestModel_Mineral(@PathVariable("objid") Integer objid, Model model, GeoModelService geoModelService, GeologyModel geoModel) {
        GeologyModel geologyModel = geoModelService.getGeologyModel(objid);
        //属性字段对应字典
        Map<String, Object> fieldWithValue = new HashMap<>();
        //属性和属性别名字典
        Map<String, String> fieds = new HashMap<String, String>();
        if (geologyModel == null) {
            Field[] fields = geoModel.getClass().getDeclaredFields();
            for (Field field : fields) {
                fieds.put(GeologyMineral.Cp.getName(field.getName()), field.getName());
                fieldWithValue.put(field.getName(), null);
            }
        } else {
            Field[] fields = geologyModel.getClass().getDeclaredFields();
            for (Field field : fields) {
                fieds.put(GeologyMineral.Cp.getName(field.getName()), field.getName());
                fieldWithValue.put(field.getName(), getFieldValueByFieldName(field.getName(), geologyModel));
            }
        }
        model.addAttribute("fields", fieds);
        model.addAttribute("cpCount",GeologyMineral.Cp.values().length);

        Map<Integer,String> geologyBisectLayerIndex=new HashMap<Integer, String>();
        Map<Integer,Integer> geologyBisectLayerStatus=new HashMap<>();
        for(Integer i=1;i<= GeologyMineral.Cp.values().length;i++){
            geologyBisectLayerIndex.put(i,GeologyMineral.Cp.getCpByOrder(i));
            geologyBisectLayerStatus.put(i,GeologyMineral.Cp.getStatusByOrder(i));
        }
        model.addAttribute("geologyBisectLayer",geologyBisectLayerIndex);
        model.addAttribute("geologyBisectLayerStatus",geologyBisectLayerStatus);

        model.addAttribute("modelFlag","saveGeologyBisect");
        model.addAttribute("objid", objid);
        model.addAttribute("fieldWithValue", fieldWithValue);
    }



    private Object getFieldValueByFieldName(String fieldName,Object o){
        try{
            String firstLetter=fieldName.substring(0,1).toUpperCase();
            String getter="get"+firstLetter+fieldName.substring(1);
            Method method=o.getClass().getMethod(getter,new Class[]{});
            Object value=method.invoke(o,new Object[]{});
            return value;
        }catch (Exception e){
            return null;
        }
    }





}
