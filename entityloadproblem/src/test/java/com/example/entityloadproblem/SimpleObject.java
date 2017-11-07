package com.example.entityloadproblem;

import com.example.entityloadproblem.app.EntityA0;
import com.example.entityloadproblem.app.EntityA1;
import com.example.entityloadproblem.app.StringValue;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class SimpleObject {
    private int port = 8080;

    TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void post() throws JSONException, IOException {
        EntityA0 doa = buildEntityA0();
        ResponseEntity<EntityA0> entity = restTemplate.postForEntity(
                IntegrationTestUtils.buildEndPointUrl(port, "sync/entity"),
                doa,
                EntityA0.class);
        EntityA0 body = entity.getBody();
        Optional<EntityA0> byId = Optional.of(restTemplate.getForObject(IntegrationTestUtils.buildEndPointUrl(port, "entity", body.getId(),4), EntityA0.class));
        Assert.assertTrue(byId.isPresent());
        Assert.assertTrue(Optional.ofNullable(byId.get().getEntityAS()).isPresent());
        Assert.assertTrue(!byId.get().getEntityAS().isEmpty());
        EntityA1 entityA10 = (EntityA1) byId.get().getEntityAS().get(0);
        Assert.assertTrue(Optional.ofNullable(entityA10.getValues()).isPresent());
        Assert.assertTrue(!entityA10.getValues().isEmpty());
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port+"/" + uri;
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
