package vehicle;

public class Motor extends Vehicle {
	
	private String services;
	

	public String getMotorServices() {
		return services;
	}
	
	//validate the motor service
	public boolean setMotorService(String services) {
		this.services = services;
		if(services.equals("Food") || services.equals("Ride")) {
			return true;
		} else {
			return false;
		}
	}

}
