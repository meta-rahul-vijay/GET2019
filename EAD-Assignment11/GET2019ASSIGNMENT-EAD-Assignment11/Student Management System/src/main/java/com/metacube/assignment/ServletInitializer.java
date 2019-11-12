package com.metacube.assignment;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
/**
 * 
 * @author Sabir
 *
 */
public class ServletInitializer extends SpringBootServletInitializer {
	/**
	 * 
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EadSession11AssignmentApplication.class);
	}

}
