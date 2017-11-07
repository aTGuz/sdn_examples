package com.example.entityloadproblem.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EntityService {

    EntityA0Repository entityA0Repository;

    public EntityService(EntityA0Repository entityA0Repository) {
        this.entityA0Repository = entityA0Repository;
    }

    @Transactional
    public EntityA0 save(EntityA0 entityA0){
        return entityA0Repository.save(entityA0);
    }

    @Transactional
    public EntityA0 findEntityByDeth(Long id,int depth){
        return entityA0Repository.findById(id, depth).orElseGet(null);
    }


}
