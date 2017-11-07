package com.example.entityloadproblem;

import com.example.entityloadproblem.app.EntityA0;
import com.example.entityloadproblem.app.EntityA0Repository;
import com.example.entityloadproblem.app.EntityA1;
import com.example.entityloadproblem.app.StringValue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {PersistenceContextTest.class})
public class EntityA0ItTest {
    @Autowired
    EntityA0Repository entityA0Repository;

    @Test
    @Transactional
    public void save() throws IOException {
        EntityA0 entity = buildEntityA0();
        entityA0Repository.save(entity);
        Optional<EntityA0> byId = entityA0Repository.findById(entity.getId(), 3);
        assertTrue(byId.isPresent());
        assertTrue(Optional.ofNullable(byId.get().getEntityAS()).isPresent());
        assertTrue(!byId.get().getEntityAS().isEmpty());
        EntityA1 entityA10 = (EntityA1) byId.get().getEntityAS().get(0);
        assertTrue(Optional.ofNullable(entityA10.getValues()).isPresent());
        assertTrue(!entityA10.getValues().isEmpty());
    }

    private EntityA0 buildEntityA0() {
        EntityA0 entityA0 = new EntityA0();
        EntityA1 entityA1 = new EntityA1();
        entityA1.setValues(Arrays.asList(
                new StringValue("Test0"),
                new StringValue("Test1"),
                new StringValue("Test2"),
                new StringValue("Test3"),
                new StringValue("Test4")
        ));
        EntityA1 entityA2 = new EntityA1();
        entityA2.setValues(Arrays.asList(
                new StringValue("Test00"),
                new StringValue("Test11"),
                new StringValue("Test22"),
                new StringValue("Test33"),
                new StringValue("Test44")
        ));
        EntityA1 entityA3 = new EntityA1();
        entityA3.setValues(Arrays.asList(
                new StringValue("Test000"),
                new StringValue("Test111"),
                new StringValue("Test222"),
                new StringValue("Test333"),
                new StringValue("Test444")
        ));
        entityA0.setEntityAS(Arrays.asList(
                entityA1,
                entityA2,
                entityA3
        ));
        return entityA0;
    }
}
