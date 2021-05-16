package bex.aq.sitemon.jaas;

import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.io.IOException;
import java.util.Map;

public class TestLoginModule implements LoginModule
{
	private Subject subject;
	private CallbackHandler callbackHandler;
	private Map sharedState;
	private Map options;
	private  boolean succeeded = false;

	public TestLoginModule()
	{
		System.out.println("Login Module - constructor called");
	}


	/**
	 * Initialize this LoginModule.
	 *
	 * <p> This method is called by the {@code LoginContext}
	 * after this {@code LoginModule} has been instantiated.
	 * The purpose of this method is to initialize this
	 * {@code LoginModule} with the relevant information.
	 * If this {@code LoginModule} does not understand
	 * any of the data stored in {@code sharedState} or
	 * {@code options} parameters, they can be ignored.
	 *
	 * @param subject the {@code Subject} to be authenticated.
	 *
	 * @param callbackHandler a {@code CallbackHandler} for communicating
	 *                  with the end user (prompting for usernames and
	 *                  passwords, for example).
	 *
	 * @param sharedState state shared with other configured LoginModules.
	 *
	 * @param options options specified in the login
	 *                  {@code Configuration} for this particular
	 *                  {@code LoginModule}.
	 */
	public void initialize(Subject subject, CallbackHandler callbackHandler,
			Map<String,?> sharedState,
			Map<String,?> options)
	{
		 System.out.println("Login Module - initialize called");
		 this.subject = subject;
		 this.callbackHandler = callbackHandler;
		 this.sharedState = sharedState;
		 this.options = options;
		 System.out.println("testOption value: "+options.get("testOption"));
		 succeeded = false;
	}

	/**
	 * Method to authenticate a {@code Subject} (phase 1).
	 *
	 * <p> The implementation of this method authenticates
	 * a {@code Subject}.  For example, it may prompt for
	 * {@code Subject} information such
	 * as a username and password and then attempt to verify the password.
	 * This method saves the result of the authentication attempt
	 * as private state within the LoginModule.
	 *
	 * @exception LoginException if the authentication fails
	 *
	 * @return true if the authentication succeeded, or false if this
	 *                  {@code LoginModule} should be ignored.
	 */
	public boolean login() throws LoginException
	{
		System.out.println("Login Module - login called");
		if(callbackHandler == null)
		{
			throw  new LoginException("Oops, callbackhandler is null");
		}
		Callback[] callbacks = new Callback[2];
		callbacks[0] = new NameCallback("name:");
		callbacks[1] = new PasswordCallback("password:",false);
		try
		{
			callbackHandler.handle(callbacks);
		}
		catch (IOException e)
		{
			throw new LoginException("Oops, IOException calling handle on callbackHandler");
		}
		catch (UnsupportedCallbackException e)
		{
			throw new LoginException("Oops, UnsupportedCallbackException calling handle on callbackHandler");
		}

		NameCallback nameCallback = (NameCallback) callbacks[0];
		PasswordCallback passwordCallback = (PasswordCallback) callbacks[1];
		String name = nameCallback.getName();
		String password = new String (passwordCallback.getPassword());

		if("myName".equals(name) && "myPassword".equals(password))
		{
			System.out.println("SUCCESS! You get to log in!");
			succeeded = true;

		}
		else
		{
			System.out.println("FAILED! You don't get to log in!");
			succeeded = false;
			throw new FailedLoginException("Sorry! No login for you!");
		}
		return succeeded;
	}

	/**
	 * Method to commit the authentication process (phase 2).
	 *
	 * <p> This method is called if the LoginContext's
	 * overall authentication succeeded
	 * (the relevant REQUIRED, REQUISITE, SUFFICIENT and OPTIONAL LoginModules
	 * succeeded).
	 *
	 * <p> If this LoginModule's own authentication attempt
	 * succeeded (checked by retrieving the private state saved by the
	 * {@code login} method), then this method associates relevant
	 * Principals and Credentials with the {@code Subject} located in the
	 * {@code LoginModule}.  If this LoginModule's own
	 * authentication attempted failed, then this method removes/destroys
	 * any state that was originally saved.
	 *
	 * @exception LoginException if the commit fails
	 *
	 * @return true if this method succeeded, or false if this
	 *                  {@code LoginModule} should be ignored.
	 */
	public boolean commit() throws LoginException
	{
		System.out.println("Login Module - commit called");
		return succeeded;
	}

	/**
	 * Method to abort the authentication process (phase 2).
	 *
	 * <p> This method is called if the LoginContext's
	 * overall authentication failed.
	 * (the relevant REQUIRED, REQUISITE, SUFFICIENT and OPTIONAL LoginModules
	 * did not succeed).
	 *
	 * <p> If this LoginModule's own authentication attempt
	 * succeeded (checked by retrieving the private state saved by the
	 * {@code login} method), then this method cleans up any state
	 * that was originally saved.
	 *
	 * @exception LoginException if the abort fails
	 *
	 * @return true if this method succeeded, or false if this
	 *                  {@code LoginModule} should be ignored.
	 */
	public boolean abort() throws LoginException
	{
		System.out.println("Login Module - abort called");
		return false;
	}

	/**
	 * Method which logs out a {@code Subject}.
	 *
	 * <p>An implementation of this method might remove/destroy a Subject's
	 * Principals and Credentials.
	 *
	 * @exception LoginException if the logout fails
	 *
	 * @return true if this method succeeded, or false if this
	 *                  {@code LoginModule} should be ignored.
	 */
	public boolean logout() throws LoginException
	{
		System.out.println("Login Module - logout called");
		return false;
	}
}
