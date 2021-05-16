package bex.aq.sitemon.error;

/**
 * Egna exception som kastas vid bestämda regler i koden.
 *
 * @author Mathias Dicklén
 * @version 1.0
 */
public class SmException extends RuntimeException
{
	public SmException(final String aErrorMessage)
	{
		super(aErrorMessage);
	}
}
