package myPackage;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class InvoiceGenratorTest {

	@Test
	public void givenDistanceANdTimeSHouldReturnTotalFare() {
	InvoiceGenrator invoiceGenerator=	new InvoiceGenrator();
	double distance=2.0;
	int time=5;
	double fare=invoiceGenerator.calculateFare(distance, time);
	Assert.assertEquals(25, fare);
	}

}
