package com.example.entityloadproblem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class PersistenceContext {
	@Autowired
	Neo4jProperties neo4j;

	@Bean
	public org.neo4j.ogm.config.Configuration configuration() {
		return new org.neo4j.ogm.config.Configuration.Builder()
									.connectionPoolSize(neo4j.getPort())
									.uri(neo4j.getUri())
									.build();
	}
}
