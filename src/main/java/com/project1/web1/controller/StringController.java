package com.project1.web1.controller;

import com.project1.web1.StringDescription;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StringController {

    @RequestMapping("/")
    public StringDescription decript(@RequestParam() String str) {
        return new StringDescription(StringDescription.isPolyndrom(str), str.length());
    }

}
