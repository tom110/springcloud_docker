package com.tom.casclient.controller;

import com.tom.casclient.domain.GeologyModel;
import com.tom.casclient.domain.GeologyModelLayer;
import com.tom.casclient.service.GeologyModelLayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private GeologyModelLayerService geologyModelLayerService;

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

    @GetMapping(value = "/attrInfo/{objid}")
    public String attrInfo(@PathVariable("objid") Integer objid, Model model) {
        GeologyModel geologyModel = geologyModelLayerService.getGeologyModelLayer(objid);

        //属性字段对应字典
        Map<String, Object> fieldWithValue = new HashMap<>();
        //属性和属性别名字典
        Map<String, String> fieds = new HashMap<String, String>();
        if (geologyModel == null) {
            Field[] fields = GeologyModelLayer.class.getDeclaredFields();
            for (Field field : fields) {
                fieds.put(GeologyModelLayer.Cp.getName(field.getName()), field.getName());
                fieldWithValue.put(field.getName(), null);
            }
        } else {
            Field[] fields = geologyModel.getClass().getDeclaredFields();
            for (Field field : fields) {
                fieds.put(GeologyModelLayer.Cp.getName(field.getName()), field.getName());
                fieldWithValue.put(field.getName(), getFieldValueByFieldName(field.getName(), geologyModel));
            }
        }
        model.addAttribute("fields", fieds);
        model.addAttribute("objid", objid);
        model.addAttribute("fieldWithValue", fieldWithValue);
        return "attrInfo";
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
