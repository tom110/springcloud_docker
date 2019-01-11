package com.tom.casclient.controller;

import com.tom.casclient.domain.GeologyDisaster;
import com.tom.casclient.domain.GeologyPointModel;
import com.tom.casclient.service.GeoModelService;
import com.tom.casclient.service.lmpl.*;
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

    @Autowired
    private GeologyGroundWaterService geologyGroundWaterService;

    @Autowired
    private GeologyGeothermalService geologyGeothermalService;

    @Autowired
    private GeologyMarineRanchingService geologyMarineRanchingService;

    @Autowired
    private GeologyMineralService geologyMineralService;

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
        if(modelFlag.equalsIgnoreCase("gdis")){
            return returnNearestPoint(dx, dy,geologyDisasterService);
        }else if(modelFlag.equalsIgnoreCase("groundwater")){
            return returnNearestPoint(dx, dy,geologyGroundWaterService);
        }else if(modelFlag.equalsIgnoreCase("geothermal")){
            return returnNearestPoint(dx, dy,geologyGeothermalService);
        }else if(modelFlag.equalsIgnoreCase("mineral")){
            return returnNearestPoint(dx, dy,geologyMineralService);
        }else if(modelFlag.equalsIgnoreCase("marineranching")){
            return returnNearestPoint(dx, dy,geologyMarineRanchingService);
        }
        else{
            return null;
        }
    }

    private List<Double> returnNearestPoint(@RequestParam("dx") double dx, @RequestParam("dy") double dy, GeoModelService geoModelService) {
        List<Double> distances=new ArrayList<Double>();
        List<List<Double>> dxdy=new ArrayList<>();
        List<GeologyPointModel> GeologyPointModels= (List<GeologyPointModel>) geoModelService.listAll();
        GeologyPointModels.stream().forEach(geologyPointModel -> {
            Double geox=Double.parseDouble(geologyPointModel.getX());
            Double geoy=Double.parseDouble(geologyPointModel.getY());
            Double x=dx- geox;
            Double y=dy-geoy;
            distances.add(x*x+y*y );
            List<Double> xy=new ArrayList<>();
            xy.add(geox);
            xy.add(geoy);
            dxdy.add(xy);
        });
        Double nearestDistance= Collections.min(distances);
        if (nearestDistance<1000000){
            return dxdy.get(distances.indexOf(nearestDistance));
        }else{
            return null;
        }
    }
}
