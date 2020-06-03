package com.project1.web1.model.dataBaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;

@Entity
@Table (name="processes")
public class Processes {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private  boolean status;
    private Integer processId;

    public Processes(boolean status, Integer processId){
        this.status=status;
        this.processId=processId;
    }

    public Processes() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getProcessId() {
        return processId;
    }

    public void setProcessId(Integer processId) {
        this.processId = processId;
    }
}
