package com.project1.web1.controller;

import com.project1.web1.application.EmptyStringException;
import com.project1.web1.application.MyIllegalArgumentException;

import com.project1.web1.model.StringDescription;
import com.project1.web1.service.CacheService;
import com.project1.web1.service.StringDescriptionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class StringController {

    static final Logger logger=LogManager.getLogger(StringController.class);

    @Autowired
    private CacheService cacheService;

    @RequestMapping("/stringInfo")
    public StringDescription decript(@RequestParam() String str) {
        StringDescriptionService service=new StringDescriptionService();



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
        StringDescription description=new StringDescription(service.isPolyndrom(str), service.StringLength(str));
        cacheService.setDescription(str,description);
        return description;
    }

}
