/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (c) I-Smart S.R.L., 2012
 *
 * This unpublished material is proprietary to I-Smart S.R.L.
 * All rights reserved. The methods and techniques described
 * herein are considered trade secrets and/or confidential.
 * Reproduction or distribution, in whole  or in part, is
 * forbidden except by express written permission of I-Smart S.R.L.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

package it.ismart.smartq.reservation.domain;

import org.joda.time.Duration;
import org.joda.time.LocalTime;

/**
 * 
 * @date $Date$
 * @revision $Revision$
 * @author $Author$
 * 
 *         File : $HeadURL$
 * 
 */
public class WorkingUnit {

	/**
	 * ID
	 */
	private String ID;

	/**
	 * Arriving time
	 */
	private LocalTime Hr;

	/**
	 * Duration
	 */
	private Duration duration;

	/**
	 * Service
	 */
	private Service service;

	/**
	 * @param iD
	 * @param hr
	 * @param duration
	 * @param service
	 */
	public WorkingUnit(final String iD, final LocalTime hr, final Duration duration, final Service service) {
		super();
		ID = iD;
		Hr = hr;
		this.duration = duration;
		this.service = service;
	}

	/**
	 * 
	 */
	public WorkingUnit(final String iD, final LocalTime hr, final Service service) {
		super();
		ID = iD;
		Hr = hr;
		this.service = service;
		long tevc = service.getTevc().getStandardSeconds();
		this.duration = new Duration(Math.round(tevc * 1000 * Math.random()));
	}

	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(final String iD) {
		ID = iD;
	}

	/**
	 * @return the hr
	 */
	public LocalTime getHr() {
		return Hr;
	}

	/**
	 * @param hr
	 *            the hr to set
	 */
	public void setHr(final LocalTime hr) {
		Hr = hr;
	}

	/**
	 * @return the duration
	 */
	public Duration getDuration() {
		return duration;
	}

	/**
	 * @param duration
	 *            the duration to set
	 */
	public void setDuration(final Duration duration) {
		this.duration = duration;
	}

	/**
	 * @return the service
	 */
	public Service getService() {
		return service;
	}

	/**
	 * @param service
	 *            the service to set
	 */
	public void setService(final Service service) {
		this.service = service;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WorkingUnit [ID=" + ID + ", Hr=" + Hr + ", duration=" + duration + ", service=" + service.toString() + "]";
	}

}
