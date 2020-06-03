package com.project1.web1.repos;

import com.project1.web1.model.dataBaseEntity.InputData;

import org.springframework.data.repository.CrudRepository;

import java.util.List;



public interface InputDataRepos extends CrudRepository<InputData, Long> {
    List<InputData> findAllByProcessId(Integer processId);

}
