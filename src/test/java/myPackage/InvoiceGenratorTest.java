package myPackage;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class InvoiceGenratorTest {
	InvoiceGenrator invoiceGenerator=	new InvoiceGenrator();
	double distance=2.0;
	int time=5;
	
	@Test
	public void givenDistanceANdTimeSHouldReturnTotalFare() {
		double fare=invoiceGenerator.calculateFare(null, distance, time);
	Assert.assertEquals(25, fare);
	}


	
	@Test
    public void givenDistanceAndTimeForMultipleRidesShouldReturnAggregate() {
    	RidesFare[] rides = { new RidesFare(5.0,5), new RidesFare(2.0,2)};
    	InvoiceSummary summary = invoiceGenerator.calculateFare("normal",rides);
    	InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,77.0);
    	Assert.assertEquals(expectedInvoiceSummary,summary);
    }
    @Test
    public void givenUserIdShouldReturnListOfRidesAndInvoice() {
    	RidesFare[] ridesOfUser1 = { new RidesFare(5.0,5), new RidesFare(2.0,2)};
    	RidesFare[] ridesOfUser2 = { new RidesFare(3.0,6), new RidesFare(7.0,9)};
    	RidesFare[] ridesOfUser3 = { new RidesFare(2.0,7), new RidesFare(4.0,8)};
    	
    	Map<Integer,RidesFare[]> rideRepository = new HashMap<Integer, RidesFare[]>();
		rideRepository.put(1, ridesOfUser1);
		rideRepository.put(2, ridesOfUser2);
		rideRepository.put(3, ridesOfUser3);
		
		InvoiceSummary summary = invoiceGenerator.calculateFare("normal",rideRepository.get(1));
    	InvoiceSummary expctdInvoiceSummary = new InvoiceSummary(2,77.0);
    	Assert.assertEquals(expctdInvoiceSummary,summary);
    	InvoiceSummary summary1 = invoiceGenerator.calculateFare("normal",rideRepository.get(2));
    	InvoiceSummary expctdInvoiceSummary1 = new InvoiceSummary(2,115.0);
    	Assert.assertEquals(expctdInvoiceSummary1,summary1);
    }
    
    @Test
	public void givenUserIdShouldReturnListOfRidesAndSummaryInvoiceForPremium() {
    	RidesFare[] ridesOfUser1 = { new RidesFare(5.0,5), new RidesFare(2.0,3)};
    	RidesFare[] ridesOfUser2 = { new RidesFare(3.0,6), new RidesFare(7.0,9)};
    	RidesFare[] ridesOfUser3 = { new RidesFare(2.0,7), new RidesFare(4.0,8)};
    	
    	Map<Integer,RidesFare[]> rideRepository = new HashMap<Integer, RidesFare[]>();
		rideRepository.put(1, ridesOfUser1);
		rideRepository.put(2, ridesOfUser2);
		rideRepository.put(3, ridesOfUser3);
		
		InvoiceSummary summary = invoiceGenerator.calculateFare("premium",rideRepository.get(1));
		InvoiceSummary expctdInvoiceSummary = new InvoiceSummary(2,121.0);
    	Assert.assertEquals(expctdInvoiceSummary,summary);
	}
}
