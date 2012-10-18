/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (c) I-Smart S.R.L., 2012
 *
 * This unpublished material is proprietary to I-Smart S.R.L.
 * All rights reserved. The methods and techniques described
 * herein are considered trade secrets and/or confidential.
 * Reproduction or distribution, in whole  or in part, is
 * forbidden except by express written permission of I-Smart S.R.L.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

package it.ismart.smartq.reservation.model;

import org.joda.time.Duration;

/**
 * 
 * @date $Date$
 * @revision $Revision$
 * @author $Author$
 * 
 *         File : $HeadURL$
 * 
 */
public class Service {

	/**
	 * ID
	 */
	private String ID;

	/**
	 * mean evation time
	 */
	private Duration Tevc;

	/**
	 * name
	 */
	private String name;

	/**
	 * description
	 */
	private String description;

	/**
	 * @param iD
	 * @param tevc
	 * @param name
	 */
	public Service(final String iD, final Duration tevc, final String name) {
		super();
		ID = iD;
		Tevc = tevc;
		this.name = name;
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
	 * @return the tevc
	 */
	public Duration getTevc() {
		return Tevc;
	}

	/**
	 * @param tevc
	 *            the tevc to set
	 */
	public void setTevc(final Duration tevc) {
		Tevc = tevc;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(final String description) {
		this.description = description;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Service [ID=" + ID + ", Tevc=" + Tevc + ", name=" + name + ", description=" + description + "]";
	}

}
