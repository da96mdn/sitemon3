package bex.aq.sitemon.error;

/**
 * Egna exception som kastas vid bestämda regler i koden.
 *
 * @author Mathias Dicklén
 * @version 1.0
 */
public class SmException extends RuntimeException
{
	public static final String PRE_ERR_DEFAULT = "(!) Ooops! Något gick fel. Vänligen kontakta administratören. Error: ";

	/**
	 * Konstruktor för egen exception
	 * @param aErrorMessage Ett meddelande.
	 */
	public SmException(final String aErrorMessage)
	{
		super(aErrorMessage);
	}
}
