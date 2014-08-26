package Interfaces;

public interface IDataControlCollection extends IDataControl{

	public abstract void updateData(Object object);
	public abstract void addData(Object object);
	public abstract void deleteData(Object object);
}
