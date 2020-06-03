package com.project1.web1.service;

import com.project1.web1.model.StatisticOutput;
import com.project1.web1.model.ListStringDto;
import com.project1.web1.model.StatisticDto;
import com.project1.web1.model.StatisticInput;
import com.project1.web1.model.StringDescription;
import com.project1.web1.model.dataBaseEntity.InputData;
import com.project1.web1.model.dataBaseEntity.Processes;
import com.project1.web1.model.dataBaseEntity.StatisticDB;
import com.project1.web1.model.dataBaseEntity.StringDescriptionDB;
import com.project1.web1.repos.InputDataRepos;
import com.project1.web1.repos.ProcessesRepos;
import com.project1.web1.repos.StatisticDBRepos;
import com.project1.web1.repos.StringDescriptionDBRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
public class DataBaseService {

    @Autowired
    private InputDataRepos inputDataRepos;

    @Autowired
    private ProcessesRepos processesRepos;

    @Autowired
    private StatisticDBRepos statisticDBRepos;

    @Autowired
    private StringDescriptionDBRepos stringDescriptionDBRepos;


    public Integer generateRandId(){
        return new Random().nextInt();
    }

    public void writeInputDataToDB(ListStringDto list, int process_id){
        list.getList().forEach(str->inputDataRepos.save(new InputData(process_id,str.getStr())));
    }

    public void writeStatisticToDB(StatisticDto statisticDto, int process_id){
        statisticDto.getList()
                .forEach(strDesc->stringDescriptionDBRepos.save(new StringDescriptionDB(process_id, strDesc.getPolyndrom(), strDesc.getStringLen())));

        StatisticDB statisticDB=new StatisticDB.Builder(process_id)
                .invalidParams(statisticDto.getInput().getInvalidParameters())
                .totalAmount(statisticDto.getInput().getTotalAmount())
                .mostPopularLen(statisticDto.getOutput().getMostPopularResult().getStringLen())
                .mostPopularStr(statisticDto.getOutput().getMostPopularResult().getPolyndrom())
                .longestResultLen(statisticDto.getOutput().getLongestString().getStringLen())
                .longestResultStr(statisticDto.getOutput().getLongestString().getPolyndrom())
                .shortestResultLen(statisticDto.getOutput().getShortestString().getStringLen())
                .shortestResultStr(statisticDto.getOutput().getShortestString().getPolyndrom())
                .build();

        statisticDBRepos.save(statisticDB);

    }

    public void writeProcessToDB(boolean status,int process_id){
        processesRepos.save(new Processes(status, process_id));
    }

    public StatisticDto getStatisticById(int process_id){
        StatisticDB statisticDB=statisticDBRepos.findByProcessId(process_id);
        List<StringDescriptionDB> dbListStringDescription=stringDescriptionDBRepos.findAllByProcessId(process_id);
        List<StringDescription> stringDescriptionList=dbListStringDescription
                .stream()
                .map(strDB->new StringDescription(strDB.getPolyndrom(), strDB.getLength()))
                .collect(Collectors.toList());

        StatisticInput input=new StatisticInput(statisticDB.getTotalAmount(), statisticDB.getInvalidParams());

        StringDescription mostPopularResult=new StringDescription(statisticDB.getMostPopularStr(), statisticDB.getMostPopularLen());
        StringDescription longestResult=new StringDescription(statisticDB.getLongestResultStr(), statisticDB.getLongestResultLen());
        StringDescription shortestResult=new StringDescription(statisticDB.getShortestResultStr(), statisticDB.getShortestResultLen());
        StatisticOutput output=new StatisticOutput(mostPopularResult, longestResult, shortestResult);

        StatisticDto statisticDto=new StatisticDto(input,output,stringDescriptionList);
        return statisticDto;
    }

    public boolean isGoodStatus(int process_id){
        Processes process=processesRepos.findByProcessId(process_id);
        return process.isStatus();
    }
}
