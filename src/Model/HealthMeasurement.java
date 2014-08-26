package Model;

import java.sql.Timestamp;

public class HealthMeasurement {
	private MeasurementType type;
	private Double amount;
	private Timestamp timestamp;
	
	public HealthMeasurement(MeasurementType type, Double amount, Timestamp timestamp) {
		super();
		
		this.type = type;
		this.amount = amount;
		this.timestamp = timestamp;
	}
	
	public MeasurementType getType() {
		return type;
	}
	public void setType(MeasurementType type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HealthMeasurement other = (HealthMeasurement) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Measurment [type=" + type + ", amount=" + amount + ", timestamp="
				+ timestamp + "]";
	}
	
}
