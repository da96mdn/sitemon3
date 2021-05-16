package bex.aq.sitemon.jaas;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

/**
 * Klass för att testa JAAS auktorisering
 * @author Mathias Dicklén
 * @version 1.0
 */
public class JaasAuthenticationTest
{
	/**
	 * Main-test metod.        
	 * @param args Argument in.
	 */
	public static void main(String[] args)
	{
		System.setProperty("java.security.auth.login.config","jaas.config");
		String userName = "myName";
		String password = "myPassword";
		try
		{
			LoginContext lc = new LoginContext("Test", new TestCallbackHandler(userName, password));
			lc.login();
		}
		catch (LoginException e)
		{
			e.printStackTrace();
		}  
	}
}
