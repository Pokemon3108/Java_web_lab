package com.project1.web1.service;
import com.project1.web1.model.StringDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Component
public class CacheService {

    Map<String,StringDescription> cache;

    public CacheService(){
        cache=new HashMap<>();
    }
    public boolean isInCashe(String str){
        return cache.containsKey(str);
    }

    public StringDescription getDescription(String str){
        return cache.get(str);
    }

    public void setDescription(String str,StringDescription description){
        cache.put(str,description);
    }

}
