package com.qa.cd.repository;

import com.qa.cd.app.model.Cd;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface CdRepository extends MongoRepository<Cd, Integer> {


}
