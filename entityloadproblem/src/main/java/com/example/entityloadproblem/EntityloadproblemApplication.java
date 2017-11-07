package com.example.entityloadproblem;

import com.example.entityloadproblem.app.SystemOperationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableNeo4jRepositories
@EnableConfigurationProperties(Neo4jProperties.class)
@Import(PersistenceContext.class)
@EnableTransactionManagement
public class EntityloadproblemApplication {

	private final static Logger log = LoggerFactory.getLogger(EntityloadproblemApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EntityloadproblemApplication.class, args);
	}
	@Bean
	public CommandLineRunner clean(SystemOperationRepository systemOperationRepository, Neo4jProperties neo4j) {
		if(!neo4j.clean())
			return null;
		log.info("Cleaing neo4j database:"+neo4j.getServer());
		return args -> {systemOperationRepository.cleanDB();};
	}
}
