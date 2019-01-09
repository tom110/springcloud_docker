package com.tom.casclient.controller;

import com.tom.casclient.domain.GeologyDisaster;
import com.tom.casclient.service.lmpl.GeologyDisasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.geom.Arc2D;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class JsonController {
    @Autowired
    private GeologyDisasterService geologyDisasterService;

    @RequestMapping(value = "/getModelIds",method = RequestMethod.POST,produces="application/json")
    public List<Integer> getModelIds(@RequestParam("modelFlag") String modelFlag){
        List<GeologyDisaster> geologyDisasters=null;
        if(modelFlag.equals("gdis")){
            geologyDisasters= (List<GeologyDisaster>) geologyDisasterService.listAll();
        }
        List<Integer> modelIds=new ArrayList<>();
        geologyDisasters.stream().forEach(geologyDisaster -> {
            modelIds.add(geologyDisaster.getObjid());
        });

        return modelIds;
    }

    @RequestMapping(value = "/getNearestPoint",method = RequestMethod.POST,produces="application/json")
    public List<Double> getNearestPoint(@RequestParam("modelFlag") String modelFlag,
                                        @RequestParam("dx") double dx,
                                        @RequestParam("dy") double dy){
        List<Double> distances=new ArrayList<Double>();
        List<List<Double>> dxdy=new ArrayList<>();
        if(modelFlag.equalsIgnoreCase("gdis")){
            List<GeologyDisaster> geologyDisasters= (List<GeologyDisaster>) geologyDisasterService.listAll();
            geologyDisasters.stream().forEach(geologyDisaster -> {
                Double x=dx- Double.parseDouble(geologyDisaster.getX());
                Double y=dy-Double.parseDouble(geologyDisaster.getY());
                distances.add(x*x+y*y );
                List<Double> xy=new ArrayList<>();
                xy.add(Double.parseDouble(geologyDisaster.getX()));
                xy.add(Double.parseDouble(geologyDisaster.getY()));
                dxdy.add(xy);
            });
            Double nearestDistance=Collections.min(distances);
            if (nearestDistance<1000000){
                return dxdy.get(distances.indexOf(nearestDistance));
            }else{
                return null;
            }
        }else{
            return null;
        }
    }
}
