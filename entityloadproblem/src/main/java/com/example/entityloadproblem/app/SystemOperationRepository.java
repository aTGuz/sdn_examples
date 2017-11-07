package com.example.entityloadproblem.app;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * Created by alejandro on 30/03/17.
 */
public interface SystemOperationRepository extends Neo4jRepository<EntityA,Long> {
    @Query("MATCH(n) DETACH DELETE n")
    void cleanDB();
}
