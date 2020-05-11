package com.project1.web1.controller;

import com.project1.web1.application.EmptyStringException;
import com.project1.web1.application.MyIllegalArgumentException;

import com.project1.web1.model.ListStringDto;
import com.project1.web1.model.StringDescription;
import com.project1.web1.model.StringDto;
import com.project1.web1.service.CacheService;
import com.project1.web1.service.CounterService;
import com.project1.web1.service.StringDescriptionService;

import org.springframework.beans.factory.annotation.Autowired;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;


@RestController
public class StringController {

    static final Logger logger=LogManager.getLogger(StringController.class);

    @Autowired
    private CacheService cacheService;

    @Autowired
    private CounterService counterService;

    @Autowired
    private StringDescriptionService stringService;

    @RequestMapping("/stringInfo")
    public StringDescription decript(@RequestParam String str) {
        return formResponse(str);
    }

    @RequestMapping("/counter")
    public CounterService getCounterService(){
        counterService.increment();
        return counterService;
    }

    @PostMapping("/stringInfoJson")
    public StringDescription getJsonDescript(@RequestBody StringDto str){
        return formResponse(str.getStr());
    }


    @RequestMapping("/stringListInfo")
    public List<StringDescription> getListStringsDescript(@RequestBody ListStringDto list){
        List<StringDescription> descriptionList=new ArrayList<>();
        descriptionList=stringService.getListDescription(list.getList());

        return descriptionList;
    }

    private StringDescription formResponse(String str){
        counterService.increment();

        if (str=="") {
            logger.info("Error. Bad request. String is empty");
            throw new EmptyStringException();
        }
        if (str.length()>20) {
            logger.info("Error. Internal server error. String is: "+str);
            throw new MyIllegalArgumentException();
        }


        if (cacheService.isInCashe(str)) {
            logger.info("Request has been taken from cache. String is: "+str);
            return cacheService.getDescription(str);
        }

        logger.info("Request is good (not from cache). String is: "+str);
        StringDescription description=new StringDescription(stringService.isPolyndrom(str), stringService.getStringLength(str));
        cacheService.setDescription(str,description);
        return description;
    }
}
