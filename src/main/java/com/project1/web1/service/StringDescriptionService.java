package com.project1.web1.service;

public class StringDescriptionService {

    public String isPolyndrom(String str){

        String p="Да";
        for (int i=0, j=str.length()-1; i<j; ++i, --j){
            if (str.charAt(i)!=str.charAt(j)) p="Нет";
        }

        return p;
    }

    public int StringLength(String str){
        return str.length();
    }
}
