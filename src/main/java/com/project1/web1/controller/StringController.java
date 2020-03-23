package com.project1.web1.controller;

import com.project1.web1.application.EmptyStringException;
import com.project1.web1.application.MyIllegalArgumentException;

import com.project1.web1.model.StringDescription;
import com.project1.web1.service.StringDescriptionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class StringController {

    static final Logger logger=LogManager.getLogger(StringController.class);

    @RequestMapping("/stringInfo")
    public StringDescription decript(@RequestParam() String str) {
        StringDescriptionService service=new StringDescriptionService();



        if (str=="") {
            logger.info("Error. Bad request. String is empty");
            throw new EmptyStringException();
        }
        if (str.length()>20) {
            logger.info("Error. Internal server error.String is: "+str);
            throw new MyIllegalArgumentException();
        }

        logger.info("Operation is good. String is: "+str);

        return new StringDescription(service.isPolyndrom(str), service.StringLength(str));
    }

}
