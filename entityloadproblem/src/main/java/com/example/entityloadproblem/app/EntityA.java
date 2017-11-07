package com.example.entityloadproblem.app;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.neo4j.ogm.annotation.NodeEntity;


@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = EntityA0.class, name = "EntityA0"),
        @JsonSubTypes.Type(value = EntityA1.class, name = "EntityA1")
})
@NodeEntity(label = "EntityA")
public abstract class EntityA extends AbstractNode {
}
