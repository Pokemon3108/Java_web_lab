package com.project1.web1.model;


import java.util.List;

public class StatisticDto {
    StatisticInput input;
    StatisticOutput output;
    List<StringDescription> list;

    public StatisticInput getInput() {
        return input;
    }

    public void setInput(StatisticInput input) {
        this.input = input;
    }

    public StatisticOutput getOutput() {
        return output;
    }

    public void setOutput(StatisticOutput output) {
        this.output = output;
    }

    public List<StringDescription> getList() {
        return list;
    }

    public void setList(List<StringDescription> list) {
        this.list = list;
    }

    public StatisticDto(StatisticInput input, StatisticOutput output, List<StringDescription> list) {
        this.input = input;
        this.output = output;
        this.list = list;
    }
}
