package vehicle;

public class Car extends Vehicle {

	private int carCapacity;

	public int getCarCapacity() {
		return carCapacity;
	}
		
	//validate the car capacity
	public boolean setCarCapacity(int carCapacity) {
		this.carCapacity = carCapacity;
		if(carCapacity >= 4 && carCapacity <= 6) {
			return true;
		} else {
			return false;
		}
	}

}
