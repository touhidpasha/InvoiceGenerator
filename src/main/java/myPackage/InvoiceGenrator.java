package myPackage;

public class InvoiceGenrator {
	private static final int COST_PER_MINUTE = 1;
	private double MIN_COST_PER_KILOMETER = 10.0;
	private static final double MINIMUM_FARE = 5;
	
	public double calculateFare(double distance, int time) {
		double totalFare = distance * MIN_COST_PER_KILOMETER + time * COST_PER_MINUTE;	
		return Math.max(totalFare,MINIMUM_FARE);
	}
	
	
	
	public InvoiceSummary calculateFare(RidesFare[] rides) {
		double totalFare = 0;
		int totalRides = 0;
		for(RidesFare ride:rides) {
			totalRides++;
			totalFare += this.calculateFare(ride.distance,ride.time);
		}
		
		return new InvoiceSummary(totalRides,totalFare);
	}
}
