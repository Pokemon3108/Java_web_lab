package com.project1.web1.repos;

import com.project1.web1.model.dataBaseEntity.StringDescriptionDB;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StringDescriptionDBRepos extends CrudRepository<StringDescriptionDB, Long> {
    List<StringDescriptionDB> findAllByProcessId(Integer processId);
}
