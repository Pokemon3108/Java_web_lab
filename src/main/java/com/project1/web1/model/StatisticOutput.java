package com.project1.web1.model;

public class StatisticOutput {
    StringDescription mostPopularResult;
    StringDescription longestString;
    StringDescription shortestString;

    public StatisticOutput(StringDescription mostPopularResult, StringDescription longestString, StringDescription shortestString) {
        this.mostPopularResult = mostPopularResult;
        this.longestString = longestString;
        this.shortestString = shortestString;
    }

    public StringDescription getMostPopularResult() {
        return mostPopularResult;
    }

    public void setMostPopularResult(StringDescription mostPopularResult) {
        this.mostPopularResult = mostPopularResult;
    }

    public StringDescription getLongestString() {
        return longestString;
    }

    public void setLongestString(StringDescription longestString) {
        this.longestString = longestString;
    }

    public StringDescription getShortestString() {
        return shortestString;
    }

    public void setShortestString(StringDescription shortestString) {
        this.shortestString = shortestString;
    }
}
