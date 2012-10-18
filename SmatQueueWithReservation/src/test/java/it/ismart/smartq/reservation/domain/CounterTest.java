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

import junit.framework.Assert;

import org.joda.time.Duration;
import org.joda.time.LocalTime;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @date $Date$
 * @revision $Revision$
 * @author $Author$
 * 
 *         File : $HeadURL:
 *         https://smatq-with-reservation.googlecode.com/svn/trunk
 *         /SmatQueueWithReservation
 *         /src/test/java/it/ismart/smartq/reservation/domain/CounterTest.java $
 * 
 */
public class CounterTest {

	WorkingUnit simpleWU;
	Counter simpleNonActiveCounter;
	Counter simpleActiveCounter;

	@Before
	public void initTest() {

		Service service = new Service("34", new Duration(5 * 60 * 1000), "service");

		new LocalTime();
		simpleWU = new WorkingUnit("03", LocalTime.now(), service);

		simpleNonActiveCounter = new Counter("91", "simpleCounter");
		simpleActiveCounter = new Counter("82", "counter_82", true, true);
	}

	@Test
	public void testNewNonActiveCounter() {

		Assert.assertFalse(simpleNonActiveCounter.isFree());
		Assert.assertFalse(simpleNonActiveCounter.isActive());

	}

	@Test
	public void testNewActiveCounte() {

		Assert.assertTrue(simpleActiveCounter.isFree());
		Assert.assertTrue(simpleActiveCounter.isActive());

	}

	@Test
	public void testServeWorkingUnit() {

		Assert.assertTrue(simpleActiveCounter.isFree());
		Assert.assertTrue(simpleActiveCounter.isActive());

		LocalTime currTime = LocalTime.now();
		simpleActiveCounter.serveWoringUnit(simpleWU, currTime);

		Assert.assertFalse(simpleActiveCounter.isFree());
		Assert.assertTrue(simpleActiveCounter.isActive());

		Assert.assertEquals((currTime.toDateTimeToday().plus(simpleWU.getDuration())).toLocalTime(),
				simpleActiveCounter.getEndTimeCurrentWU());

	}
}
