package com.metacube.SpringSecurityJDBC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
/**
 * 
 * @author Sabir
 *
 */
@SpringBootApplication(exclude=HibernateJpaAutoConfiguration.class)
public class SpringSecurityJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJdbcApplication.class, args);
	}

}
