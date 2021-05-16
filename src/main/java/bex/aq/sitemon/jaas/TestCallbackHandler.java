package bex.aq.sitemon.jaas;

import javax.security.auth.callback.*;

/**
 * Callback handler för JAAS auktorisering
 * @author Mathias Dicklén
 * @version 1.0
 */
public class TestCallbackHandler  implements CallbackHandler
{
	String name;
	String password;

	/**
	 * Konstruktor för callbackhandler
	 * @param aName  Ett användare-namn
	 * @param aPassword  Ett lösenord.
	 */
	public TestCallbackHandler(String aName, String aPassword)
	{
		System.out.println("Callback Handler - constructor called");
		this.name = aName;
		this.password = aPassword;
	}

	/**
	 *  Callback handler-metod.
	 * @param callbacks En array av callback.
	 * @throws UnsupportedCallbackException Ifall den inte stödjs.
	 */
	public void handle(Callback[] callbacks) throws UnsupportedCallbackException
	{
		System.out.println("Callback Handler - handle called");
		for(int i = 0;i < callbacks.length; i++)
		{
			if(callbacks[i] instanceof NameCallback)
			{
				NameCallback nameCallback = (NameCallback) callbacks[i];
				nameCallback.setName(name);
			}
			else if(callbacks[i] instanceof PasswordCallback)
			{
				PasswordCallback passwordCallback = (PasswordCallback) callbacks[i];
				passwordCallback.setPassword(password.toCharArray());
			}
			else
			{
				throw new UnsupportedCallbackException(callbacks[i],"The submitted callback is unsupported");
			}
		}
	}

}
