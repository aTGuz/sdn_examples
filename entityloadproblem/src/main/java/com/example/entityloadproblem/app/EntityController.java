package com.example.entityloadproblem.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/")
@Transactional
public class EntityController {
    @Autowired
    EntityService entityService;

    private final static Logger log = LoggerFactory.getLogger(EntityController.class);

    @RequestMapping(value = "sync/entity",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public  EntityA0 sync(@RequestBody EntityA0 entityA0) throws IOException {
        log.info("Synchronizing object: "+entityA0);
        entityService.save(entityA0);
        return entityA0;
    }

    @RequestMapping(value = "entity/{id}/{depth}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public EntityA0 getObject(@PathVariable("id") String id,@PathVariable("depth") int depth) {
        log.info("Executing get object extId: "+id);
        EntityA0 entityA0 = entityService.findEntityByDeth(new Long(id),depth);
        return entityA0;
    }

}
