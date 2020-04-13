package com.project1.web1.service;

import org.springframework.stereotype.Service;

@Service
public class StringDescriptionService {

    public String isPolyndrom(String str){

        String p="Yes";
        for (int i=0, j=str.length()-1; i<j; ++i, --j){
            if (str.charAt(i)!=str.charAt(j)) p="No";
        }

        return p;
    }

    public int StringLength(String str){
        return str.length();
    }
}
