package com.project1.web1.repos;

import com.project1.web1.model.dataBaseEntity.StatisticDB;
import org.springframework.data.repository.CrudRepository;


public interface StatisticDBRepos extends CrudRepository<StatisticDB, Long> {
    StatisticDB findByProcessId(Integer processId);
}
