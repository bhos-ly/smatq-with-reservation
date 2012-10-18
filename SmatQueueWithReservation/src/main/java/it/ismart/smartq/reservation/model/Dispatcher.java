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

import java.util.ArrayList;
import java.util.List;

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
public class Dispatcher {

	/**
	 * List of active Counters
	 */
	private final List<Counter> activeCounterList;

	/**
	 * List of non active Counters
	 */
	private final List<Counter> nonActiveCounterList;

	/**
	 * @param activeCounterList
	 * @param nonActiveCounterList
	 */
	public Dispatcher(final List<Counter> activeCounterList, final List<Counter> nonActiveCounterList) {
		super();
		this.activeCounterList = activeCounterList;
		this.nonActiveCounterList = nonActiveCounterList;
	}

	/**
	 * 
	 */
	public Dispatcher() {
		super();
		this.activeCounterList = new ArrayList<Counter>();
		this.nonActiveCounterList = new ArrayList<Counter>();

	}

	/**
	 * This creates and add a new Counter into activeCounterList
	 */
	public void addNewActiveCounter() {
		String id = String.valueOf(this.activeCounterList.size());
		Counter newActiveCounter = new Counter(id, "counter_" + id, true, true);
		this.activeCounterList.add(newActiveCounter);
	}

	/**
	 * This disables a Counter through a given ID, the Counter is moved from
	 * activeCounterList to nonActiveCounterList
	 * 
	 * @param ID
	 *            the Id String of the counter to disable
	 */
	private void deactiveCounterbyId(final String ID) {
		for (Counter currCounter : this.activeCounterList) {
			if (currCounter.getID().equals(ID)) {
				if (currCounter.isActive()) {
					currCounter.setActive(false);
				}
				if (currCounter.isFree()) {
					currCounter.setFree(false);
				}
				this.activeCounterList.remove(currCounter);
				this.nonActiveCounterList.add(currCounter);
			}
		}
	}

	/**
	 * This disables a Counter , the Counter is moved from activeCounterList to
	 * nonActiveCounterList
	 * 
	 * @param currCounter
	 *            the counter to disable
	 */
	private void deactiveCounter(final Counter currCounter) {

		if (currCounter.isActive()) {
			currCounter.setActive(false);
		}
		if (currCounter.isFree()) {
			currCounter.setFree(false);
		}
		this.activeCounterList.remove(currCounter);
		this.nonActiveCounterList.add(currCounter);

	}

	/**
	 * This activates a Counter , the Counter is moved from nonActiveCounterList
	 * to activeCounterList
	 * 
	 * @param currCounter
	 *            the counter to activate
	 */
	private void activateCounter(final Counter currCounter) {

		if (!currCounter.isActive()) {
			currCounter.setActive(true);
		}
		if (!currCounter.isFree()) {
			currCounter.setFree(true);
		}
		this.nonActiveCounterList.remove(currCounter);
		this.activeCounterList.add(currCounter);
	}

	/**
	 * This methods iterates the list activeCounterList to determinate which is
	 * free and consigns them a client to serve, if present. The Dispatcher
	 * delegates someone else to calculate next client to serve
	 * 
	 * @param currentTime
	 */
	public void manageCounters(final LocalTime currentTime) {

		for (Counter currCounter : this.activeCounterList) {
			if (currCounter.isFree()) {
				/*
				 * CALL WUManager and consigns to the currentCounter the result
				 * of that call
				 */
				WorkingUnit workUnit = null;	// per ora
				if (workUnit != null) {
					currCounter.serveWoringUnit(workUnit, currentTime);
				}

			} else {
				if (currCounter.getEndTimeCurrentWU().equals(currentTime)) {
					/**
					 * CAMBIO DEL TESTIMONE
					 */
				}
				WorkingUnit workUnit = null;	// per ora
				if (workUnit != null) {
					currCounter.serveWoringUnit(workUnit, currentTime);
				}
			}
		}

	}

}
