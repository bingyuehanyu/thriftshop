package com.xidian.thriftshop.Controller;

import com.xidian.thriftshop.Serives.AreaSerives;
import com.xidian.thriftshop.domain.Area;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/supperadmin")
public class AreaController {
    @Autowired
    private AreaSerives areaSerives;
    @RequestMapping(value = "/listArea",method = RequestMethod.GET)
    private Map<String,Object> listArea(){
        Map<String,Object> modelMap=new HashMap<>();
        List<Area> list=areaSerives.queryArea();
        modelMap.put("list",list);
        return modelMap;
    }

    @RequestMapping(value = "/queryAreaById",method = RequestMethod.GET)
    private Map<String,Object> queryAreaById(Integer areaId){
        Map<String,Object> modelMap=new HashMap<>();
        Area area=areaSerives.queryAreaById(areaId);
        modelMap.put("area", area);
        return modelMap;
    }

    @RequestMapping(value = "/updataArea",method = RequestMethod.POST)
    private Map<String,Object> updataArea(@RequestBody Area area){
        Map<String,Object> modelMap=new HashMap<>();
        boolean b = areaSerives.updataArea(area);
        modelMap.put("success",b);
        return modelMap;
    }

    @RequestMapping(value = "/insertArea",method = RequestMethod.POST)
    private Map<String,Object> insertArea(@RequestBody Area area){
        Map<String,Object> modelMap=new HashMap<>();
        boolean b = areaSerives.insertArea(area);
        modelMap.put("success",b);
        return modelMap;
    }

    @RequestMapping(value = "/deleteArea",method = RequestMethod.GET)
    private Map<String,Object> deleteArea(Integer areaId){
        Map<String,Object> modelMap=new HashMap<>();
        modelMap.put("success",areaSerives.deleteArea(areaId));
        return modelMap;
    }
}
