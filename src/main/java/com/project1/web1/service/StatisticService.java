package com.project1.web1.service;

import com.project1.web1.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StatisticService {

    @Autowired
    ValidationService validationService;

    @Autowired
    StringDescriptionService stringService;

    public StatisticDto getStatistic(ListStringDto list){
        int invalidStringsNumber=list.getList().stream()
                .filter(str->validationService.isGoodResponse(str.getStr())==false).
                        collect(Collectors.toList()).size();

        StatisticInput statisticInput=new StatisticInput(list.getList().size(), invalidStringsNumber);

        List<StringDescription> descriptionList=new ArrayList<>();
        descriptionList=stringService.getListDescription(list);

        StringDescription descriptionMin=new StringDescription();
        descriptionMin=descriptionList.stream()
                .min(Comparator.comparing(StringDescription::getStringLen))
                .orElseThrow(NoSuchElementException::new);

        StringDescription descriptionMax=new StringDescription();
        descriptionMax=descriptionList.stream()
                .max(Comparator.comparing(StringDescription::getStringLen))
                .orElseThrow(NoSuchElementException::new);

        StringDescription mostPopularResult=new StringDescription();
        int frequency=0;
        for (StringDescription str: descriptionList){
            if (frequency< Collections.frequency(descriptionList, str)) mostPopularResult=str;
        }


        StatisticOutput statisticOutput=new StatisticOutput(mostPopularResult,descriptionMax, descriptionMin);

        StatisticDto statistic=new StatisticDto(statisticInput, statisticOutput,descriptionList);
        return statistic;
    }
}
