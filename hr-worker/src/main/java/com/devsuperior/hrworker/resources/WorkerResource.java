package com.devsuperior.hrworker.resources;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

    @Value("${test.config}")
    private String testConfig;

    @Autowired
    private Environment env;

    @Autowired
    private WorkerRepository repository;

    @GetMapping("/configs")
    public ResponseEntity<Void> getConfigs() {

        // try{
        //   Thread.sleep(3000L);
        //  }catch (InterruptedException e){
        //   e.printStackTrace();
        // }

        logger.info("CONFIG = " + testConfig);

        return ResponseEntity.noContent().build();
    }



    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {

       // try{
         //   Thread.sleep(3000L);
      //  }catch (InterruptedException e){
         //   e.printStackTrace();
       // }

        logger.info("PORT = " + env.getProperty("local.server.port"));

        return ResponseEntity.ok(repository.findAll());
    }



    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        logger.info("PORT = " + env.getProperty("local.server.port"));

        return ResponseEntity.ok(repository.findById(id).get());

    }

}
