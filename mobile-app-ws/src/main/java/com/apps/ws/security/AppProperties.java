package com.apps.ws.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
//@ComponentScan({ "com.apps.ws.*" })
public class AppProperties {

	@Autowired
	private Environment environment;

	public String getTokenSecret() {
		return environment.getProperty("tokenSecret");
	}

}
