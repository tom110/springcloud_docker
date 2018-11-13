package com.tom.casclient.controller;

import com.tom.casclient.domain.GeologyModelLayer;
import com.tom.casclient.service.GeologyModelLayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AttrController {
    @Autowired
    public GeologyModelLayerService geologyModelLayerService;

    @RequestMapping(value = "/getGeologyModelLayer", method = RequestMethod.POST,produces="application/json")
    public GeologyModelLayer getGeologyModelLayer(@RequestParam("objid") Integer objid){
        return geologyModelLayerService.getGeologyModelLayer(objid);
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
}
