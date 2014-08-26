package Model;

public class MeasurementType {
	private String name;
	private String units;
	private Double min;
	private Double max;

	public MeasurementType(String name, String units) {
		//super();
		this.name = name.toLowerCase();
		this.units = units.toLowerCase();
	}
	
	public MeasurementType(String name, String units, Double min, Double max) {
		super();
		this.name = name;
		this.units = units;
		this.min = min;
		this.max = max;
	}

	public Double getMin() {
		return min;
	}

	public void setMin(Double min) {
		this.min = min;
	}



	public Double getMax() {
		return max;
	}



	public void setMax(Double max) {
		this.max = max;
	}



	public MeasurementType(String name)
	{
		this.name = name.toLowerCase();
		
		//determine units
		if(name.equals("weight"))
		{
			this.setUnits("lbs");
		}else if(name.equals("calories"))
		{
			this.setUnits("calories");
		}else
		{
			this.setUnits("hours");
		}
		if(name.equals("height"))
		{
			this.setUnits("inches");
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.toLowerCase();
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		MeasurementType other = (MeasurementType) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MeasurmentType [name=" + name + ", units=" + units + "]";
	}
	
	public boolean equals(MeasurementType toCompare)
	{
		boolean result = false;
		if(toCompare.getName().equals(this.getName()))
		{
			result = true;
		}
		
		return result;
	}
	
	public int getTypeID()
	{
		int result = 0;
		if(isWeight())
		{
			result = 1;
		}else if(isCalories())
		{
			result = 2;
		}else
			if(isExercise())
			{
				result = 3;
			}
			else
			{
			result = 4;
			}
		
		return result;
	}
	
	private boolean isWeight()
	{
		return getName().equals("weight");
		
	}
	
	/*
	private boolean isSleep()
	{
		return getName().equals("sleep");
		
	}
	*/
	
	private boolean isExercise(){
		return getName().equals("exercise");
	}
	
	private boolean isCalories()
	{
		return getName().equals("calories");
	}
}
