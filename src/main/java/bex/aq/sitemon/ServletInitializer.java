package bex.aq.sitemon;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Initierar Spring Boot.
 * 
 * @author Mathias Dicklén
 * @version 1.0
 */
public class ServletInitializer extends SpringBootServletInitializer
{
	/**
	 * Konfigurerar upp de resurser som behövs.
	 * @param builder Spring- byggare.
	 * @return  Uppdaterad Spring-byggare.
	 */
	@Override protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
	{
		return builder.sources(SitemonApplication.class);
	}

}
