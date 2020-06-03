package com.project1.web1.repos;

import com.project1.web1.model.dataBaseEntity.Processes;
import org.springframework.data.repository.CrudRepository;

public interface ProcessesRepos extends CrudRepository<Processes, Long> {
    Processes findByProcessId(Integer processId);
}
