package com.project1.web1.model;

import java.util.List;

public class ListStringDto {

    List<StringDto> list;

    public ListStringDto(List<StringDto> list) {
        this.list = list;
    }
    public ListStringDto(){}

    public List<StringDto> getList() {
        return list;
    }

    public void setList(List<StringDto> list) {
        this.list = list;
    }

}
