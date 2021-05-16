package bex.aq.sitemon.settings;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Container-klass som representerar det data som tabellen "sm_settings" innehåller.
 *
 * @author Mathias Dicklén
 * @version 1.0
 */
@SuppressWarnings("DesignForExtension") @Entity
public class SmSettings
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer nrOfWebSites;
	private String statusReportTimeStr;
	private String statusReportMail;
	private Boolean statusReportActive;

	public  Integer getId()
	{
		return id;
	}

	public  void setId(final Integer aId)
	{
		id = aId;
	}

	public  Integer getNrOfWebSites()
	{
		return nrOfWebSites;
	}

	public  void setNrOfWebSites(final Integer aNrOfWebSites)
	{
		nrOfWebSites = aNrOfWebSites;
	}

	public  String getStatusReportTimeStr()
	{
		return statusReportTimeStr;
	}

	public  void setStatusReportTimeStr(final String aStatusReportTimeStr)
	{
		statusReportTimeStr = aStatusReportTimeStr;
	}

	public  String getStatusReportMail()
	{
		return statusReportMail;
	}

	public  void setStatusReportMail(final String aStatusReportMail)
	{
		statusReportMail = aStatusReportMail;
	}

	public  Boolean getStatusReportActive()
	{
		return statusReportActive;
	}

	public  void setStatusReportActive(final Boolean aStatusReportActive)
	{
		statusReportActive = aStatusReportActive;
	}

	@Override public  String toString()
	{
		return "SmSettings{" + "id=" + id + ", nrOfWebSites=" + nrOfWebSites + ", statusReportTimeStr='"
				+ statusReportTimeStr + '\'' + ", statusReportMail='" + statusReportMail + '\''
				+ ", statusReportActive=" + statusReportActive + '}';
	}
}
