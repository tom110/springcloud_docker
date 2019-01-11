package com.tom.casclient.controller;

import com.netflix.discovery.converters.Auto;
import com.tom.casclient.domain.*;
import com.tom.casclient.service.GeoModelService;
import com.tom.casclient.service.GeologyBisectLayerService;
import com.tom.casclient.service.GeologyModelLayerService;
import com.tom.casclient.service.lmpl.GeologyDisasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AttrController {
    @Autowired
    public GeologyModelLayerService geologyModelLayerService;
    @Autowired
    public GeologyBisectLayerService geologyBisectLayerService;

    @Autowired
    private GeologyDisasterService geologyDisasterService;

    @Autowired
    @Qualifier("geologyDisruptLayerService")
    public GeoModelService geologyDisruptLayerService;

    @Autowired
    @Qualifier("geologySectionLayerService")
    private GeoModelService GeologySectionLayerService;
    //地层部分//
    @RequestMapping(value = "/getGeologyModelLayer", method = RequestMethod.POST,produces="application/json")
    public GeologyModelLayer getGeologyModelLayer(@RequestParam("objid") Integer objid){
        return geologyModelLayerService.getGeologyModel(objid);
    }
    @RequestMapping(value = "getGeologyModelLayerFields",method = RequestMethod.GET,produces="application/json")
    public List<String> getGeologyModelLayerFields(){
        List<String> fieds=new ArrayList<String>();
        Field[] fields=GeologyModelLayer.class.getDeclaredFields();
        for(Field field:fields){
            fieds.add(GeologyModelLayer.Cp.getName(field.getName())) ;
        }
        return fieds;
    }

    @RequestMapping(value = "/saveGeologyModel",method = RequestMethod.POST)
    public String saveGeologyModel(GeologyModelLayer geologyModelLayer){
        geologyModelLayerService.saveOrUpdate(geologyModelLayer);
        return  "redirect:/attrInfo/"+geologyModelLayer.getObjid();
    }

    //断层部分//
    @RequestMapping(value = "/getGeologyBisectLayer", method = RequestMethod.POST,produces="application/json")
    public GeologyModelLayer getGeologyBisectLayer(@RequestParam("objid") Integer objid){
        return geologyModelLayerService.getGeologyModel(objid);
    }

    @RequestMapping(value = "getGeologyBisectLayerFields",method = RequestMethod.GET,produces="application/json")
    public List<String> getGeologyBisectLayerFields(){
        List<String> fieds=new ArrayList<String>();
        Field[] fields=GeologyBisectLayer.class.getDeclaredFields();
        for(Field field:fields){
            fieds.add(GeologyBisectLayer.Cp.getName(field.getName())) ;
        }
        return fieds;
    }

    @RequestMapping(value = "/saveGeologyBisect",method = RequestMethod.POST)
    public String saveGeologyBisect(GeologyBisectLayer geologyBisectLayer){
        geologyBisectLayerService.saveOrUpdate(geologyBisectLayer);
        return  "redirect:/attrInfo/kuai/"+geologyBisectLayer.getObjid();
    }

    @RequestMapping(value = "/saveGeologyDisrupt",method = RequestMethod.POST)
    public String saveGeologyBisect(GeologyDisruptLayer geologyDisruptLayer){
        geologyDisruptLayerService.saveOrUpdate(geologyDisruptLayer);
        return  "redirect:/attrInfo/duan/"+geologyDisruptLayer.getObjid();
    }

    @RequestMapping(value = "/saveGeologySection",method = RequestMethod.POST)
    public String saveGeologySection(GeologySectionLayer geologySectionLayer){
        GeologySectionLayerService.saveOrUpdate(geologySectionLayer);
        return  "redirect:/attrInfo/po/"+geologySectionLayer.getObjid();
    }




}
