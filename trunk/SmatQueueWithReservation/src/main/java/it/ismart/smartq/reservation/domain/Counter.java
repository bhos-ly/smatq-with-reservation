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
public class Counter {

	/**
	 * ID
	 */
	private String ID;

	/**
	 * name or description
	 */
	private String name;

	/**
	 * flag free
	 */
	private boolean free;

	/**
	 * flag active If a Counter is Acvite it can be free or non free. If a
	 * Counter is Non Active it can only be non free
	 */
	private boolean active;

	/**
	 * number of WorkingUnit served
	 */
	private int numberWUServed;

	/**
	 * end time of the current WorkingUnit
	 */
	private LocalTime endTimeCurrentWU;

	/**
	 * @param iD
	 * @param name
	 * @param free
	 * @param active
	 */
	public Counter(final String iD, final String name, final boolean free, final boolean active) {
		super();
		ID = iD;
		this.name = name;
		this.free = free;
		this.active = active;
		this.numberWUServed = 0;
		this.endTimeCurrentWU = null;
	}

	/**
	 * @param iD
	 * @param name
	 */
	public Counter(final String iD, final String name) {
		super();
		ID = iD;
		this.name = name;
		this.free = false;
		this.active = false;
		this.numberWUServed = 0;
		this.endTimeCurrentWU = new LocalTime();
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
	 * @return the free
	 */
	public boolean isFree() {
		return free;
	}

	/**
	 * @param free
	 *            the free to set
	 */
	public void setFree(final boolean free) {
		this.free = free;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(final boolean active) {
		this.active = active;
	}

	/**
	 * @return the numberWUServed
	 */
	public int getNumberWUServed() {
		return numberWUServed;
	}

	/**
	 * @param numberWUServed
	 *            the numberWUServed to set
	 */
	public void setNumberWUServed(final int numberWUServed) {
		this.numberWUServed = numberWUServed;
	}

	/**
	 * @return the endTimeCurrentWU
	 */
	public LocalTime getEndTimeCurrentWU() {
		return endTimeCurrentWU;
	}

	/**
	 * @param endTimeCurrentWU
	 *            the endTimeCurrentWU to set
	 */
	public void setEndTimeCurrentWU(final LocalTime endTimeCurrentWU) {
		this.endTimeCurrentWU = endTimeCurrentWU;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Counter [ID=" + ID + ", name=" + name + ", free=" + free + ", active=" + active + ", numberWUServed=" + numberWUServed
				+ ", endTimeCurrentWU=" + endTimeCurrentWU + "]";
	}

	/**
	 * This method put a Counter in busy mode, serving a giver client or serving
	 * a WorkingUnit
	 * 
	 * @param workUnit
	 * @param currentTime
	 */
	public void serveWoringUnit(final WorkingUnit workUnit, final LocalTime currentTime) {

		setFree(false);
		setEndTimeCurrentWU((currentTime.toDateTimeToday().plus(workUnit.getDuration())).toLocalTime());

	}

}
