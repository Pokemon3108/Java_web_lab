package com.project1.web1.controller;


import com.project1.web1.application.DataBaseException;


import com.project1.web1.model.ListStringDto;
import com.project1.web1.model.StatisticDto;
import com.project1.web1.model.StringDescription;
import com.project1.web1.model.StringDto;


import com.project1.web1.service.CounterService;
import com.project1.web1.service.DataBaseService;
import com.project1.web1.service.StatisticService;
import com.project1.web1.service.StringDescriptionService;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class StringController {

    @Autowired
    private CounterService counterService;

    @Autowired
    private StringDescriptionService stringService;

    @Autowired
    private StatisticService statisticService;

    @Autowired
    private DataBaseService dataBaseService;

    @RequestMapping("/stringInfo")
    public StringDescription decript(@RequestParam String str) {
        return stringService.formResponse(str);
    }

    @RequestMapping("/counter")
    public CounterService getCounterService() {
        counterService.increment();
        return counterService;
    }

    @PostMapping("/stringInfoJson")
    public StringDescription getJsonDescript(@RequestBody StringDto str) {
        return stringService.formResponse(str.getStr());
    }


    @RequestMapping("/stringListInfo")
    public List<StringDescription> getListStringsDescript(@RequestBody ListStringDto list) {
        List<StringDescription> descriptionList = new ArrayList<>();
        descriptionList = stringService.getListDescription(list);
        return descriptionList;
    }

    @PostMapping("/statistic")
    public StatisticDto getStatistic(@RequestBody ListStringDto list) {
        return statisticService.getStatistic(list);
    }

    @PostMapping("/statisticDB")
    public ResponseEntity<Integer> getId(@RequestBody ListStringDto list) {
        int id = dataBaseService.generateRandId();
        dataBaseService.writeInputDataToDB(list, id);
        StatisticDto statistic = statisticService.getStatistic(list);
        dataBaseService.writeStatisticToDB(statistic, id);
        dataBaseService.writeProcessToDB(true, id);
        return new ResponseEntity(id, HttpStatus.OK);
    }

    @RequestMapping("/getInfoById")
    public StatisticDto getStatisticFromDB(@RequestParam Integer id) {
        if (!dataBaseService.isGoodStatus(id)) throw new DataBaseException();
        return dataBaseService.getStatisticById(id);
    }


}
