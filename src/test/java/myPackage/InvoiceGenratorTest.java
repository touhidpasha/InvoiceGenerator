package myPackage;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class InvoiceGenratorTest {
	InvoiceGenrator invoiceGenerator=	new InvoiceGenrator();
	double distance=2.0;
	int time=5;
	
	@Test
	public void givenDistanceANdTimeSHouldReturnTotalFare() {
		double fare=invoiceGenerator.calculateFare(distance, time);
	Assert.assertEquals(25, fare);
	}


	@Test
    public void givenDistanceAndTimeForMultipleRidesShouldReturnAggregate() {
    	RidesFare[] rides = { new RidesFare(5.0,5), new RidesFare(2.0,2)};
    	double fare = invoiceGenerator.calculateFare(rides);
    	Assert.assertEquals(77.0, fare, 0.0);
    }
	
}
