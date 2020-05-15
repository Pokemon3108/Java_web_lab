package com.project1.web1.controller;

import com.project1.web1.application.EmptyStringException;
import com.project1.web1.application.MyIllegalArgumentException;

import com.project1.web1.model.*;
import com.project1.web1.service.*;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


@RestController
public class StringController {

    @Autowired
    private CacheService cacheService;

    @Autowired
    private CounterService counterService;

    @Autowired
    private StringDescriptionService stringService;

    @Autowired
    private ValidationService validationService;

    @Autowired
    private StatisticService statisticService;

    @RequestMapping("/stringInfo")
    public StringDescription decript(@RequestParam String str) {
        return stringService.formResponse(str);
    }

    @RequestMapping("/counter")
    public CounterService getCounterService(){
        counterService.increment();
        return counterService;
    }

    @PostMapping("/stringInfoJson")
    public StringDescription getJsonDescript(@RequestBody StringDto str){
        return stringService.formResponse(str.getStr());
    }


    @RequestMapping("/stringListInfo")
    public List<StringDescription> getListStringsDescript(@RequestBody ListStringDto list){
        List<StringDescription> descriptionList=new ArrayList<>();
        descriptionList=stringService.getListDescription(list);
        return descriptionList;
    }

    @PostMapping("/statistic")
    public StatisticDto getStatistic(@RequestBody ListStringDto list){
        return statisticService.getStatistic(list);
    }

    
}
