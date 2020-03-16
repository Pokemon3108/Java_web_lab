package com.project1.web1.controller;

import com.project1.web1.model.StringDescription;
import com.project1.web1.service.StringDescriptionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StringController {

    @RequestMapping("/stringInfo")
    public StringDescription decript(@RequestParam() String str) {
        return new StringDescription(StringDescriptionService.isPolyndrom(str), str.length());
    }

}
