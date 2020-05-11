package com.project1.web1.service;

import com.project1.web1.model.StringDescription;
import com.project1.web1.model.StringDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StringDescriptionService {

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

    public List<StringDescription> getListDescription(List<StringDto> list){

        List<StringDescription> descriptionList=list.stream().map(str->{
            return new StringDescription(isPolyndrom(str.getStr()),getStringLength(str.getStr()));
        }).collect(Collectors.toList());

        return descriptionList;
    }

}
