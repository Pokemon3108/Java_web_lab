package com.project1.web1.service;

import com.project1.web1.application.EmptyStringException;
import com.project1.web1.application.MyIllegalArgumentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {
    static final Logger logger= LogManager.getLogger(ValidationService.class);

    public boolean isGoodResponse(String str){
        boolean isGood=true;
        if (str=="" || str.length()>20) isGood=false;
        return isGood;
    }

   public void checkResponse(String str){
        if (str=="") {
            logger.info("Error. Bad request. String is empty");
            throw new EmptyStringException();
        }
        if (str.length()>20) {
            logger.info("Error. Internal server error. String is: "+str);
            throw new MyIllegalArgumentException();
        }
    }
}
