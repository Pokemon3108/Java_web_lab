package com.project1.web1.model;

public class StringDescription {

    private String polyndrom;
    private int stringLength;

    public StringDescription(String polyndrom, int len) {
        this.polyndrom = polyndrom;
        this.stringLength=len;
    }


    public String getPolyndrom() {
        return polyndrom;
    }

    public void setPolyndrom(String polyndrom) {
        this.polyndrom = polyndrom;
    }


    public int getStringLen() {
        return stringLength;
    }

    public void setStringLen(int stringLen) {
        this.stringLength = stringLen;
    }

}
