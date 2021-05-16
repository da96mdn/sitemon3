package bex.aq.sitemon.sites;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST-API-klass för att hantera de unika siternas inställningar.
 *
 * @author Mathias Dicklén
 * @version 1.0
 */
@RestController
public class SmSitesController
{
	@Autowired
	private SmSitesRepository smSitesRepository;   //Metoder för att hantera data mot tabellen "sitemon_settings".

	/**
	 * Hämtar data om samtliga siter.
	 * @return JSON-objekt en lista av alla siter.
	 */
	@GetMapping(path="/getAllSites", produces = "application/json")
	public final ResponseEntity<Iterable<SmSites>> getAllSites()
	{
		return new ResponseEntity<>(smSitesRepository.findAll(), HttpStatus.OK);
	}

	/**
	 * Hämtar ut data för en site beroende på valt id.
	 * @param id  Ett valt id.
	 * @return  JSON-objekt data av en site.
	 */
	@GetMapping(path="/getSiteWithId/{id}", produces = "application/json")
	public final ResponseEntity<SmSites> getSiteWithId(@PathVariable final Integer id)
	{
		SmSites smSite= smSitesRepository.findSmSitesById(id);
		return new ResponseEntity<>(smSite, HttpStatus.OK);
	}
}
