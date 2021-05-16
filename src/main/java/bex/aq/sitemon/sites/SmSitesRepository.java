package bex.aq.sitemon.sites;

import org.springframework.data.repository.CrudRepository;

/**
 * JPA Interface för att styra olika SQL-satser mot tabellen "sm_sites".
 *
 * @author Mathias Dicklén
 * @version 1.0
 */
public interface SmSitesRepository extends CrudRepository<SmSites, Integer>
{
	SmSites findSmSitesById(final Integer id);
}
