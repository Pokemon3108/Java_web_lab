package com.project1.web1.model.dataBaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "input_data")
public class InputData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer processId;
    private String inputText;

    public InputData() {}

    public InputData(Integer processId, String inputText) {
        this.processId = processId;
        this.inputText = inputText;
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

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }
}
