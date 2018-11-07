package com.xidian.thriftshop.Handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GobalException {
    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    private Map<String,Object> exceptionHandler(Exception e){
        Map<String,Object> modelMap=new HashMap<>() ;
        modelMap.put("success",modelMap);
        modelMap.put("errMassage",e.getMessage());
        return modelMap;
    }
}
