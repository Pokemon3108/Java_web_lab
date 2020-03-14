package com.project1.web1;

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


    public static String isPolyndrom(String str){
       // boolean flag=true;
        String p="Да";
        for (int i=0, j=str.length()-1; i<j; ++i, --j){
            if (str.charAt(i)!=str.charAt(j)) p="Нет";
        }

       return p;
    }


}
