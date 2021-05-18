package bex.aq.sitemon.settings;

import bex.aq.sitemon.error.SmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST-API-klass för att hantera olika anrop som har med inställningar att göra.
 *
 * @author Mathias Dicklén
 * @version 1.0
 */
@RestController
public class SmSettingsController
{
	@Autowired
	private SmSettingsRepository sitemonSettingsRepository; //Metoder för att hantera data mot tabellen "sitemon_settings".   

	/**
	 * Hämtar alla settings.
	 * @return En lista av settings.
	 */
	@GetMapping(path="/getAllSettings", produces = "application/json")
	public final Iterable<SmSettings> getAllSettings()
	{
		return sitemonSettingsRepository.findAll();
	}

	/**
	 * Hämtar ut en setting efter det id som man anger.
	 * @param id Ett id.
	 * @return En setting.
	 */
	@GetMapping(path="/getSettingWithId/{id}", produces = "application/json")
	public final SmSettings getSettingWithId(@PathVariable final Integer id)
	{
		return sitemonSettingsRepository.findSettingById(id);
	}

	/**
	 * Lagrar antal sidor och uppdaterar antalet iFrames.
	 * @param nrOfSitesField  Antalet sidor som ska användas.
	 * @return  Ok i json om allt gick bra.
	 */
	@PostMapping(path="/postNrOfSites", produces = "application/json")
	public final ResponseEntity<String> postNrOfSites(@RequestParam final Integer nrOfSitesField)
	{
		ResponseEntity<String> rValue;
		try
		{
			SmSettings smSettings =sitemonSettingsRepository.getFirstByIdGreaterThanEqual(1);
			if(smSettings == null)
			{
				throw new SmException(SmException.PRE_ERR+"Inställningar saknas i tabellen sm_settings.");
			}
			smSettings.setNrOfWebSites(nrOfSitesField);
			sitemonSettingsRepository.save(smSettings);
			rValue =  new ResponseEntity<>("(i) Antal sidor är uppdaterat till "+smSettings.getNrOfWebSites(), HttpStatus.OK);
		}
		catch (final Exception e)
		{
			e.printStackTrace(); //Ge stacktrace i debug.
			throw new SmException(SmException.PRE_ERR_DEFAULT + e);  //Visa lite info till klienten.
		}
		return rValue;
	}

	/**
	 *  POST för att hantera när användaren ändrar på inställningar som har med sända rapporten att göra.
	 * @param timeField Tid när rapport ska sändas.
	 * @param emailField Mail dit rapporten dagligen ska sändas.
	 * @param activateSendReportChk  Checkbox som aktiverar sändingen eller inte.
	 * @return  JSON-svar om man har lyckats eller inte.
	 */
	@PostMapping(path="/postReportSettings", produces = "application/json")
	public final ResponseEntity<String> postReportSettings(@RequestParam final String timeField, @RequestParam final String emailField,  @RequestParam final Boolean activateSendReportChk)
	{
		 ResponseEntity<String> rValue;
		 try
		 {
			SmSettings smSettings =  sitemonSettingsRepository.getFirstByIdGreaterThanEqual(1);
			 if(smSettings == null)
			 {
				 throw new SmException(SmException.PRE_ERR+"Inställningar saknas i tabellen sm_settings.");
			 }
			 smSettings.setStatusReportTimeStr(emailField);
			 smSettings.setStatusReportMail(emailField);
			 smSettings.setStatusReportActive(activateSendReportChk);
			 sitemonSettingsRepository.save(smSettings);
		 	rValue = new ResponseEntity<>("(!) Inställningar för tidsrapport är nu uppdaterad.", HttpStatus.OK);
		 }
		 catch (final Exception e)
		 {
		 	e.printStackTrace();
		 	throw new SmException(SmException.PRE_ERR_DEFAULT+e);
		 }
		 return rValue;
	}

}
