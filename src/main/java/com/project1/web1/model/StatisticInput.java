package com.project1.web1.model;

public class StatisticInput {
    Integer totalAmount;
    Integer invalidParameters;

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getInvalidParameters() {
        return invalidParameters;
    }

    public void setInvalidParameters(Integer invalidParameters) {
        this.invalidParameters = invalidParameters;
    }

    public StatisticInput(Integer totalAmount, Integer invalidParameters) {
        this.totalAmount = totalAmount;
        this.invalidParameters = invalidParameters;
    }
}
