package bex.aq.sitemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Övervakningsapplikation som utför kontroller på olika siter för att kolla så att de är responsiva.
 * Alarm kan aktiveras ifall en sida inte svarar längre och sänder då till vald e-post-adress.
 * Dagliga rapporter kan aktiveras vid en viss tidpunkt där status över siterna sänds.
 * 
 * @author Mathias Dicklén
 * @version 1.0
 */
@SpringBootApplication public class SitemonApplication
{
	/**
	 * Main-metod som startar upp Spring applikationen.
	 * @param args Ett antal argument.        hepp
	 */
	public static void main(String... args)
	{
		SpringApplication.run(SitemonApplication.class, args);
	}

}
