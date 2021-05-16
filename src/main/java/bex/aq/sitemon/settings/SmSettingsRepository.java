package bex.aq.sitemon.settings;

import org.springframework.data.repository.CrudRepository;

/**
 * JPA Interface för att styra olika SQL-satser mot tabellen "sm_settings".
 *
 * @author Mathias Dicklén
 * @version 1.0
 */
public interface SmSettingsRepository extends CrudRepository<SmSettings, Integer>
{
	/**
	 * Letar upp setting efter angivet id.
	 * @param id Ett id.
	 * @return SmSettings-data.
	 */
	SmSettings findSettingById(final Integer id);

	/**
	 * Hämtar det första Setting som hittas.
	 * @param id Ett id.
	 * @return En Setting.
	 */
	SmSettings getFirstByIdGreaterThanEqual(final Integer id);
}
