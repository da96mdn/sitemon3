package bex.aq.sitemon.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Fångar upp exceptions ifall det händer under ett GET eller POST anrop.
 * Hanterar det sedan genom att svara i JSON tillbaka vad felet är.
 *
 * @author Mathias Dicklén
 * @version 1.0
 */
@ControllerAdvice
public class ExceptionHelper
{
	 private static final Logger logger = LoggerFactory.getLogger(ExceptionHelper.class);    //Loggning.

	/**
	 * För att hantera egna exceptions som ska kastas i koden.
	 * @param ex Egen variant av exception.
	 * @return JSON-objekt som innehåller meddelandet.
	 */
	@ExceptionHandler(value = {SmException.class})
	public ResponseEntity<Object> handleSmException(SmException ex)
	{
		logger.error("SmException: ", ex.getMessage());
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	/**
	 * Fångar fel och ger tillbaka en felmeddelande.
 	 * @param ex En exception.
	 * @return Ett JSON-bojekt med felmeddelande.
	 */
	@ExceptionHandler(value ={ Exception.class })
	 public ResponseEntity<Object> handleException(Exception ex) {
		 logger.error("Exception: ",ex.getMessage());
		 return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	 }
}
