package com.project1.web1.service;

import com.project1.web1.model.ListStringDto;
import com.project1.web1.model.StringDescription;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class StringDescriptionService {

    static final Logger logger= LogManager.getLogger(StringDescriptionService.class);

    @Autowired
    private CacheService cacheService;

    @Autowired
    private CounterService counterService;

    @Autowired
    private ValidationService validationService;

    public String isPolyndrom(String str){

        String p="Yes";
        for (int i=0, j=str.length()-1; i<j; ++i, --j){
            if (str.charAt(i)!=str.charAt(j)) p="No";
        }

        return p;
    }

    public int getStringLength(String str){
        return str.length();
    }

    public StringDescription formResponse(String str){
        counterService.increment();

        validationService.checkResponse(str);


        if (cacheService.isInCashe(str)) {
            logger.info("Request has been taken from cache. String is: "+str);
            return cacheService.getDescription(str);
        }

        logger.info("Request is good (not from cache). String is: "+str);
        StringDescription description=new StringDescription(isPolyndrom(str), getStringLength(str));
        cacheService.setDescription(str,description);
        return description;
    }

    public List<StringDescription> getListDescription(ListStringDto list){
        return list.getList().stream()
                .filter(str-> validationService.isGoodResponse(str.getStr())==true )
                .map(str->formResponse(str.getStr()))
                .collect(Collectors.toList());
    }
}
