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
public class ReservationWorkingUnit extends WorkingUnit {

	/**
	 * Reservation time
	 */
	private LocalTime Hp;

	/**
	 * @param iD
	 * @param hr
	 * @param duration
	 * @param service
	 * @param hp
	 */
	public ReservationWorkingUnit(final String iD, final LocalTime hr, final Duration duration, final Service service, final LocalTime hp) {
		super(iD, hr, duration, service);
		Hp = hp;
	}

	/**
	 * @return the hp
	 */
	public LocalTime getHp() {
		return Hp;
	}

	/**
	 * @param hp
	 *            the hp to set
	 */
	public void setHp(final LocalTime hp) {
		Hp = hp;
	}

}
