package bex.aq.sitemon.settings;

import bex.aq.sitemon.error.SmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST-API-klass för att hantera inställningar.
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
	 * @param nrOfSites  Antalet sidor som ska användas.
	 * @return  Ok i json om allt gick bra.
	 */
	@PostMapping(path="/postNrOfSites", produces = "application/json")
	public final ResponseEntity<String> postNrOfSites(@RequestParam final Integer nrOfSites)
	{
		ResponseEntity<String> rValue;
		try
		{
			SmSettings smSettings =sitemonSettingsRepository.getFirstByIdGreaterThanEqual(1);
			if(smSettings == null)
			{
				throw new SmException("(!) Inställningar saknas i tabellen sm_settings.");
			}
			smSettings.setNrOfWebSites(nrOfSites);
			sitemonSettingsRepository.save(smSettings);
			rValue =  new ResponseEntity<>("Antal sidor är uppdaterat till "+smSettings.getNrOfWebSites(), HttpStatus.OK);
		}
		catch (final Exception e)
		{
			e.printStackTrace(); //Ge stacktrace i debug.
			throw new SmException(SmException.PRE_ERR_DEFAULT + e);  //Visa lite info till klienten.
		}
		return rValue;
	}

}
