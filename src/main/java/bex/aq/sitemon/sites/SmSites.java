package bex.aq.sitemon.sites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Container-klass som representerar det data som tabellen "sm_sites" innehåller.
 *
 * @author Mathias Dicklén
 * @version 1.0
 */
@Entity
public class SmSites
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String url;
	private Integer intervallNrOfMinutes;
	private Integer timeoutNrOfSeconds;
	private String mailAlarmIfSiteIsDown;
	private Boolean activateLarm;

	public Integer getId()
	{
		return id;
	}

	public void setId(final Integer aId)
	{
		id = aId;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(final String aUrl)
	{
		url = aUrl;
	}

	public Integer getIntervallNrOfMinutes()
	{
		return intervallNrOfMinutes;
	}

	public void setIntervallNrOfMinutes(final Integer aIntervallNrOfMinutes)
	{
		intervallNrOfMinutes = aIntervallNrOfMinutes;
	}

	public Integer getTimeoutNrOfSeconds()
	{
		return timeoutNrOfSeconds;
	}

	public void setTimeoutNrOfSeconds(final Integer aTimeoutNrOfSeconds)
	{
		timeoutNrOfSeconds = aTimeoutNrOfSeconds;
	}

	public String getMailAlarmIfSiteIsDown()
	{
		return mailAlarmIfSiteIsDown;
	}

	public void setMailAlarmIfSiteIsDown(final String aMailAlarmIfSiteIsDown)
	{
		mailAlarmIfSiteIsDown = aMailAlarmIfSiteIsDown;
	}

	public Boolean getActivateLarm()
	{
		return activateLarm;
	}

	public void setActivateLarm(final Boolean aActivateLarm)
	{
		activateLarm = aActivateLarm;
	}

	@Override public String toString()
	{
		return "SmSites{" + "id=" + id + ", url='" + url + '\'' + ", intervallNrOfMinutes=" + intervallNrOfMinutes
				+ ", timeoutNrOfSeconds=" + timeoutNrOfSeconds + ", mailAlarmIfSiteIsDown='" + mailAlarmIfSiteIsDown
				+ '\'' + ", activateLarm=" + activateLarm + '}';
	}
}
