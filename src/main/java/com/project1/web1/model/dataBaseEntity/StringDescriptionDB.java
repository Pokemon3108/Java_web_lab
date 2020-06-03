package com.project1.web1.model.dataBaseEntity;

import javax.persistence.*;

@Entity
@Table (name="string_description")
public class StringDescriptionDB {

    @Id
    @GeneratedValue
    private Long id;

    private Integer processId;
    private String polyndrom;
    private int length;

    public StringDescriptionDB() { }

    public StringDescriptionDB(Integer processId, String polyndrom, Integer length){
        this.processId=processId;
        this.polyndrom=polyndrom;
        this.length=length;
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

    public String getPolyndrom() {
        return polyndrom;
    }

    public void setPolyndrom(String polyndrom) {
        this.polyndrom = polyndrom;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
