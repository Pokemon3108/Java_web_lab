package com.project1.web1.model.dataBaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;

@Entity
@Table(name="statistic_data")
public class StatisticDB {


    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private Integer processId;
    private Integer totalAmount;
    private Integer invalidParams;

    private Integer mostPopularLen;
    private String mostPopularStr;
    private Integer longestResultLen;
    private String longestResultStr;
    private Integer shortestResultLen;
    private String shortestResultStr;

    public StatisticDB () {}

    public static class Builder{
        private Integer processId;
        private Integer totalAmount;
        private Integer invalidParams;

        private Integer mostPopularLen;
        private String mostPopularStr;
        private Integer longestResultLen;
        private String longestResultStr;
        private Integer shortestResultLen;
        private String shortestResultStr;

        public Builder(Integer processId){
            this.processId=processId;
        }


        public Builder totalAmount(Integer val){
            totalAmount=val;
            return this;
        }

        public Builder invalidParams(Integer val){
            invalidParams=val;
            return this;
        }

        public Builder mostPopularLen(Integer val){
            mostPopularLen=val;
            return this;
        }

        public Builder longestResultLen(Integer val){
            longestResultLen=val;
            return this;
        }

        public Builder shortestResultLen(Integer val){
            shortestResultLen=val;
            return this;
        }

        public Builder mostPopularStr(String str){
            mostPopularStr=str;
            return this;
        }

        public Builder longestResultStr(String str){
            longestResultStr=str;
            return this;
        }

        public Builder shortestResultStr(String str){
            shortestResultStr=str;
            return this;
        }

        public StatisticDB build(){
            return new StatisticDB(this);
        }

    }

    public StatisticDB(Builder builder) {
        mostPopularStr=builder.mostPopularStr;
        shortestResultLen=builder.shortestResultLen;
        longestResultStr=builder.longestResultStr;
        shortestResultStr=builder.shortestResultStr;
        longestResultLen=builder.longestResultLen;
        invalidParams=builder.invalidParams;
        totalAmount=builder.totalAmount;
        processId=builder.processId;
        mostPopularLen=builder.mostPopularLen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProcessId() {
        return processId;
    }

    public void setProcessId(Integer processId) {
        this.processId = processId;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getInvalidParams() {
        return invalidParams;
    }

    public void setInvalidParams(Integer invalidParams) {
        this.invalidParams = invalidParams;
    }

    public Integer getMostPopularLen() {
        return mostPopularLen;
    }

    public void setMostPopularLen(Integer mostPopularLen) {
        this.mostPopularLen = mostPopularLen;
    }

    public String getMostPopularStr() {
        return mostPopularStr;
    }

    public void setMostPopularStr(String mostPopularStr) {
        this.mostPopularStr = mostPopularStr;
    }

    public Integer getLongestResultLen() {
        return longestResultLen;
    }

    public void setLongestResultLen(Integer longestResultLen) {
        this.longestResultLen = longestResultLen;
    }

    public String getLongestResultStr() {
        return longestResultStr;
    }

    public void setLongestResultStr(String longestResultStr) {
        this.longestResultStr = longestResultStr;
    }

    public Integer getShortestResultLen() {
        return shortestResultLen;
    }

    public void setShortestResultLen(Integer shortestResultLen) {
        this.shortestResultLen = shortestResultLen;
    }

    public String getShortestResultStr() {
        return shortestResultStr;
    }

    public void setShortestResultStr(String shortestResultStr) {
        this.shortestResultStr = shortestResultStr;
    }
}
