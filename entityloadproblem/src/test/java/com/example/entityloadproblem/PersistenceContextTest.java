package com.example.entityloadproblem;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories("com.example.entityloadproblem.app")
@EnableTransactionManagement
@ComponentScan("com.example.entityloadproblem.app")
public class PersistenceContextTest {
	@Bean
	public org.neo4j.ogm.config.Configuration configuration() {
		return new org.neo4j.ogm.config.Configuration.Builder()
				.build();
	}

	@Bean
	public SessionFactory getSessionFactory() {
		return new SessionFactory(configuration(), "com.example.entityloadproblem.app");
	}

	@Bean
	public Neo4jTransactionManager transactionManager() throws Exception {
		return new Neo4jTransactionManager(getSessionFactory());
	}
}
