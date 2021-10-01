package myPackage;

public class InvoiceGenrator {
	static final int COST_PER_TIME=1;
	static final double MINIMUM_COST_PER_KM=10;

	public double calculateFare(double distance,int time) {
		return MINIMUM_COST_PER_KM*distance+time*COST_PER_TIME;
	}
}
