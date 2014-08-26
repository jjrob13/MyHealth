package Model;

import java.sql.Timestamp;
import java.util.Date;

public class Goal {
	private MeasurementType type;
	private Timestamp timestamp;
	private double amount;
	
	
	public Goal(MeasurementType type, double amount, Timestamp timestamp) {
		super();
		this.type = type;
		this.timestamp = timestamp;
		this.amount = amount;
	}
	
	public Goal(String category, double amount)
	{
		super();
		this.type = new MeasurementType(category);
		this.amount = amount;
		this.timestamp = new Timestamp(new Date().getTime());
	}
	
	public MeasurementType getType() {
		return type;
	}
	public void setType(MeasurementType type) {
		this.type = type;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String toString() {
		return "Measurment [type=" + type + ", amount=" + amount + ", timestamp="
				+ timestamp + "]";
	}
	
	
}
